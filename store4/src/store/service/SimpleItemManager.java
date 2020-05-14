package store.service;

import java.util.List;

import store.domain.Item;
import store.repository.ItemDao;

public class SimpleItemManager implements ItemManager{
  
	private ItemDao itemDao;
	
	public List<Item> getItems() {
		  return itemDao.getItemList();  
	}
	
	public void add_cartItem(String parameter){
		itemDao.insertItem(getOneItemForCart(parameter));
	}
	
	public Item getOneItemForCart(String param){
		return itemDao.getOneItem(param);
	}
	
	public void setItemDao(ItemDao itemDao) {
	    this.itemDao = itemDao;
	}
}
