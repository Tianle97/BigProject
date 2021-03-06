package ie.gmit.sw.orderInfoService;

import java.util.ArrayList;

import ie.gmit.sw.models.OrderInfo;
import ie.gmit.sw.models.Resp;


public interface OrderInfoService {
	public Resp addOrderInfo(OrderInfo orderInfo);
	public ArrayList<OrderInfo> showAll(String username);
	public Resp deleteById(String id);
}
