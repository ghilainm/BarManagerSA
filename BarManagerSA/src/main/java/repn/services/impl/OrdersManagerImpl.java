package repn.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import repn.dao.OrdersDao;
import repn.model.Orders;
import repn.model.User;
import repn.services.OrdersManager;

@Service
@Transactional(isolation=Isolation.SERIALIZABLE)
public class OrdersManagerImpl implements OrdersManager{

	@Autowired
	OrdersDao orderDao;
	
	public void setOrderDao(OrdersDao orderDao){
		this.orderDao = orderDao;
	}
	
	@Override
	public void save(Orders t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Orders t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Orders t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Orders[] findOrdersByUser(User u) {
		// TODO Auto-generated method stub
		return null;
	}

}
