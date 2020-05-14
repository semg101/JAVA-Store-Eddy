package store.service;

import java.util.List;

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
}
