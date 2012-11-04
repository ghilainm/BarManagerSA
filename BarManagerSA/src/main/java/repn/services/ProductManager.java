package repn.services;

import java.util.Collection;

import repn.model.Product;

public interface ProductManager extends Manager<Product>{
	
	public Product getByProductId(String productId);
	
	public Collection<Product> getAllProducts();

}
