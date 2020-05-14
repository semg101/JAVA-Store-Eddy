package store.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;

import store.domain.Item;


public class JdbcItemDao extends SimpleJdbcDaoSupport implements ItemDao{

	 /** Logger for this class and subclasses */
	  protected final Log logger = LogFactory.getLog(getClass());

	  public List<Item> getItemList() {
	    logger.info("Getting products!");
	    
	    List<Item> items = getSimpleJdbcTemplate().query(
	    		//"​select product.image as image, size, product.description as description, price ,product.id as id from product"
	    		//+ " INNER JOIN categories on categories.id=product.category_id"
	    		//+ " WHERE categories.category='shoes' and product.sex ='men'",new ProductMapper());
	    		
	    		"select image, price, quantity, product_id, category_id, id from carts",new ItemMapper());
		return items;
	  }
	  
	  private static class ItemMapper implements ParameterizedRowMapper<Item> {

		    public Item mapRow(ResultSet rs, int rowNum) throws SQLException {
		      Item prod = new Item();
		      prod.setImage(rs.getString("image"));
		      prod.setPrice(new Double(rs.getDouble("price")));
		      prod.setQuantity(rs.getInt("quantity"));
		      prod.setProduct_id(rs.getInt("product_id"));
		      prod.setCategory_id(rs.getInt("category_id"));
		      prod.setTotal(new Double(rs.getDouble("price")*rs.getInt("quantity")));
		      prod.setId(rs.getInt("id"));
		      return prod;
		    }
		  }
}
