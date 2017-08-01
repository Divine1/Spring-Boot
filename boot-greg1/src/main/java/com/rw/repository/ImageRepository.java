package com.rw.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.rw.entity.ImageEntity;

public interface ImageRepository extends PagingAndSortingRepository<ImageEntity, Long>{
	
	public ImageEntity findByName(String name);
}
