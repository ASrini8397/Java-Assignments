package com.ani.dojos.controllers;

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

import com.ani.dojos.models.DojoModel;
import com.ani.dojos.models.NinjaModel;
import com.ani.dojos.service.DojoService;
import com.ani.dojos.service.NinjaService;


@Controller
public class DojoController {

	@Autowired
	DojoService dojoService;
//	private final DojoService dojoService;
	

	@Autowired
	NinjaService ninjaService;

//	public DojoController(DojoService dojoService, NinjaService ninjaService) {
//		// TODO Auto-generated constructor stub
//		this.dojoService = dojoService;
//		this.ninjaService=ninjaService;
//	}
//	

	@GetMapping("/")
	public String index(@ModelAttribute("dojo") DojoModel dojo, Model m) {
		List<DojoModel> dojos= dojoService.allDojos();
		m.addAttribute("dojos",dojos);
		return "index.jsp";

	}

	@PostMapping("/create")
	public String newDojo(@Valid @ModelAttribute("dojo") DojoModel dojo, BindingResult result) {
		 if (result.hasErrors()) {
	            return "index.jsp";
	        } else {
	            dojoService.createDojo(dojo);
	            return "redirect:/ninja";
	        }

	}
	
	
	@GetMapping("/ninja")
	public String ninja(@ModelAttribute("ninja") NinjaModel ninja, Model m) {
		List<DojoModel> dojos= dojoService.allDojos();
		m.addAttribute("dojos",dojos);
		return "ninjaForm.jsp";

	}
	
	@PostMapping("/createninja")
	public String newNinja(@Valid @ModelAttribute("ninja") NinjaModel ninja, BindingResult result, Model m) {
		 if (result.hasErrors()) {
			 System.out.println(result);
			 List<DojoModel> dojos= dojoService.allDojos();
				m.addAttribute("dojos",dojos);
	            return "ninjaForm.jsp";
	        } else {
	            ninjaService.createNinja(ninja);
	            
	            return "redirect:/  "; 
	        }

	}
	

	@RequestMapping(value="show/dojo/{dojo_id}")
	   public String showDojo(@PathVariable Long dojo_id, Model model) {

		List <NinjaModel> ninjas= ninjaService.findByID(dojo_id);
		model.addAttribute("ninjas", ninjas);
		   return "/display.jsp";
	   }
	
//	 @DeleteMapping("/dojo/{id}")
//	    public String destroy(@PathVariable("id") Long id) {
//	        dojoService.deleteExpense(id);
//	        return "redirect:/";
//	    }
	

	
}
