package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.song;


public interface LookifyRepository  extends CrudRepository<song, Long> {
	List<song> findAll();
	List<song> findByArtist(String artist);
	List<song> findTop10ByOrderByRatingDesc();
}




