package ie.gmit.sw.repositories;

import java.util.ArrayList;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import ie.gmit.sw.models.ShoppingInfo;

@Repository
public interface ShoppingInforRepositries extends MongoRepository<ShoppingInfo, Long> {
	public ArrayList<ShoppingInfo> findByUserName();
}
