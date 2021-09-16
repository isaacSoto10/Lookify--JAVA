package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.models.song;
import com.example.demo.repositories.LookifyRepository;

@Service
public class LookifyService {
	private final LookifyRepository lookifyRepository;
	
	public LookifyService(LookifyRepository lookifyRepository ) {
		this.lookifyRepository = lookifyRepository;
	}
	
	public List<song> allSongs(){
		return lookifyRepository.findAll();
	}
	
	public song findSong(Long id) {
		Optional<song> optionalSong = lookifyRepository.findById(id);
		if(optionalSong.isPresent()) {
			return optionalSong.get();
		}
		else {
			return null;
		}
	}
	public song addSong(song melody) {
		
		return lookifyRepository.save(melody);
	
	}
	public void deleteSong(Long id) {
		lookifyRepository.deleteById(id);
	}
	
	public List<song> getTopTen(){
		return lookifyRepository.findTop10ByOrderByRatingDesc();
	}
	public List<song> getSearchSongs(String artist){
		return lookifyRepository.findByArtist(artist);
	}
	
	
}
