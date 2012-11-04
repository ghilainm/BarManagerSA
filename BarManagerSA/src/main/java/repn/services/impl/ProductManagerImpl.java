package repn.services.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import repn.dao.ProductDao;
import repn.model.Product;
import repn.services.ProductManager;
import repn.services.exception.ObjectAlreadyExistsException;

@Service
@Transactional(isolation=Isolation.SERIALIZABLE)
public class ProductManagerImpl implements ProductManager{
	
	@Autowired 
	ProductDao productDao;
	
	public void setProductDao(ProductDao productDao){
		this.productDao = productDao;
	}

	@Override
	public void save(Product t) throws ObjectAlreadyExistsException {
		if(productDao.getProductById(t.getProductId()) != null){
			throw new ObjectAlreadyExistsException();
		}
		productDao.save(t);
	}

	@Override
	public void update(Product t) {
		productDao.update(t);
	}

	@Override
	public void delete(Product t) {
		productDao.delete(t);
	}

	@Override
	public Product getByProductId(String productId) {
		return productDao.getProductById(productId);
	}

	@Override
	public Collection<Product> getAllProducts() {
		return productDao.getAllProducts();
	}

}
