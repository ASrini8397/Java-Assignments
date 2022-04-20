package com.ani.safetravels.controllers;
import java.util.List;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ani.safetravels.models.Expense;
import com.ani.safetravels.service.TravelService;

@Controller
public class SafeTravelController {
	
	@Autowired
	TravelService travelService;

	public SafeTravelController() {
		// TODO Auto-generated constructor stub
	}

	  



	
	   @GetMapping("/")
	    public String newBook(@ModelAttribute("expense") Expense expense, Model model) {
		   List<Expense> results= travelService.allExpenses();
			model.addAttribute("results", results);
			return "index.jsp";
	  
	    }
	   
	   @PostMapping("/expense")
	    public String create(@Valid @ModelAttribute("expense") Expense expense, BindingResult result, Model model) {
	        if (result.hasErrors()) {
	        	List<Expense> results= travelService.allExpenses();
				model.addAttribute("results", results);
	            return "index.jsp";
	        } else {
	            travelService.createExpense(expense);
	            return "redirect:/";
	        }

	    }
	   
	   
	   
	   @RequestMapping("/form/{id}/edit")
	    public String edit(@PathVariable("id") Long id, Model model) {
	        Expense expense = travelService.findExpense(id);
	        model.addAttribute("expense", expense);
	        
	        return "/edit.jsp";
	    }
	   
	   @RequestMapping(value="/expense/{id}", method=RequestMethod.PUT)
	    public String update(@Valid @ModelAttribute("expense") Expense expense, BindingResult result) {
	        if (result.hasErrors()) {
	            return "/edit.jsp";
	        } else {
	            travelService.updateExpense(expense);
	            return "redirect:/";
	        }
	    }
	   
	   @DeleteMapping("/expense/{id}")
	    public String destroy(@PathVariable("id") Long id) {
	        travelService.deleteExpense(id);
	        return "redirect:/";
	    }
	   
	   @RequestMapping(value="show/expense/{id}")
	   public String showExpense(@PathVariable("id") Long id, Model model) {
		   Expense expense= travelService.findExpense(id);
		   model.addAttribute("expense", expense);
		   return "/show.jsp";
	   }
	
	}

	   
	
	










	
