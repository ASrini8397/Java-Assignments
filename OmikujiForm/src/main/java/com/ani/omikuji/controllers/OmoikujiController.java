package com.ani.omikuji.controllers;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import javax.servlet.http.HttpSession;

@Controller
public class OmoikujiController {
	

	public OmoikujiController() {
		
	}
	
	@RequestMapping("/")
	public String index() {
		
		return "index.jsp";
	}
		// TODO Auto-generated constructor stub
	
	@RequestMapping(value="/omikuji",  method=RequestMethod.POST)
	public String processForm(Model model, HttpSession session,
		@RequestParam(value="number") Integer number,
	    @RequestParam(value="city") String city, 
	    @RequestParam(value="name") String name,
	    @RequestParam(value="hobby") String hobby,
	    @RequestParam(value="compliment") String compliment,
	    @RequestParam(value="livingthing") String livingthing) {
		 session.setAttribute("number", number);
		 session.setAttribute("city", city);
		 session.setAttribute("name", name);
		 session.setAttribute("hobby", hobby);
		 session.setAttribute("compliment", compliment);
		 session.setAttribute("livingthing", livingthing);
		
		return "redirect:/showForm";
	}
	
	@RequestMapping("/showForm")
	public String last(HttpSession session, Model model) {
		Integer number= (Integer) session.getAttribute("number");
		model.addAttribute("number", number);
		
		String city= (String) session.getAttribute("city");
		model.addAttribute("city", city);
		
		String name= (String) session.getAttribute("name");
		model.addAttribute("name", name);
		
		String hobby= (String) session.getAttribute("hobby");
		model.addAttribute("hobby", hobby);
		
		String compliment= (String) session.getAttribute("compliment");
		model.addAttribute("compliment", compliment);
		
		
		String livingthing= (String) session.getAttribute("livingthing");
		model.addAttribute("livingthing", livingthing);
		
		System.out.println( city+ name + hobby + compliment + livingthing);
		
		
		return "showForm.jsp";
	}
	
}
