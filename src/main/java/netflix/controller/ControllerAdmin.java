package netflix.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/admin")
public class ControllerAdmin {
	@RequestMapping(method = RequestMethod.POST)
	public String IniioPorPost(Model model){
		return "pages/peliculas";
	}
	@RequestMapping(method = RequestMethod.GET)
	public String IniioPorGet(Model model){
		return "pages/peliculas";
	}

}
