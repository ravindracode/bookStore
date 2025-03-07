package com.book.DAO;

import java.util.List;

import com.book.model.Orderitems;

public interface OrderitemsDAO {
	void addOrderitem(Orderitems orderitem);
	Orderitems getOrderitem(int orderitemid);
	 void updateOrderitem(Orderitems orderitem);
	 void deleteOrderitem(int orderitemid);
	 List<Orderitems>getAllOrderitemByOrder(int orderid);
}
