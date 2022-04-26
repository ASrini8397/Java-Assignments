package com.ani.loginreg.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ani.loginreg.models.LoginUser;
import com.ani.loginreg.models.User;
import com.ani.loginreg.services.UserService;

@Controller
public class LoginController {

	@Autowired
	private UserService userServ;


	@GetMapping("/")
	public String index(Model model) {
//make empty object to be bound with the inputs from the form and the binding result in the post method
		model.addAttribute("newUser", new User());
		model.addAttribute("newLogin", new LoginUser());
		return "index.jsp";
	}

//	reg
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model,
			HttpSession sesh) {


		userServ.register(newUser, result);

		if (result.hasErrors()) {
			model.addAttribute("newLogin", new LoginUser());
			return "index.jsp";
		} else {
			sesh.setAttribute("user_id", newUser.getId());
			return "redirect:/home";
		}
	}

//	login
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult res, Model model,
			HttpSession sesh) {

		User user = userServ.login(newLogin, res);

		if (res.hasErrors()) {
			model.addAttribute("newUser", new User());
			return "index.jsp";

		} else {
			sesh.setAttribute("user_id", user.getId());
			return "redirect:/home";
		}

	}

//	home page
	@RequestMapping("/home")
	public String home(HttpSession s, Model m) {
		
		Long userId = (Long) s.getAttribute("user_id");
		
		if (userId == null) {
			
			return "redirect:/";
			
		} else {
			
			User thisUser = userServ.findOne(userId);
			m.addAttribute("thisUser", thisUser);
		
			return "home.jsp";
		}
	}

	@GetMapping("/logout")
	public String logout(HttpSession s) {
		
		s.invalidate();
		
		return "redirect:/";
	}

}