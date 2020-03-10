package ru.inkontext.share;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StarterController {
	@GetMapping("/title")
	public String index(Model model) {
		model.addAttribute("title", "Hello from Controller");
		return "title";
	}
}
