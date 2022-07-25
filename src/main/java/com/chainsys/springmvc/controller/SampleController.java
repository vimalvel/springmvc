package com.chainsys.springmvc.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SampleController {
	@RequestMapping("/")
	public String index() {
		return "index";// index is the name of the view
//		Runtime will search for index.jsp in webapp/WEB-INF/views folder
	}
	@PostMapping("/print")
	public String print(@RequestParam("username")String uname,Model model) {
		model.addAttribute("username",uname);
//		to share data from the controller to view.
		return "print";
	}
	

}
