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
        if (userRepository.findByUsername(username) == null) {
        	logger.info("+++++++ Wrong Username! ++++++");
            return "no_user";
        }
        else {
        	//If can search the same name in MySQL.
        	//Let the 'passwor' which equals to userRepository.findByUsername(username).getPassword()
        	password = userRepository.findByUsername(username).getPassword();
        	//return password compare in the front server
        	return password;
        }
    }

}
