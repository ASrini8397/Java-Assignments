package com.ani.fruityloops.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ani.fruityloops.models.Item;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import java.util.ArrayList;
@Controller
public class ItemController {
 
 @RequestMapping("/")
 public String index(Model model) {
     
     ArrayList<Item> fruits = new ArrayList<Item>();
     fruits.add(new Item("Kiwi", 1.5));
     fruits.add(new Item("Mango", 2.0));
     fruits.add(new Item("Goji Berries", 4.0));
     fruits.add(new Item("Guava", .75));
     
     // Add fruits your view model here
     model.addAttribute("fruitsInMyShop", fruits);
     
     
     return "index.jsp";
 }
}
