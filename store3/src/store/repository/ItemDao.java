package store.repository;

import java.util.List;

import store.domain.Item;

public interface ItemDao {

	public List<Item> getItemList();
}
