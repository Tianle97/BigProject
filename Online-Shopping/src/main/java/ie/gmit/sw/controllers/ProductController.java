package ie.gmit.sw.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ie.gmit.sw.models.MongoProduct;
import ie.gmit.sw.models.Resp;
import ie.gmit.sw.productService.ProductService;

@RestController
public class ProductController {
	@Autowired
	@Qualifier("ProductServiceImp")
	private ProductService productService;

	// Server console logger
	private static Logger logger = LoggerFactory.getLogger(ProductController.class);

	@GetMapping("/products")
	public List<MongoProduct> getAll() {
		return productService.showAll();
	}

	@ResponseBody
	@PostMapping("/addProduct")
	public Resp addProduct(@RequestBody MongoProduct mp) {
		System.out.println("######" + logger);
		productService.addProduct(mp);
		return new Resp("seccess");
	}

	@GetMapping("/buy")
	public MongoProduct buyProduct(@RequestParam("id") String id, @RequestParam("amount") int amount) {
		MongoProduct prod = productService.findById(id);
		MongoProduct new_prod = prod;
		int stocks = prod.getStocks() - amount;
		if (stocks >= 0){
			new_prod.setStocks(prod.getStocks() - amount);
			productService.updateProduct(new_prod);
		}
		//prod = productService.findById(id);
		System.out.println("stocks" + prod.getStocks());
		return prod;
	}

	@ResponseBody
	@GetMapping("/show")
	public ArrayList<MongoProduct> showAll() {
		ArrayList<MongoProduct> productList = productService.showAll();
		for (MongoProduct m : productList) {
			System.out.println(m.getName());
		}

		return productList;
	}
}
