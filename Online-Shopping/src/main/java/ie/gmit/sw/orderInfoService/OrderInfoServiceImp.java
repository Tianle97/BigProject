package ie.gmit.sw.orderInfoService;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ie.gmit.sw.models.OrderInfo;
import ie.gmit.sw.models.Resp;
import ie.gmit.sw.repositories.OrderInforRepositries;

@Service("ShoppingInfoServiceImp")
public class OrderInfoServiceImp implements OrderInfoService {

	@Autowired
	private OrderInforRepositries orderInforRepositries;

	@Override
	public ArrayList<OrderInfo> showAll(String username) {
		// create a empty array list
		ArrayList<OrderInfo> orderInfos = null;

		// get all information from mongodb according to userName
		orderInfos = orderInforRepositries.findByUsername(username);

		return orderInfos;
	}

	// add user Shopping details save in mongodb
	@Override
	public Resp addOrderInfo(OrderInfo orderInfo) {
		orderInforRepositries.save(orderInfo);
		//Just for check
		System.out.println("000000"+"create order seccessful");
		return new Resp("create order seccessful");
	}
	
	@Override
	public Resp deleteById(String id) {
		// TODO Auto-generated method stub
		OrderInfo orderInfo = orderInforRepositries.findById(id);
		System.out.println(orderInfo.getId());
		orderInforRepositries.delete(orderInfo);
		return new Resp("delete succssful");
	}
}
