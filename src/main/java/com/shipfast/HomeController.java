package com.shipfast;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
public class HomeController {
	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private Services services;

	@RequestMapping("/")
	public String home(Model model) {
		try {
			model.addAttribute("inventory",
				restTemplate.getForObject(services.getURI("inventory") + "/items", List.class)
			);
			model.addAttribute("available", true);
		}
		catch(ResourceAccessException ex) {
			model.addAttribute("available", false);
		}
		return "home";
	}
}
