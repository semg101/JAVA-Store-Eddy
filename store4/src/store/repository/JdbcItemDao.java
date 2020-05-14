package store.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;

import store.domain.Item;
import store.domain.Product;


public class JdbcItemDao extends SimpleJdbcDaoSupport implements ItemDao{

	 /** Logger for this class and subclasses */
	  protected final Log logger = LogFactory.getLog(getClass());

	  public List<Item> getItemList() {
	    logger.info("Getting products!");
	    
	    List<Item> items = getSimpleJdbcTemplate().query(
	    		
	    		"select image, price, sex, quantity, product_id, category_id, id from carts",new ItemMapper());
		return items;
	  }
	  
	  public Item getOneItem(String param) {
		    logger.info("Getting products!");
		    
		    List<Product> products = getSimpleJdbcTemplate().query(
		    		
		    		"select image, sex, price, category_id, id from product where id=?",new OneProductMapper(),new Object[]{param});
			Item item = new Item();
		    
			for (Product p : products) {
				item.setImage(p.getImage());
				item.setSex(p.getSex());
				item.setPrice(p.getPrice());
				item.setQuantity(1);
				item.setProduct_id(p.getId());
				item.setCategory_id(p.getCategory_id());
			}
		    return item;
	 }
	  
	  public void updateItem(Item item) {
		    logger.info("Saving item: " + item.getImage());
		    int count = getSimpleJdbcTemplate().update(
		    		"update carts set image = :image,price = :price,quantity = :quantity,"
		    		+ " product_id = :product_id,category_id = :category_id where id = :id",
		    		new MapSqlParameterSource().addValue("image", item.getImage())
		    		.addValue("sex", item.getSex())
		    		.addValue("price", item.getPrice())
		    		.addValue("quantity", item.getQuantity())
		    		.addValue("product_id", item.getProduct_id())
		    		.addValue("category_id", item.getCategory_id())
		    		.addValue("id", item.getId()));
		    logger.info("Rows affected: " + count);
		  }
	  
	  
	  public void insertItem(Item item) {
		    logger.info("Saving item: " + item.getImage());
		    int count = getSimpleJdbcTemplate().update(
		    		"insert into carts (image, sex, price, quantity,product_id,category_id) values " +
		    				"(?, ?, ?, ? ,? ,?)",
		    				item.getImage(),
		    				item.getSex(),
		    				item.getPrice(),
		    				item.getQuantity(),
		    				item.getProduct_id(),
		    				item.getCategory_id());
		    logger.info("Rows affected: " + count);
	}
	  
	  private static class ItemMapper implements ParameterizedRowMapper<Item> {

		    public Item mapRow(ResultSet rs, int rowNum) throws SQLException {
		      Item item = new Item();
		      item.setImage(rs.getString("image"));
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
		      prod.setSex(rs.getString("sex"));
		      prod.setPrice(new Double(rs.getDouble("price")));
		      prod.setCategory_id(rs.getInt("category_id"));
		      prod.setId(rs.getInt("id"));
		      return prod;
		    }
	 }
}
