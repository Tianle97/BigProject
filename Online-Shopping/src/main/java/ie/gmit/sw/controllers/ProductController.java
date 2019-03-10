package ie.gmit.sw.controllers;

import java.util.ArrayList;
import java.util.List;

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
	
	@GetMapping("/products")
	public List<MongoProduct> getAll(){
		return productService.showAll();
	}
	
	@ResponseBody
	@PostMapping("/addProduct")
	public Resp addProduct(@RequestBody MongoProduct mp){
		
		productService.addProduct(mp);
		
		return new Resp("seccess");
	}
	
	@GetMapping("/buy")
	public MongoProduct buyProduct(@RequestParam("id") String id){
//		ArrayList<MongoProduct> mp = productService.showAll();
//		MongoProduct mp2 = null;
//		for(MongoProduct m : mp){
//			if(m.getId() == id)
//			{
//				System.out.println(m.getName());
//				mp2 = productService.findById(m.getId());
//				return mp2;
//			}
//		}
		return productService.findById(id);
	}
	
//	@ResponseBody
//	@PostMapping("/buy")
//	public MongoProduct buyProductPost(@RequestBody String id){
//		System.out.println(id);
////		JSONObject jsonObject = JSON.parseObject(id);
////		MongoProduct mp = JSONObject.toJavaObject(jsonObject, MongoProduct.class);
////		System.out.println(mp);
////		return mp;
//		ArrayList<MongoProduct> mpList = productService.showAll();
//		MongoProduct mp2 = null;
//		for(MongoProduct m : mpList) {
//			if(m.getId().equals(id)) {
//				mp2 = productService.findById(m.getId());
//				return mp2;
//			}
//		}
//		return null;
//	}
	
	
	@ResponseBody
	@GetMapping("/show")
	public ArrayList<MongoProduct> showAll(){
		
		ArrayList<MongoProduct> productList = productService.showAll();
		
		for (MongoProduct m : productList)
		{
			System.out.println(m.getName());
		}
		
		return productList;
	}
}
