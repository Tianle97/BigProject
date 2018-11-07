package ie.gmit.sw.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ie.gmit.sw.model.User;

@Repository
public interface URepository extends JpaRepository<User,Long> {
	public User findByUsernameAndPassword(String username,String password);
	
	public User findByUsername(String username);
	
	public User findByUid(int uid);
}
