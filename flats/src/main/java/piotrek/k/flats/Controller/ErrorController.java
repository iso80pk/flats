package piotrek.k.flats.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorController {
	
	@RequestMapping(value="/403")
	public String error403() {
		return "errors/403";
	}
	
	@RequestMapping(value="/404")
	public String error404() {
		return "errors/404";
	}


}
