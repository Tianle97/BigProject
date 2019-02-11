package ie.gmit.sw.productService;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ie.gmit.sw.models.MongoProduct;
import ie.gmit.sw.repositories.MonRepository;

@Service("ProductServiceImp")
public class ProductServiceImp implements ProductService{

	@Autowired
	private MonRepository monRepository;
	
	private static final Logger logger = LoggerFactory.getLogger(ProductServiceImp.class);
	
	@Override
	public String addProduct(MongoProduct product) {
		 try {
			 monRepository.save(product);
       } catch (Exception e) {
    	   logger.error("++++ User failed to be saved... Reason: " + e.getMessage() + " ++++");
       }
		return "success to save";
	}

	@Override
	public ArrayList<MongoProduct> getProduct() {
		ArrayList<MongoProduct> product = null;
		try {
			product = monRepository.findByName("name");
		}catch (Exception e)
		{
			logger.error("+++ User failed to be finded... Reason: " + e.getMessage() + "+++");
		}
		return product;
	}
	
	public ArrayList<MongoProduct> showAll(){
		ArrayList<MongoProduct> product = null;
		try {
			product = (ArrayList<MongoProduct>) monRepository.findAll();
		}catch (Exception e)
		{
			logger.error("+++ User failed to be finded... Reason: " + e.getMessage() + "+++");
		}
		return product;
		
	}

}
