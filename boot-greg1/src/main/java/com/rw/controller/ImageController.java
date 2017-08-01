package com.rw.controller;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.rw.entity.ImageEntity;
import com.rw.service.ImageService;

@Controller
public class ImageController {

	private ImageService imageService;

	public static final String BASE_PATH = "/images";
	public static final String FILENAME = "{filename:.+}";

	private ImageController() {

	}

	@Autowired
	public ImageController(ImageService imageService) {
		this.imageService = imageService;
	}

	@RequestMapping(value = "/")
	public String index(Model model, Pageable pageable) {

		Page<ImageEntity> page = imageService.findPage(pageable);
		model.addAttribute("page", page);
		return "index";
	}

	@RequestMapping(method = RequestMethod.GET, value = BASE_PATH + "/" + FILENAME + "/raw")
	@ResponseBody
	public ResponseEntity<?> oneRawImage(@PathVariable String filename) {

		try {
			Resource file = imageService.findOneImage(filename);
			return ResponseEntity.ok().contentLength(file.contentLength()).contentType(MediaType.IMAGE_JPEG)
					.body(new InputStreamResource(file.getInputStream()));
		} catch (IOException e) {
			return ResponseEntity.badRequest().body("couldn't find filename " + filename);
		}
	}

	@RequestMapping(method = RequestMethod.POST, value = BASE_PATH)
	@ResponseBody
	public ResponseEntity<?> createFile(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws URISyntaxException {

		try {
			imageService.createImage(file);
			/*return ResponseEntity.created(request.getURI().resolve(file.getOriginalFilename() + "/raw"))
					.body("successfully uploaded " + file.getOriginalFilename());*/
			
			URI locationUri =  new URI(request.getRequestURL().toString()+"/")
					.resolve(file.getOriginalFilename()+"/raw");
			return ResponseEntity.created(locationUri)
					.body("successfully uploaded " + file.getOriginalFilename());
			

		} catch (IOException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Failed to upload " + file.getOriginalFilename() + " => " + e.getMessage());
		}

	}

	@RequestMapping(method = RequestMethod.DELETE, value = BASE_PATH + "/" + FILENAME)
	@ResponseBody
	public ResponseEntity<?> deleteFile(@PathVariable String filename) {
		try {
			imageService.deleteImage(filename);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("successfully deleted " + filename);
		} catch (IOException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("failed to delete " + filename + " => " + e.getMessage());
		}

	}

	@RequestMapping(method = RequestMethod.GET, value = "/testget")
	@ResponseBody
	public String testget() {
		return "testing rest get api";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/testpost")
	@ResponseBody
	public String testpost(
			@RequestParam(value = "city", required = true /*
															 * ,defaultValue=
															 * "somecity"
															 */) String cityname) {
		return "testing rest post api: " + cityname;
	}
}
