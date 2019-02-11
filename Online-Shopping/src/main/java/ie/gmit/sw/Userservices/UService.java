package ie.gmit.sw.Userservices;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ie.gmit.sw.models.User;
import ie.gmit.sw.repositories.URepository;

@Service
public class UService {
	@Autowired(required=false)
	URepository userRepository;
	
	 private static final Logger logger = LoggerFactory.getLogger(UService.class);
	
	public ArrayList<User> showAll(){
		return (ArrayList<User>) userRepository.findAll();
	}
	
	public void save(User user){
		userRepository.save(user);
	}
	
	public User findByUsername(String username){
		return userRepository.findByUsername(username);
	}
	
	public String loginUser(String username, String password) {

    	// Check if user exist in DB. Delegate this task to SqlDAO repository.
    	// Hibernate provides a method findBy___(param) to perform querying.
    	// If you want, you can easily switch to MongoDB
        if (userRepository.findByUsername(username) == null /*&& mongoDB.findByUsername(username) == null*/) {
        	logger.info("+++++++ Wrong Username! ++++++");
            return "no_user";
        } else {
        	// If user exist in DB, Hibernate will return a POJO of SqlUser. 
        	// We can access it's password field via getter and compare with
        	// password sent in the request from a Client.
            if (!password.equals(userRepository.findByUsername(username).getPassword())) {
            	logger.info("+++++ Wrong Password! +++++");
                return "wrong_pass";
            } else {
            	// if username/password pass validation, return status back to Client
            	logger.info("++++++ Logged In! ++++++");
                return "logged";
            }
        }
    }

}
