package ie.gmit.sw.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ie.gmit.sw.model.User;
import ie.gmit.sw.repositories.URepository;

@Service
public class UService {
	@Autowired
	private URepository userRepository;
	
	public ArrayList<User> showAll(){
		return (ArrayList<User>) userRepository.findAll();
	}
	
	public User save(User user){
		return userRepository.save(user);
	}
	
	public User findUnameAndPwd(String username,String password){
		return userRepository.findByUsernameAndPassword(username, password);
	}

	public URepository getUserByUidy(int uid) {
		return (URepository) userRepository.findByUid(uid);
	}

	public User getUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}
}