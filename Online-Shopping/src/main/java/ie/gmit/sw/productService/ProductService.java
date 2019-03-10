package ie.gmit.sw.productService;

import java.util.ArrayList;

import ie.gmit.sw.models.MongoProduct;

public interface ProductService {
	public String addProduct(MongoProduct product);
	public ArrayList<MongoProduct> getProduct();
	public ArrayList<MongoProduct> showAll();
	public MongoProduct findById(String id);
}
