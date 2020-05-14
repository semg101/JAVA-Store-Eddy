package store.repository;

import java.util.List;

import store.domain.Customer;
import store.domain.Item;
import store.domain.Product;

public interface ItemDao {
    
	//Get the list of items in the cart
	public List<Item> getItemList(Object user_session_id);
	
	//Get one product from the table product
    public Product getOneProduct(String product_id);
    
    //The number of items of a particular user
    public int user_item(Object user_session_id);
	
	//Add a new item in the cart or Update item if exists
	public int getCountCartItem(String product_id, Object user_session_id);
	public Item getCartItem(String product_id, Object user_session_id);
	public Item getOneItem(String product_id, Object user_session_id);
	public void insertItem(Item prod);
	public void updateItem(String product_id, String quantity, Object user_session_id);
	
	//Update an existing item
	public void updateItem(String product_id, int quantity, Object user_session_id);
	
	//Update an existing item when the quantity is unavailable
    public void updateItem2(String product_id, String message, Object user_session_id);
	
	//Delete an existing item
	public void deleteItem(String product_id, Object user_session_id);
	
	//Add the subtotal of a particular user
	public void add_order(Object customer_id, float total);
	
	//Check if a user has got an order
	public int getcountorder(Object customer_id);
	
	//Add a customer: customer_id is the email address
	public void add_customer(Object customer_id, Customer customer);
	//update a customer: customer_id is the email address
    public void update_customer(Object customer_id, Customer customer);
	//Check if a user has his details in the database: customer_id is the email address
	public int getcountcustomer(Object customer_id);
}
