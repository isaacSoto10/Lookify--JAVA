package com.example.demo.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.models.song;
import com.example.demo.services.LookifyService;

@Controller
public class Maincontroller {
	private final LookifyService lookifyService;
	
	public Maincontroller(LookifyService lookifyService) {
		this.lookifyService = lookifyService;
	}
	
	
	@RequestMapping("/")
	public String index(Model model) {
		return "Lookify/index.jsp";
	}
	
	@RequestMapping("/Dashboard")
	public String dashboard(Model model) {
		List<song> songs = lookifyService.allSongs();
		model.addAttribute("songs", songs);
		return "Lookify/dashboard.jsp";
	}
	
	@RequestMapping("/songs/new")
	public String addNew(@Valid @ModelAttribute("addNew") song song,  Model model) {
		return "Lookify/new.jsp";
	}
	
	@RequestMapping("/songs/{id}")
	public String songs(@PathVariable("id")Long id, Model model) {
	song song = lookifyService.findSong(id);
	model.addAttribute("song", song);
	return "Lookify/song.jsp";
	}
	
	
	

	@RequestMapping(value="/process", method=RequestMethod.POST)
	public String process(@Valid @ModelAttribute("addNew") song song, BindingResult result, Model model) {
	    if (result.hasErrors()) {
			List<song> songs = lookifyService.allSongs();
			model.addAttribute("songs", songs);
	        return "Lookify/new.jsp";
	    }
	    else {
	        lookifyService.addSong(song);
	        return "redirect:/Dashboard";
	    }
	}
	
	@RequestMapping("/search/topten")
	public String topten(Model model) {
		List<song> songs = lookifyService.getTopTen();
		model.addAttribute("songs", songs);
		return "Lookify/topten.jsp";
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		lookifyService.deleteSong(id);
		return "redirect:/Dashboard";
	}
	
	@RequestMapping("/search/{artist}")
	public String search(@PathVariable("artist") String artist, Model model) {
		List<song> songs = lookifyService.getSearchSongs(artist);
		model.addAttribute("artist", artist);
		model.addAttribute("songs", songs);
		return "Lookify/search.jsp";
	}
	
	@PostMapping("/search")
	public String search(@RequestParam("artist") String artist) {
		return "redirect:/search/"+artist;
	}	

}
