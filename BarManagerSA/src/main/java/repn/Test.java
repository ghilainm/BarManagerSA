package repn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import repn.model.Product;
import repn.services.ProductManager;
import repn.services.exception.ObjectAlreadyExistsException;

@Component
public class Test {
	
	@Autowired
	ProductManager productManager;
	
	public Test(){}
	
	public void setProductManager(ProductManager productManager){
		this.productManager = productManager;
	}
	
	
	public void test(){
		Product p = new Product("Leffe blonde", "1.5", 1);
		insertProduct(p);
		
		for(int i = 0; i<10000; i++){
			p = new Product("Bière"+i, "1.5", 1);
			insertProduct(p);
		}
		
		//display all the products!
		for(Product product : productManager.getAllProducts()){
			System.out.println(product.toString());
		}
	}
	
	public void insertProduct(Product p){
		try{
			productManager.save(p);
		}catch(ObjectAlreadyExistsException e){
			System.out.println("This product already exists : "+p.getProductId());
		}
	}
	
}
