package net.szecc.client;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HomeController {
	
	//get the value from the messageSource bean (the resourcebundle)
	@Value("#{ propertiesSource.getMessage('admin.email',null,'en')}") private String adminEmail;
	
	@RequestMapping(method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("dateTime",new Date());
		model.addAttribute("adminEmail", adminEmail);
		return "forward:/pages/home";
	}

}
