package store.service;

import java.util.List;

import store.domain.Item;

public interface ItemManager {
	public List<Item> getItems();
	
	public void add_cartItem(String parameter);
}
