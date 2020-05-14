package store.repository;

import java.util.List;

import store.domain.Product;



public class InMemoryProductDao  {

  private List<Product> productList;
 

  public InMemoryProductDao(List<Product> productList) {
    this.productList = productList;
   
  }
  

  public List<Product> getProductList() {
    return productList;
  }

  public void saveProduct(Product prod) {
  }

  
}
