package repn.dao;

import java.util.Collection;

import repn.model.Product;

public interface ProductDao extends Dao<Product>{

	public Product getProductById(String productId);

	public Collection<Product> getAllProducts();
}
