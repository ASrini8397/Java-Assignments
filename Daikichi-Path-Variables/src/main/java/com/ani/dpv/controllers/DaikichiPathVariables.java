package com.ani.dpv.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;


@RestController

@RequestMapping("/daikichi")
public class DaikichiPathVariables {

	public DaikichiPathVariables() {
		// TODO Auto-generated constructor stub
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
	
	@RequestMapping("/travel/{city}")
    public String showCity(@PathVariable("city") String city){
    	return "Congratulations! You will travel to " +city + " soon!";
    }

	@RequestMapping("/lotto/{number}")
    public String showLesson(@PathVariable("number") Integer number){
		if( number%2==0) {
			return "You will take a grand journey in the near future, but be weary of tempting offers";
		}
    	return "You have enjoyed the fruits of your labor but now is a great time to spend time with family and friends ";
    }
}
