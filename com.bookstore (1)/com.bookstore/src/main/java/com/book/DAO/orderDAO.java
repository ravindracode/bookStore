package com.book.DAO;

import java.util.List;

import com.book.model.Orders;

public interface orderDAO {
	 int addOrder(Orders order);
	 Orders getOrder(int orderid);
	 void updateOrder(Orders order);
	 void deleteOrder(int orderid);
	 List<Orders>getAllOrder();
}
