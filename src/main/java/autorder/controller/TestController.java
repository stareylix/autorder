package autorder.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
	
	@RequestMapping("/welcome.htm")
	public String index(Model model) {
		System.out.println("666");
		return "www";
	}
	
}
