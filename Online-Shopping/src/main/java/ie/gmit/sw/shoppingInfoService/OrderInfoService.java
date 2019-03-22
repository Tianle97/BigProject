package ie.gmit.sw.shoppingInfoService;

import java.util.ArrayList;

import ie.gmit.sw.models.OrderInfo;


public interface OrderInfoService {
	public String addOrderInfo(OrderInfo shoppingInfo);
	public ArrayList<OrderInfo> showAll(String username);
}
