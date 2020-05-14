package store.service;

import java.util.List;

import store.domain.Item;
import store.repository.ItemDao;

public class SimpleItemManager implements ItemManager{
  
	private ItemDao itemDao;
	
	//Get the list of items in the cart
	public List<Item> getItems() {
		  return itemDao.getItemList();  
	}
	
	//Add a new item in the cart or Update item if exists
	public void add_cartItem(String product_id){
		
		//IF THE PRODUCT DOESNT EXIST, WE WILL ADD IT IN THE TABLE CART
		if(getCountOneCartItem(product_id)==0){
		  itemDao.insertItem(getOneItemForCart(product_id));
		}else{//IF THE PRODUCT EXISTS, WE WILL INCREMENT ITS QUANTITY IN THE TABLE CART
			Item item = getOneCartItem(product_id);
			item.quantity++;
			update_cartItem( product_id,  item.quantity);
		}
	}
	public Item getOneItemForCart(String product_id){
		return itemDao.getOneItem(product_id);
	}
	public int getCountOneCartItem(String product_id){
		return itemDao.getCountCartItem(product_id); 
	}
	public Item getOneCartItem(String product_id){
		return itemDao.getCartItem(product_id);
	}
	public void update_cartItem(String product_id, int quantity){
		itemDao.updateItem(product_id, quantity);
	}
	
	//Delete an existing item
	public void delete_cartItem(String product_id){
		itemDao.deleteItem(product_id);
	}
	
	//Update an existing item
	public void update_cartItem(String product_id, String quantity){
		if(quantity.matches("0")){
			itemDao.deleteItem(product_id);
		}
		else{
		  itemDao.updateItem(product_id, quantity);
		  //Test if the quantity is in stock
		  if(itemDao.getOneProduct(product_id).getStock()<itemDao.getCartItem(product_id).getQuantity())
		  {
			  String message = "This quantity is not available";
			  itemDao.updateItem2(product_id, message);
		  }else
		  {
			  String message = "";
			  itemDao.updateItem2(product_id, message);
		  }
		}
	}
	
	
	
	public void setItemDao(ItemDao itemDao) {
	    this.itemDao = itemDao;
	}
}
