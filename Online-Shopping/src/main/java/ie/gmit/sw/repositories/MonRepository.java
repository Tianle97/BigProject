package ie.gmit.sw.repositories;

import java.util.ArrayList;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import ie.gmit.sw.models.MongoProduct;

@Repository
public interface MonRepository extends MongoRepository<MongoProduct, Long> {
	
	public ArrayList<MongoProduct> findByName(String name);

}
