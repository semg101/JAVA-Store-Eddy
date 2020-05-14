package store.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
/**import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;**/
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;

import store.domain.Customer;
import store.domain.Item;
import store.domain.Product;


public class JdbcItemDao extends SimpleJdbcDaoSupport implements ItemDao{

	 /** Logger for this class and subclasses */
	  protected final Log logger = LogFactory.getLog(getClass());
	  
	  
	  //Get one product from the table product
	  public Product getOneProduct(String product_id) {
		    logger.info("Getting one product!");
		    
		    Product product = getSimpleJdbcTemplate().queryForObject(
		    		
		    		"select image, sex, price, stock, category_id, id from product where id=?",
		    		new OneProductMapper(),new Object[]{product_id});
			return product;
	  }
      
	  //Get the list of items in the cart
	  public List<Item> getItemList(Object user_session_id) {
	    logger.info("Getting products!");
	    
	    List<Item> items = getSimpleJdbcTemplate().query(
	    		"select image, price, sex, quantity, product_id, message, category_id, user_session_id, id "
	    		+ "from carts where user_session_id=?",new ItemMapper(), user_session_id);
		return items;
	  }

	  //The number of items of a particular user
	  public int user_item(Object user_session_id){
		  return getSimpleJdbcTemplate().queryForObject(
		    		"select count(*) from carts where user_session_id=?", Integer.class, new Object[]{user_session_id});  
	  }
	  
	  
      //Add a new item in the cart or Update item if exists
	  public Item getCartItem(String product_id, Object user_session_id) {
	    logger.info("Getting an item!");
		    
		Item item = getSimpleJdbcTemplate().queryForObject(	
		    		"select image, price, sex, quantity, message, product_id, category_id, user_session_id, id "
		    		+ "from carts where product_id=? and user_session_id=?",new ItemMapper(), new Object[]{product_id, user_session_id});
		return item;
	  }
	  public int getCountCartItem(String product_id, Object user_session_id) {
	    logger.info("Count the number of rows!");
	      
		return getSimpleJdbcTemplate().queryForObject(
		    		"select count(*) from carts where product_id=? and user_session_id=?", Integer.class, new Object[]{product_id, user_session_id});
		
	  }
	  public Item getOneItem(String product_id, Object user_session_id) {
		    logger.info("Getting one product!");
		    
		    List<Product> products = getSimpleJdbcTemplate().query(
		    		
		    		"select image, sex, price, stock, category_id, id from product where id=? ",
		    		new OneProductMapper(), product_id);
			Item item = new Item();
		    
			for (Product p : products) {
				item.setImage(p.getImage());
				item.setSex(p.getSex());
				item.setPrice(p.getPrice());
				item.setQuantity(1);
				item.setProduct_id(p.getId());
				item.setCategory_id(p.getCategory_id());
			}
			item.setUser_session_id(user_session_id);
		    return item;
	  }
	  public void insertItem(Item item) {
		    logger.info("Saving item: Insert" + item.getImage());
		    int count = getSimpleJdbcTemplate().update(
		    		"insert into carts (user_session_id, image, sex, price, quantity,product_id,category_id) values " +
		    				"(?, ?, ?, ?, ? ,? ,?)",
		    				item.getUser_session_id(),
		    				item.getImage(),
		    				item.getSex(),
		    				item.getPrice(),
		    				item.getQuantity(),
		    				item.getProduct_id(),
		    				item.getCategory_id());
		    logger.info("Rows affected: " + count);
	  }
	  /**public void updateItem(String product_id, int quantity, Object user_session_id) {
		    logger.info("Saving item: Update");
		    int count = getSimpleJdbcTemplate().update(
		    		"update carts set quantity = :quantity where product_id = :product_id",
		    		new MapSqlParameterSource().addValue("quantity", quantity)
		    		.addValue("product_id", product_id));		
		    logger.info("Rows affected: " + count);
	  }**/
	  public void updateItem(String product_id, int quantity, Object user_session_id) {
		    logger.info("Saving item: Update");
		    int count = getSimpleJdbcTemplate().update(
		    		"update carts set quantity = ? where product_id = ? "
		    		+ "and user_session_id = ?",new Object[]{quantity, product_id, user_session_id});
		    				
		    logger.info("Rows affected: " + count);
	  }
	  
	  //Update an existing item
	  /**public void updateItem(String product_id, String quantity) {
		    logger.info("Saving item: Update");
		    int count = getSimpleJdbcTemplate().update(
		    		"update carts set quantity = :quantity where product_id = :product_id",
		    		new MapSqlParameterSource().addValue("quantity", quantity)
		    		.addValue("product_id", product_id));
		    		
		    logger.info("Rows affected: " + count);
	  }**/  
	  public void updateItem(String product_id, String quantity, Object user_session_id) {
		    logger.info("Saving item: Update");
		    int count = getSimpleJdbcTemplate().update(
		    		"update carts set quantity = ? where product_id = ? "
		    		+ "and user_session_id =?", new Object[]{quantity, product_id, user_session_id});
		    		
		    logger.info("Rows affected: " + count);
	  }
	  
	  
	  //Update an existing item
	  /**public void updateItem2(String product_id, String message) {
		    logger.info("Saving item: Update");
		    int count = getSimpleJdbcTemplate().update(
		    		"update carts set message = :message where product_id = :product_id ",
		    		new MapSqlParameterSource().addValue("message", message)
		    		.addValue("product_id", product_id));
		    logger.info("Rows affected: " + count);
	  }**/
	  public void updateItem2(String product_id, String message, Object user_session_id) {
		    logger.info("Saving item: Update");
		    int count = getSimpleJdbcTemplate().update(
		    		"update carts set message = ? where product_id = ? "
		    		+ "and user_session_id = ?", new Object[]{message, product_id, user_session_id});
		    logger.info("Rows affected: " + count);
	  }
	  
	  
	  //Delete an existing item
	  public void deleteItem(String product_id, Object user_session_id){
		  logger.info("Saving item: delete");
		  int count = getSimpleJdbcTemplate().update("delete from carts "
		  		+ "where product_id = ? and user_session_id = ?", new Object[]{product_id, user_session_id});
		  logger.info("Rows affected: " + count);
	  }
	  
	  
	  //Add the subtotal of a particular user
	  public void add_order(Object customer_id, float total){
		@SuppressWarnings("unused")
		int count = getSimpleJdbcTemplate().update(
		    		"insert into orders (customer_id, total) values " +
		    				"(?, ?)",
		    				customer_id,
		    				total);
	  }
	  
	  //Check if a user has got an order
	  public int getcountorder(Object customer_id){
		  return getSimpleJdbcTemplate().queryForObject(
		    		"select count(*) from orders where customer_id=?", Integer.class, new Object[]{customer_id});
	  }
	  
	//Add customer's details
	  public void add_customer(Object customer_id, Customer customer){
		  logger.info("Saving Customer: Insert" + customer.getAddress());
		    int count = getSimpleJdbcTemplate().update(
		    		"insert into customers (email, first_name, last_name, address, city, country, zip_code, telephone) values " +
		    				"(?, ?, ?, ? ,? ,? ,? ,?)",
		    				
		    				customer.getEmail(),
		    				customer.getFirst_name(),
		    				customer.getLast_name(),
		    				customer.getAddress(),
		    				customer.getCity(),
		    				customer.getCountry(),
		    				customer.getZip_code(),
		    				customer.getTelephone());
		    logger.info("Rows affected: " + count);
	  }
	  
	  //update a customer: customer_id is the email address
	  public void update_customer(Object customer_id, Customer customer){
		  logger.info("Saving customer: Update");
		    int count = getSimpleJdbcTemplate().update(
		    		"update customers set first_name = ?, last_name = ?, address = ?, "
		    		+ "city = ?, country = ?, zip_code = ?, telephone = ? "
		    		+ "where email = ? "
		    		, new Object[]{customer.getFirst_name(), customer.getLast_name(), customer.getAddress(), customer.getCity(), customer.getCountry(), customer.getZip_code(), customer.getTelephone(), customer_id });
		  logger.info("Rows affected: " + count);
	  }
	  
	  
	  //Check if a user has his details in the database
	  public int getcountcustomer(Object customer_id){
		  return getSimpleJdbcTemplate().queryForObject(
		    		"select count(*) from customers where email=?", Integer.class, new Object[]{customer_id});
	  }
	  
	  private static class ItemMapper implements ParameterizedRowMapper<Item> {

		    public Item mapRow(ResultSet rs, int rowNum) throws SQLException {
		      Item item = new Item();
		      item.setUser_session_id(rs.getString("user_session_id"));
		      item.setImage(rs.getString("image"));
		      item.setMessage(rs.getString("message"));
		      item.setSex(rs.getString("sex"));
		      item.setPrice(new Double(rs.getDouble("price")));
		      item.setQuantity(rs.getInt("quantity"));
		      item.setProduct_id(rs.getInt("product_id"));
		      item.setCategory_id(rs.getInt("category_id"));
		      item.setTotal(new Double(rs.getDouble("price")*rs.getInt("quantity")));
		      item.setId(rs.getInt("id"));
		      return item;
		    }
	  }
	  
	  
	  
	  private static class OneProductMapper implements ParameterizedRowMapper<Product> {

		    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
		      Product prod = new Product();
		      prod.setImage(rs.getString("image"));
		      prod.setStock(rs.getInt("stock"));
		      prod.setSex(rs.getString("sex"));
		      prod.setPrice(new Double(rs.getDouble("price")));
		      prod.setCategory_id(rs.getInt("category_id"));
		      prod.setId(rs.getInt("id"));
		      return prod;
		    }
	  }
}
