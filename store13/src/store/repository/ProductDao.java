package store.repository;

import java.util.List;

import store.domain.Product;

public interface ProductDao {

  public List<Product> getProductList();
  
  public List<Product> getAccessoriesmenList();
  public List<Product> getAccessorieswomenList();
  
  public List<Product> getHatsmenList();
  public List<Product> getHatswomenList();
  
  public List<Product> getShoesmenList();
  public List<Product> getShoeswomenList();
  
  public List<Product> getTeeshirtsmenList();
  public List<Product> getTeeshirtswomenList();
  
  public List<Product> getTrousersmenList();
  public List<Product> getTrouserswomenList();
  
  public void saveProduct(Product prod);	
}
