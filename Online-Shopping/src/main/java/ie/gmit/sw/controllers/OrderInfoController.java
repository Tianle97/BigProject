package ie.gmit.sw.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ie.gmit.sw.models.OrderInfo;
import ie.gmit.sw.models.Resp;
import ie.gmit.sw.orderInfoService.OrderInfoService;

@RestController
public class OrderInfoController {
	@Autowired
	@Qualifier("ShoppingInfoServiceImp")
	private OrderInfoService orderInfoService;
	
	@ResponseBody
	@PostMapping("/addOrderInfo")
	public Resp saveOrderInfo(@RequestBody OrderInfo orderInfo) {
		//Just for check
		System.out.println("0000000"+orderInfo.getName());
		return orderInfoService.addOrderInfo(orderInfo);
	}

	@GetMapping("/getOrderInfo")
	public ArrayList<OrderInfo> getOrderInfo(@RequestParam("username") String username) {
		return orderInfoService.showAll(username);
	}
	
	@ResponseBody
	@PostMapping("/deleteOrderInfo")
	public Resp deleteOrderInfo(@RequestParam("id") String id) {
		//Just for check
		System.out.println("0000000"+id);
		return orderInfoService.deleteById(id);
	}
}