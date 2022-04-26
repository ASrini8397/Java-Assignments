package com.ani.bookclub.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ani.bookclub.models.LibraryModel;
import com.ani.bookclub.services.LibraryService;

@Controller
public class LibraryController {
	
	@Autowired
	private LibraryService libServ;
	
//	RENDER THE CREATE PAGE - LIB
	@GetMapping("/library/new")
	public String newLibRender(@ModelAttribute("library") LibraryModel library,
								Model model) {
		List<LibraryModel> allDaLibs = libServ.allLibraries();
		model.addAttribute("allDaLibs", allDaLibs);
		return "/library/index.jsp";
	}
	
//	CREATE - POST METHOD FOR LIB
	@PostMapping("/library")
	public String createLib(@Valid @ModelAttribute("library") LibraryModel library, 
							BindingResult res) {
		if (res.hasErrors()) {
//			
			return "/library/index.jsp";
		} else {
//			save it to the DB
//			library.getBooks().add(bookObj)
			libServ.createLibrary(library);
			return "redirect:/library/new";
		}
	}
	

}