package ie.gmit.sw.shoppingInfoService;

import java.util.ArrayList;

import ie.gmit.sw.models.OrderInfo;
import ie.gmit.sw.models.Resp;


public interface OrderInfoService {
	public Resp addOrderInfo(OrderInfo shoppingInfo);
	public ArrayList<OrderInfo> showAll(String username);
}
