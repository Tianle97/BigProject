package ie.gmit.sw.repositories;

import java.util.ArrayList;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import ie.gmit.sw.models.OrderInfo;

@Repository
public interface OrderInforRepositries extends MongoRepository<OrderInfo, Long> {
	public ArrayList<OrderInfo> findByUsername(String username);
	public OrderInfo findById(String id);
	public OrderInfo deleteById(String id);
}
