package ie.gmit.sw.controlers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ie.gmit.sw.model.User;
import ie.gmit.sw.services.UService;

@Controller
public class UController {
	private UService uService;
	
	//Register
	@RequestMapping(value="/register",method = RequestMethod.GET)
	public User register(User user,HttpServletRequest h){
		
		return user;
		
	}
	
	

}
