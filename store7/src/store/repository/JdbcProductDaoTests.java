package store.repository;

import java.util.List;

import org.springframework.test.AbstractTransactionalDataSourceSpringContextTests;

import store.domain.Product;

public class JdbcProductDaoTests extends AbstractTransactionalDataSourceSpringContextTests {

  private ProductDao productDao;

  public void setProductDao(ProductDao productDao) {
    this.productDao = productDao;
  }

  @Override
  protected String[] getConfigLocations() {
    return new String[] {"classpath:test-context.xml"};
  }

  @Override
  protected void onSetUpInTransaction() throws Exception {
    //super.deleteFromTables(new String[] {"product"});
    //super.deleteFromTables(new String[] {"categories"});
	//super.executeSqlScript("file:db/create.sql", true);
    //super.executeSqlScript("file:db/load_data.sql", true);
  }

  public void testGetProductList() {
    List<Product> products = productDao.getProductList();
    assertEquals("wrong number of products?", 100, products.size());
  }

  public void testSaveProduct() {
    List<Product> products = productDao.getProductList();
    for (Product p : products) {
      p.setSize("medium");
      productDao.saveProduct(p);
    }
    List<Product> updatedProducts = productDao.getProductList();
    for (Product p : updatedProducts) {
      assertEquals("wrong size of product?", "medium", p.getSize());
    }
  }
}