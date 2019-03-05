package ie.gmit.sw.shoppingInfoService;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ie.gmit.sw.models.ShoppingInfo;
import ie.gmit.sw.repositories.ShoppingInforRepositries;

@Service("ShoppingInfoServiceImp")
public class ShoppingInfoServiceImp implements ShoppingInfoService {

	@Autowired
	private ShoppingInforRepositries shoppingInforRepositries;

	@Override
	public ArrayList<ShoppingInfo> showAll() {
		// create a empty array list
		ArrayList<ShoppingInfo> shoppingInfo = null;

		// get all information from mongodb according to userName
		shoppingInfo = shoppingInforRepositries.findByUserName();

		return shoppingInfo;
	}

	// add user Shopping details save in mongodb
	@Override
	public String addProduct(ShoppingInfo shoppingInfo) {
		shoppingInforRepositries.save(shoppingInfo);

		return "success to save";
	}

}
