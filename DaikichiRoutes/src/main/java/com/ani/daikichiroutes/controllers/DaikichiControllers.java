package com.ani.daikichiroutes.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping("/daikichi")

public class DaikichiControllers {

	public DaikichiControllers() {
		//use request mapping for routing
		//above public class daikichi use @RequestMapping/daikichi
		//
	}
	@RequestMapping("")
	public String newroute() {
		 return "Welcome!";
	}
	
	@RequestMapping("/today")
	public String secondroute() {
		 return "<p> Today you will find luck in all your endeavors! </p>";
	}
	
	@RequestMapping("/tomorrow")
	public String thirdroute() {
		 return "<p> Tomorrow an opportunity will arise, so be sure to be open to new ideas! </p>";
	}
}
