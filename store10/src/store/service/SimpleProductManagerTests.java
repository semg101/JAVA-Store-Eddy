package store.service;

/**import java.util.ArrayList;
import java.util.List;


import store.domain.Product;
import store.repository.InMemoryProductDao;**/
import junit.framework.TestCase;

public class SimpleProductManagerTests extends TestCase {

  //private ProductManager productManager;
  //private List<Product> products;
  
  //private static int PRODUCT_COUNT = 2;
  
  //private static String TROUSER_IMAGE = "1.jpg";
 // private static String TROUSER_SIZE = "medium";
 // private static String TROUSER_DESCRIPTION = "I love you";
 // private static Double TROUSER_PRICE = new Double(20.50);
 // private static int TROUSER_ID = 1;
  
  //private static String SKIRT_IMAGE = "2.jpg";
  //private static String SKIRT_SIZE = "small";
  //private static String SKIRT_DESCRIPTION = "I hate you";
  //private static Double SKIRT_PRICE = new Double(30.50);
  //private static int SKIRT_ID = 2;

  protected void setUp() throws Exception {
    //productManager = new SimpleProductManager();
   // products = new ArrayList<Product>();
    
    // stub up a list of products
    //Product product = new Product();
   // product.setImage(TROUSER_IMAGE);
    //product.setSize(TROUSER_SIZE);
   // product.setDescription(TROUSER_DESCRIPTION);
   // product.setPrice(TROUSER_PRICE);
   // product.setId(TROUSER_ID);
    //products.add(product);
    
    //product = new Product();
    //product.setImage(SKIRT_IMAGE);
   // product.setSize(SKIRT_SIZE);
    //product.setDescription(SKIRT_DESCRIPTION);
    //product.setPrice(SKIRT_PRICE);
    //product.setId(SKIRT_ID);
    //products.add(product);
    
   // ProductDao productDao = new InMemoryProductDao(products);
   // productManager.setProductDao(productDao);
    //productManager.setProducts(products);
  }

  public void testGetProductsWithNoProducts() {
   // productManager = new SimpleProductManager();
    //productManager.setProductDao(new InMemoryProductDao(null));
    //assertNull(productManager.getProducts());
  }
  
  public void testGetProducts() {
	//List<Product> products = productManager.getProducts();
	//assertNotNull(products);
	//assertEquals(PRODUCT_COUNT, productManager.getProducts().size());
	
	//Product product = products.get(0);
	//assertEquals(TROUSER_IMAGE, product.getImage());
	//assertEquals(TROUSER_SIZE, product.getSize());
	//assertEquals(TROUSER_DESCRIPTION, product.getDescription());
	//assertEquals(TROUSER_PRICE, product.getPrice());
	//assertEquals(TROUSER_ID, product.getId());
	
	//product = products.get(1);
	//assertEquals(SKIRT_IMAGE, product.getImage());
	//assertEquals(SKIRT_SIZE, product.getSize());
	//assertEquals(SKIRT_DESCRIPTION, product.getDescription());
	//assertEquals(SKIRT_PRICE, product.getPrice());
	//assertEquals(SKIRT_ID, product.getId());
  }
}
