package repn.services;

import repn.model.Orders;
import repn.model.User;

public interface OrdersManager extends Manager<Orders>{
	
	public Orders[] findOrdersByUser(User u);
	
}
