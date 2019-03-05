package ie.gmit.sw.shoppingInfoService;

import java.util.ArrayList;

import ie.gmit.sw.models.ShoppingInfo;


public interface ShoppingInfoService {
	public String addProduct(ShoppingInfo shoppingInfo);
	public ArrayList<ShoppingInfo> showAll();
}
