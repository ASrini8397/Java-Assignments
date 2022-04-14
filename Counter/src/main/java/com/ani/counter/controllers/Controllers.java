package com.ani.counter.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import javax.servlet.http.HttpSession;


@Controller
public class Controllers {

	public Controllers() {
		// TODO Auto-generated constructor stub
	}
	@RequestMapping("/")
	public String index(HttpSession session) {
		if (session.getAttribute("count") == null) {
			 session.setAttribute("count", 0);
			
			}
		else {
			Integer currentCount = (Integer) session.getAttribute("count");
			// increment the count by 1 using getAttribute and setAttribute
			session.setAttribute("count", currentCount+1);
			}
       
		return "index.jsp";
	}
@RequestMapping("/counter")
public String showCount(HttpSession session, Model model) {
		Integer currentCount = (Integer) session.getAttribute("count");
		model.addAttribute("countToShow", currentCount);
		return "showCount.jsp";
	}

}


