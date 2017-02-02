package netflix.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/peliculas")
public class ControllerPeliculas {
	
@RequestMapping(method = RequestMethod.POST)
public String IniioPorPost(Model model){
	return "pages/peliculas";
}
@RequestMapping(method = RequestMethod.GET)
public String IniioPorGet(Model model){
	return "pages/peliculas";
}

}
