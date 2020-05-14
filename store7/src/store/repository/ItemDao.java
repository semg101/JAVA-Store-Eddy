package store.repository;

import java.util.List;

import store.domain.Item;
import store.domain.Product;

public interface ItemDao {
    
	//Get the list of items in the cart
	public List<Item> getItemList();
	
	//Get one product from the table product
    public Product getOneProduct(String product_id);
	
	//Add a new item in the cart or Update item if exists
	public int getCountCartItem(String product_id);
	public Item getCartItem(String product_id);
	public Item getOneItem(String product_id);
	public void insertItem(Item prod);
	public void updateItem(String product_id, String quantity);
	
	//Update an existing item
	public void updateItem(String product_id, int quantity);
	
	//Update an existing item when the quantity is unavailable
    public void updateItem2(String product_id, String message);
	
	//Delete an existing item
	public void deleteItem(String product_id);
}
