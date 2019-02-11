package ie.gmit.sw.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ie.gmit.sw.models.User;

@Repository
public interface URepository extends CrudRepository<User,Long> {
	
	public User findByUsername(String username);
	
	public User findByUid(int uid);
}
