package com.book.DAOimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.book.DAO.orderDAO;
import com.book.connection.SQLConnection;
import com.book.model.Orders;

public class OrderDAOimpl implements orderDAO {

	@Override
	public int addOrder(Orders order) {
		String INSERT_ORDERS_QUERY = "INSERT INTO `orders` ( userid, genresid, orderdate, totalamount, status, paymentmode) VALUES (?, ?, ?, ?, ?,?)";
		
		int Ordereid = -1; // Default value indicating failure
		try(Connection connection = SQLConnection.connect();
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ORDERS_QUERY,Statement.RETURN_GENERATED_KEYS)) {
			
			preparedStatement.setInt(1,order.getUserid());
			preparedStatement.setInt(2, order.getGenresid());
			preparedStatement.setTimestamp(3, order.getOrderdate());
			preparedStatement.setDouble(4, order.getTotalamount());
			preparedStatement.setString(5, order.getStatus());
			preparedStatement.setString(6, order.getPaymentmode());
			
			int res = preparedStatement.executeUpdate();
			
			if(res==0) {
				throw new SQLException("Creating order failed, no rows affected");
			}
			
			try(ResultSet generatedKeys=preparedStatement.getGeneratedKeys()){
				if(generatedKeys.next()) {
					Ordereid=generatedKeys.getInt(1);
					order.setOrderid(Ordereid);
				}else {
					throw new SQLException("creating order failed , no ID obatined.");
				}
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Ordereid;
	}

	@Override
	public Orders getOrder(int orderid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateOrder(Orders order) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteOrder(int orderid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Orders> getAllOrder() {
		String GETALL_ORDERS_QUERY="SELECT * FORM 'orders'";
		ArrayList<Orders> ordersList = new ArrayList<Orders>();
		
		try(Connection connection = SQLConnection.connect();
			Statement statement = connection.createStatement()) {
			
			ResultSet res = statement.executeQuery(GETALL_ORDERS_QUERY);
			
			while(res.next()) {
				Orders order = extractOrders(res);
				ordersList.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ordersList;
	}
	
	
	
	Orders extractOrders(ResultSet res) throws SQLException{

		int orderid=res.getInt("orderid");
		int userid=res.getInt("userid");
		int genresid=res.getInt("genresid");
		Timestamp orderdate = res.getTimestamp("orderdate");
		double totalamount=res.getDouble("totalamount");
		String status=res.getString("status");
		String paymentmode=res.getString("paymentmode");
		
			Orders orders = new Orders(orderid, userid, genresid, orderdate, totalamount, status, paymentmode);
			
			return orders;
		

 }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}