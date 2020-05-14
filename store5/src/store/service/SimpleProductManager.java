package store.service;

import java.util.List;

import store.domain.Product;
import store.repository.ProductDao;

@SuppressWarnings("serial")
public class SimpleProductManager implements ProductManager {

  //private List<Product> products;
	private ProductDao productDao;	
	
  public List<Product> getProducts() {
    //return products;
	  return productDao.getProductList();  
  }
  
  public List<Product> getAccessoriesmen() {
	    //return products;
		  return productDao.getAccessoriesmenList();  
  }
  
  public List<Product> getAccessorieswomen() {
	    //return products;
		  return productDao.getAccessorieswomenList();  
  }

  public List<Product> getHatsmen() {
	    //return products;
		  return productDao.getHatsmenList();  
  }
  
  public List<Product> getHatswomen() {
	    //return products;
		  return productDao.getHatswomenList();  
  }
  
  public List<Product> getShoesmen() {
	    //return products;
		  return productDao.getShoesmenList();  
  }
  
  public List<Product> getShoeswomen() {
	    //return products;
		  return productDao.getShoeswomenList();  
  }
  
  public List<Product> getTeeshirtsmen() {
	    //return products;
		  return productDao.getTeeshirtsmenList();  
  }
  
  public List<Product> getTeeshirtswomen() {
	    //return products;
		  return productDao.getTeeshirtswomenList();  
  }
  
  public List<Product> getTrousersmen() {
	    //return products;
		  return productDao.getTrousersmenList();  
  }
  
  public List<Product> getTrouserswomen() {
	    //return products;
		  return productDao.getTrouserswomenList();  
  }
  //public void setProducts(List<Product> products) {
    //this.products = products;
  //}
  public void setProductDao(ProductDao productDao) {
    this.productDao = productDao;
  }
}
