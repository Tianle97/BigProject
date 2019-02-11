package ie.gmit.sw.productService;

import java.util.ArrayList;
import java.util.List;

import ie.gmit.sw.models.MongoProduct;

public interface ProductService {
	public String addProduct(MongoProduct product);
	public List<MongoProduct> getProduct();
	public ArrayList<MongoProduct> showAll();
}
