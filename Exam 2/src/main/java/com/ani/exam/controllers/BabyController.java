package com.ani.exam.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ani.exam.models.BabyName;
//import com.ani.exam.models.Library;
//import com.ani.exam.models.LibraryModel;
import com.ani.exam.models.User;
import com.ani.exam.services.BabyService;
//import com.ani.exam.services.LibraryService;
import com.ani.exam.services.UserService;

@Controller
public class BabyController {
	
	@Autowired
	private BabyService babyServ;
//	@Autowired
//	private LibraryService libServ;
	@Autowired
	private UserService userService;
	
//	@GetMapping("/")
//	public String index() {
//		
//		return "index.jsp";
//	}
	
//	SHOW ALL THE BOOKS
	@GetMapping("/baby")
	public String index(Model model, HttpSession session) {
		
		Long userId = (Long) session.getAttribute("user_id");
//		check if userID is null
		if (userId == null) {
			return "redirect:/";
		} else {			
			List<BabyName> allbabes = babyServ.allBabyNames();
			model.addAttribute("allbabes", allbabes);
			
			User thisUser = userService.findOne(userId);
			model.addAttribute("thisUser", thisUser);
			return "redirect:/home";
		}
		
		
	}

	@GetMapping("/baby/{id}")
	public String showOne(@PathVariable("id") Long id, Model model) {
		BabyName oneBabyName = babyServ.findBaby(id);
//		System.out.println(oneBook.getTitle());
		model.addAttribute("oneBabyName", oneBabyName);
		return "/baby/show.jsp";
	}
	
	
//	@GetMapping("/new")
//	public String createBook(Model model) {
//		Book book = new Book();
//		model.addAttribute("book", book);
//		return "new.jsp";
//	}
//	---- CREATE - RENDER PAGE ------
	@GetMapping("/baby/new")
	public String createBabyName(@ModelAttribute("baby") BabyName baby,
							Model model, HttpSession sesh) {
		
//		Route Guard - check if user us in session
		Long userId = (Long) sesh.getAttribute("user_id");
//		check if userId is null
		if (userId == null) {
			return "redirect:/";
		} else {
	//	    pass in the logged in user
			User thisLoggedInUser = userService.findOne(userId);
			model.addAttribute("thisLoggedInUser", thisLoggedInUser);
	
	//		passes all the books
			List<BabyName> allbabes = babyServ.allBabyNames();
			model.addAttribute("allbabes", allbabes);
				
	//		passes all the libraries to select from
//			List<LibraryModel> alldaLibraries = libServ.allLibraries();
//			model.addAttribute("alldaLibraries", alldaLibraries);
			return "/baby/new.jsp";
		
			
		}
	}
	
//	----- CREATE - POST METHOD -----
	@PostMapping("/babes")
	public String create(
			@Valid @ModelAttribute("baby") BabyName baby, 
			BindingResult result,
			Model model, HttpSession s) {
		
		if (result.hasErrors()) {
//			grab the user again to send over again if there are errors
			Long userId = (Long) s.getAttribute("user_id");
			User thisLoggedInUser = userService.findOne(userId);
			model.addAttribute("thisLoggedInUser", thisLoggedInUser);
			System.out.println("error");
			
			List<BabyName> allbabes = babyServ.allBabyNames();
			model.addAttribute("allbabes", allbabes);
			
//			passes all the libraries to select from
//			List<LibraryModel> alldaLibraries = libServ.allLibraries();
//			model.addAttribute("alldaLibraries", alldaLibraries);
            return "/baby/new.jsp";
        } else {
//        	Alternative way:
        	Long userId = (Long) s.getAttribute("user_id");
			User thisLoggedInUser = userService.findOne(userId);

//			intercept the book
//			set the author
			baby.setOwner(thisLoggedInUser);

        	
//        	book.getAuthor()
//        	book.setLibrary(null)
        	babyServ.createBaby(baby);
            return "redirect:/baby";
        }
	}
	
//	---- RENDER EDIT PAGE ----
	
    @RequestMapping("/baby/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
        BabyName baby = babyServ.findBaby(id);
//        book.getAuthor()
        model.addAttribute("baby", baby);
        return "/baby/edit.jsp";
    }
    
//    @RequestMapping(value="/books/{id}", method=RequestMethod.PUT)
    @PutMapping("/baby/{id}")
    public String update(
    			@Valid @ModelAttribute("baby") BabyName baby, 
    			BindingResult result) {
        if (result.hasErrors()) {
        	System.out.println(result);
            return "/baby/edit.jsp";
        } else {
//        	find the book
//        	System.out.println("1. " + book.getLibrary());
//        	Book b = bookServ.findBook(book.getId());
//        	System.out.println("2. " + b.getLibrary());
//        	
//        	book.setLibrary(b.getLibrary());
        	
//        	set the same author back before editing
//        	Book b = bookServ.findBook(book.getId());
//        	System.out.println(b.getAuthor());
//        	book.setAuthor(b.getAuthor());
        
        	babyServ.updateBaby(baby);
            return "redirect:/baby";
        }
    }
	
	
////	DELETE
    @DeleteMapping("/baby/{id}")
    public String destroy(@PathVariable("id") Long id, RedirectAttributes flash) {
    	babyServ.deleteBaby(id);
    	flash.addFlashAttribute("delete_success", "you deleted this name!");
        return "redirect:/home";
    }
//	
	
}
