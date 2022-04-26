package com.ani.bookclub.controllers;

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

import com.ani.bookclub.models.Book;
import com.ani.bookclub.models.Library;
import com.ani.bookclub.models.LibraryModel;
import com.ani.bookclub.models.User;
import com.ani.bookclub.services.BookService;
import com.ani.bookclub.services.LibraryService;
import com.ani.bookclub.services.UserService;

@Controller
public class BookController {
	
	@Autowired
	private BookService bookServ;
	@Autowired
	private LibraryService libServ;
	@Autowired
	private UserService userService;
	
//	@GetMapping("/")
//	public String index() {
//		System.out.println("index");
//		return "redirect:/books";
//	}
	
//	SHOW ALL THE BOOKS
	@GetMapping("/books")
	public String index(Model model, HttpSession session) {
		
		Long userId = (Long) session.getAttribute("user_id");
//		check if userID is null
		if (userId == null) {
			return "redirect:/";
		} else {			
			List<Book> allbooks = bookServ.allBooks();
	
			model.addAttribute("allbooks", allbooks);
			return "/books/index.jsp";
		}
		
		
	}

	@GetMapping("/books/{id}")
	public String showOne(@PathVariable("id") Long id, Model model) {
		Book oneBook = bookServ.findBook(id);
//		System.out.println(oneBook.getTitle());
		model.addAttribute("oneBook", oneBook);
		return "/books/show.jsp";
	}
	
	
//	@GetMapping("/new")
//	public String createBook(Model model) {
//		Book book = new Book();
//		model.addAttribute("book", book);
//		return "new.jsp";
//	}
//	---- CREATE - RENDER PAGE ------
	@GetMapping("/books/new")
	public String createBook(@ModelAttribute("book") Book book,
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
			List<Book> alldabooks = bookServ.allBooks();
			model.addAttribute("alldabooks", alldabooks);
				
	//		passes all the libraries to select from
			List<LibraryModel> alldaLibraries = libServ.allLibraries();
			model.addAttribute("alldaLibraries", alldaLibraries);
			return "/books/new.jsp";
		
			
		}
	}
	
//	----- CREATE - POST METHOD -----
	@PostMapping("/books")
	public String create(
			@Valid @ModelAttribute("book") Book book, 
			BindingResult result,
			Model model, HttpSession s) {
		
		if (result.hasErrors()) {
//			grab the user again to send over again if there are errors
			Long userId = (Long) s.getAttribute("user_id");
			User thisLoggedInUser = userService.findOne(userId);
			model.addAttribute("thisLoggedInUser", thisLoggedInUser);
			System.out.println("error");
			
			List<Book> alldabooks = bookServ.allBooks();
			model.addAttribute("alldabooks", alldabooks);
			
//			passes all the libraries to select from
			List<LibraryModel> alldaLibraries = libServ.allLibraries();
			model.addAttribute("alldaLibraries", alldaLibraries);
            return "/books/new.jsp";
        } else {
//        	Alternative way:
        	Long userId = (Long) s.getAttribute("user_id");
			User thisLoggedInUser = userService.findOne(userId);

//			intercept the book
//			set the author
			book.setAuthor(thisLoggedInUser);

        	
//        	book.getAuthor()
//        	book.setLibrary(null)
        	bookServ.createBook(book);
            return "redirect:/books";
        }
	}
	
//	---- RENDER EDIT PAGE ----
	
    @RequestMapping("/books/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
        Book book = bookServ.findBook(id);
//        book.getAuthor()
        model.addAttribute("book", book);
        return "/books/edit.jsp";
    }
    
//    @RequestMapping(value="/books/{id}", method=RequestMethod.PUT)
    @PutMapping("/books/{id}")
    public String update(
    			@Valid @ModelAttribute("book") Book book, 
    			BindingResult result) {
        if (result.hasErrors()) {
        	System.out.println(result);
            return "/books/edit.jsp";
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
        
        	bookServ.updateBook(book);
            return "redirect:/books";
        }
    }
	
	
//	DELETE
    @DeleteMapping("/books/{id}/delete")
    public String destroy(@PathVariable("id") Long id, RedirectAttributes flash) {
    	bookServ.deleteBook(id);
    	flash.addFlashAttribute("delete_success", "you have deleted a book!");
        return "redirect:/books";
    }
	
	
}