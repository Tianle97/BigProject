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

	
//	@RequestMapping(value = "/login" , method = RequestMethod.GET)
//	public String login() {
//		return "login";
//	}
	
	//Login POST
//		@RequestMapping(value="/login" , method = RequestMethod.POST)
//		@ResponseBody
//		public User loginPost(User user,BindingResult result,HttpServletRequest h,Model m, HttpSession session){
//			System.out.println("aaa"+h);
//			String username = h.getParameter("username");
//			String password = h.getParameter("password");
//			User users = uService.findUnameAndPwd(username, password);
//			return users;
//		}
		
//		//Register
//		@RequestMapping(value="/register",method = RequestMethod.GET)
//		public String register(){
//			System.out.println("Register");
//			return "register";
//		}
		
		@PostMapping("/register")
		public Resp registerPost(@RequestBody User user) {
			if(uService.findByUsername(user.getUsername()) == null){
				uService.save(user);
				return new Resp("registered");
			}else{
				return new Resp("duplicate_user");
			}
		}
		
		@GetMapping("/login")
		public String login(@RequestParam("username") String username, @RequestParam("password") String password) {
			logger.info("Before Login User: " + username + "  " + password);

			return uService.loginUser(username,password);
		}
}