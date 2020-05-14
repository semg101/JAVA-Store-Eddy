package store.repository;

import java.util.List;

import store.domain.Item;

public interface ItemDao {
    
	//Get the list of items in the cart
	public List<Item> getItemList();
	
	//Add a new item in the cart or Update item if exists
	public int getCountCartItem(String product_id);
	public Item getCartItem(String product_id);
	public Item getOneItem(String product_id);
	public void insertItem(Item prod);
	public void updateItem(String product_id, String quantity);
	
	//Update an existing item
	public void updateItem(String product_id, int quantity);
	
	//Delete an existing item
	public void deleteItem(String product_id);
}
