package store.service;

import java.util.List;

import store.domain.Customer;
import store.domain.Item;

public interface ItemManager {
	
	//Get the list of items in the cart
	public List<Item> getItems(Object user_session_id);
	
	//The number of items of a particular user
	public int user_items(Object user_session_id);
	
	//Add a new item in the cart or Update item if exists
	public void add_cartItem(String product_id, Object user_session_id);
	
	//Delete an existing item
	public void delete_cartItem(String product_id, Object user_session_id);
	
	//Update an existing item
	public void update_cartItem(String product_id, String quantity, Object user_session_id);
	
	//Add the subtotal of a particular user
	public void add_orders(Object customer_id, float total);
	
	//Check if a user has an order
	public int getcountorders(Object customer_id);
	
	//Add a customer
    public void add_customers(Object customer_id, Customer customer);
    //Check if a user has his details in the database
  	public int getcountcustomers(Object customer_id);
}
