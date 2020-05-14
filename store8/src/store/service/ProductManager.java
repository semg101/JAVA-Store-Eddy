package store.service;

import java.io.Serializable;
import java.util.List;

import store.domain.Product;

public interface ProductManager extends Serializable{

	public List<Product> getProducts();	
	
	public List<Product> getAccessoriesmen();
	public List<Product> getAccessorieswomen();
	
	public List<Product> getHatsmen();
	public List<Product> getHatswomen();
	
	public List<Product> getShoesmen();
	public List<Product> getShoeswomen();
	
	public List<Product> getTeeshirtsmen();
	public List<Product> getTeeshirtswomen();
	
	public List<Product> getTrousersmen();
	public List<Product> getTrouserswomen();
}
