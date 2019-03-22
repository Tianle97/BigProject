package ie.gmit.sw.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ie.gmit.sw.models.OrderInfo;
import ie.gmit.sw.shoppingInfoService.OrderInfoService;

@RestController
public class OrderInfoController {
	@Autowired
	@Qualifier("ShoppingInfoServiceImp")
	private OrderInfoService orderInfoService;

	@PostMapping("/addOrderInfo")
	public String saveOrderInfo(@RequestBody OrderInfo orderInfo) {
		System.out.println(orderInfo.getName());
		return orderInfoService.addOrderInfo(orderInfo);
	}

	@GetMapping("/getOrderInfo")
	public ArrayList<OrderInfo> getOrderInfo(@RequestParam("username") String username) {
		return orderInfoService.showAll(username);
	}

}