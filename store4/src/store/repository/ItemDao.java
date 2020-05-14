package store.repository;

import java.util.List;

import store.domain.Item;

public interface ItemDao {

	public List<Item> getItemList();
	
	public Item getOneItem(String param);
	
	public void updateItem(Item prod);
	
	public void insertItem(Item prod);
}
