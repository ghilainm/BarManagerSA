package repn.services;

import repn.services.exception.ObjectAlreadyExistsException;

public interface Manager<T> {
	
	public void save(T t) throws ObjectAlreadyExistsException;

	public void update(T t);

	public void delete(T t);
	
}
