package ie.gmit.sw.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ie.gmit.sw.Userservices.UService;
import ie.gmit.sw.models.Resp;
import ie.gmit.sw.models.User;

@RestController
public class UserController {
	@Autowired
	private UService uService;
	
	
	// Server console logger
	private static Logger logger = LoggerFactory.getLogger(UserController.class);

		
		@PostMapping("/register")
		public Resp registerPost(@RequestBody User user) {
			if(user.getUsername()== null || user.getPassword() == null || user.getAddress() == null || user.getPhone() == null)
				//uService.save(user);
				return new Resp("error");
			if (uService.findByUsername(user.getUsername()) == null && user.getUsername() != null) {
				uService.save(user);
				return new Resp("registered");
			}else {
				return new Resp("duplicate_user");
			}
		}
		
		@GetMapping("/login")
		public String login(@RequestParam("username") String username, @RequestParam("password") String password) {
			logger.info("Before Login User: " + username + "  " + password);
			return uService.loginUser(username,password);
		}
}