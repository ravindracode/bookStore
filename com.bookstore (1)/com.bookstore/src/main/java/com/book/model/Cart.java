package com.book.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {
	
	private Map<Integer,CartItems> items;
	
	public Cart() {
		this.items=new HashMap<Integer,CartItems>();
	}
	
	public void additems(CartItems item) {
		int bookId=item.getBookid();
		
		if(items.containsKey(item.getBookid())){
			CartItems existingItem=items.get(item.getBookid());
			existingItem.setQuatity(item.getQuatity() + existingItem.getQuatity());
		}
		else {
			items.put(bookId,item);
		}
	}
	
	public void updateItems(int bookid,int quatity) {
		if(items.containsKey(bookid)) {
			if(quatity<=0) {
				items.remove(bookid);
			}
			else {
				items.get(bookid).setQuatity(quatity);
			}
		}
	}
	
	public void removeItems(int bookid) {
		items.remove(bookid);
	}
	
	public Map<Integer, CartItems> getItems(){
		return items;
	}
	
	public void clear(){
		items.clear();
	}
	
	
}
