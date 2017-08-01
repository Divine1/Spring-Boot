package com.rw.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.rw.entity.ImageEntity;
import com.rw.repository.ImageRepository;

@Service
public class ImageService {

	private ImageRepository imageRepository;
	private ResourceLoader resourceLoader;
	private static String UPLOAD_ROOT = "upload-dir";
	
	
	@Autowired
	public ImageService(ImageRepository imageRepository,ResourceLoader resourceLoader) {
		this.imageRepository = imageRepository;
		this.resourceLoader = resourceLoader;
	}
	
	public Resource findOneImage(String filename){
		return resourceLoader.getResource("file:"+UPLOAD_ROOT+"/"+filename);
	}
	public void createImage(MultipartFile file) throws IOException{
		if(!file.isEmpty()){
			Files.copy(file.getInputStream(), Paths.get(UPLOAD_ROOT, file.getOriginalFilename()));
			imageRepository.save(new ImageEntity(file.getOriginalFilename()));
		}
	}
	public void deleteImage(String filename) throws IOException{
		ImageEntity imageEntity = imageRepository.findByName(filename);
		imageRepository.delete(imageEntity);
		Files.deleteIfExists(Paths.get(UPLOAD_ROOT, filename));
	}
	public Page<ImageEntity> findPage(Pageable pageable){
		
		return imageRepository.findAll(pageable);
	}
	
}
