package store.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;

import store.domain.Product;

public class JdbcProductDao extends SimpleJdbcDaoSupport implements ProductDao {

  /** Logger for this class and subclasses */
  protected final Log logger = LogFactory.getLog(getClass());

  public List<Product> getProductList() {
    logger.info("Getting products!");
    
    List<Product> products = getSimpleJdbcTemplate().query(
    		//"​select product.image as image, size, product.description as description, price ,product.id as id from product"
    		//+ " INNER JOIN categories on categories.id=product.category_id"
    		//+ " WHERE categories.category='shoes' and product.sex ='men'",new ProductMapper());
    		
    		"select image, size, description, price, id from product where sex=? and category_id=?",new ProductMapper(),new Object[]{"men",4});
	return products;
  }
  
  public List<Product> getAccessoriesmenList() {
	    logger.info("Getting products!");
	    
	    List<Product> products = getSimpleJdbcTemplate().query(
	    		//"​select product.image as image, size, product.description as description, price ,product.id as id from product"
	    		//+ " INNER JOIN categories on categories.id=product.category_id"
	    		//+ " WHERE categories.category='shoes' and product.sex ='men'",new ProductMapper());
	    		
	    		"select image, size, description, price, id from product where sex=? and category_id=?",new ProductMapper(),new Object[]{"men",5});
		return products; 
  }
  
  public List<Product> getAccessorieswomenList() {
	    logger.info("Getting products!");
	    
	    List<Product> products = getSimpleJdbcTemplate().query(
	    		//"​select product.image as image, size, product.description as description, price ,product.id as id from product"
	    		//+ " INNER JOIN categories on categories.id=product.category_id"
	    		//+ " WHERE categories.category='shoes' and product.sex ='men'",new ProductMapper());
	    		
	    		"select image, size, description, price, id from product where sex=? and category_id=?",new ProductMapper(),new Object[]{"women",5});
		return products; 
  }
  
  public List<Product> getHatsmenList() {
	    logger.info("Getting products!");
	    
	    List<Product> products = getSimpleJdbcTemplate().query(
	    		//"​select product.image as image, size, product.description as description, price ,product.id as id from product"
	    		//+ " INNER JOIN categories on categories.id=product.category_id"
	    		//+ " WHERE categories.category='shoes' and product.sex ='men'",new ProductMapper());
	    		
	    		"select image, size, description, price, id from product where sex=? and category_id=?",new ProductMapper(),new Object[]{"men",3});
		return products; 
  }
  
  public List<Product> getHatswomenList() {
	    logger.info("Getting products!");
	    
	    List<Product> products = getSimpleJdbcTemplate().query(
	    		//"​select product.image as image, size, product.description as description, price ,product.id as id from product"
	    		//+ " INNER JOIN categories on categories.id=product.category_id"
	    		//+ " WHERE categories.category='shoes' and product.sex ='men'",new ProductMapper());
	    		
	    		"select image, size, description, price, id from product where sex=? and category_id=?",new ProductMapper(),new Object[]{"women",3});
		return products; 
  }
  
  public List<Product> getShoesmenList() {
	    logger.info("Getting products!");
	    
	    List<Product> products = getSimpleJdbcTemplate().query(
	    		//"​select product.image as image, size, product.description as description, price ,product.id as id from product"
	    		//+ " INNER JOIN categories on categories.id=product.category_id"
	    		//+ " WHERE categories.category='shoes' and product.sex ='men'",new ProductMapper());
	    		
	    		"select image, size, description, price, id from product where sex=? and category_id=?",new ProductMapper(),new Object[]{"men",4});
		return products; 
  }
  
  public List<Product> getShoeswomenList() {
	    logger.info("Getting products!");
	    
	    List<Product> products = getSimpleJdbcTemplate().query(
	    		//"​select product.image as image, size, product.description as description, price ,product.id as id from product"
	    		//+ " INNER JOIN categories on categories.id=product.category_id"
	    		//+ " WHERE categories.category='shoes' and product.sex ='men'",new ProductMapper());
	    		
	    		"select image, size, description, price, id from product where sex=? and category_id=?",new ProductMapper(),new Object[]{"women",4});
		return products; 
  }
  
  public List<Product> getTeeshirtsmenList() {
	    logger.info("Getting products!");
	    
	    List<Product> products = getSimpleJdbcTemplate().query(
	    		//"​select product.image as image, size, product.description as description, price ,product.id as id from product"
	    		//+ " INNER JOIN categories on categories.id=product.category_id"
	    		//+ " WHERE categories.category='shoes' and product.sex ='men'",new ProductMapper());
	    		
	    		"select image, size, description, price, id from product where sex=? and category_id=?",new ProductMapper(),new Object[]{"men",1});
		return products; 
  }
  
  public List<Product> getTeeshirtswomenList() {
	    logger.info("Getting products!");
	    
	    List<Product> products = getSimpleJdbcTemplate().query(
	    		//"​select product.image as image, size, product.description as description, price ,product.id as id from product"
	    		//+ " INNER JOIN categories on categories.id=product.category_id"
	    		//+ " WHERE categories.category='shoes' and product.sex ='men'",new ProductMapper());
	    		
	    		"select image, size, description, price, id from product where sex=? and category_id=?",new ProductMapper(),new Object[]{"women",1});
		return products; 
  }
  
  public List<Product> getTrousersmenList() {
	    logger.info("Getting products!");
	    
	    List<Product> products = getSimpleJdbcTemplate().query(
	    		//"​select product.image as image, size, product.description as description, price ,product.id as id from product"
	    		//+ " INNER JOIN categories on categories.id=product.category_id"
	    		//+ " WHERE categories.category='shoes' and product.sex ='men'",new ProductMapper());
	    		
	    		"select image, size, description, price, id from product where sex=? and category_id=?",new ProductMapper(),new Object[]{"men",2});
		return products; 
  }
  
  public List<Product> getTrouserswomenList() {
	    logger.info("Getting products!");
	    
	    List<Product> products = getSimpleJdbcTemplate().query(
	    		//"​select product.image as image, size, product.description as description, price ,product.id as id from product"
	    		//+ " INNER JOIN categories on categories.id=product.category_id"
	    		//+ " WHERE categories.category='shoes' and product.sex ='men'",new ProductMapper());
	    		
	    		"select image, size, description, price, id from product where sex=? and category_id=?",new ProductMapper(),new Object[]{"women",2});
		return products; 
  }
  
  public void saveProduct(Product prod) {
    logger.info("Saving product: " + prod.getDescription());
    int count = getSimpleJdbcTemplate().update(
    		"update product set image = :image,size = :size,description = :description,"
    		+ " price = :price where id = :id",
    		new MapSqlParameterSource().addValue("image", prod.getImage())
    		.addValue("size", prod.getSize())
    		.addValue("description", prod.getDescription())
    		.addValue("price", prod.getPrice())
    		.addValue("id", prod.getId()));
    logger.info("Rows affected: " + count);
  }

  private static class ProductMapper implements ParameterizedRowMapper<Product> {

    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
      Product prod = new Product();
      prod.setImage(rs.getString("image"));
      prod.setSize(rs.getString("size"));
      prod.setDescription(rs.getString("description"));
      prod.setPrice(new Double(rs.getDouble("price")));
      prod.setId(rs.getInt("id"));
      return prod;
    }
  }
}
