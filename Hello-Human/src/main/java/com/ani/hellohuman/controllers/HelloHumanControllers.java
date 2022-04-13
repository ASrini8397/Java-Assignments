package com.ani.hellohuman.controllers;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class HelloHumanControllers {

	@RequestMapping("/")
	public String index(@RequestParam(value="q", required=false) String name) {
		System.out.println("Testing");
		if (name == null) {
			return "Hello Human ";
		}
		else {
		
        return "Hello " + name;
		}
    } 
	
	
 
}
