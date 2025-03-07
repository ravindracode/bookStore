package com.book.DAOimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.book.DAO.OrderitemsDAO;
import com.book.connection.SQLConnection;
import com.book.model.Orderitems;

public class OrderitemsDAOimpl implements OrderitemsDAO {

	@Override
	public void addOrderitem(Orderitems orderitem) {
		 String sql = "INSERT INTO orderitems (orderid, bookid, quantity, price) VALUES (?, ?, ?,?)";
		    
		    try (Connection con = SQLConnection.connect();
		         PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {  // Request generated keys

		        ps.setInt(1, orderitem.getOrderid());
		        ps.setInt(2, orderitem.getBookid());
		        ps.setInt(3, orderitem.getQuantity());
		        ps.setDouble(4, orderitem.getPrice());

		        	int res = ps.executeUpdate();
				
				if(res==0) {
					throw new SQLException("Creating order failed, no rows affected");
				}
				
		        try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
		            if (generatedKeys.next()) {
		            	orderitem.setOrderitemsid(generatedKeys.getInt(1));  // Return generated key (e.g., order item ID)
		            } else {
		                throw new SQLException("Creating order item failed, no ID obtained.");
		            }
		        }
		    }
		    catch (Exception e) {
		    		e.printStackTrace();
		    }
		
	}

	@Override
	public Orderitems getOrderitem(int orderitemid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateOrderitem(Orderitems orderitem) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteOrderitem(int orderitemid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Orderitems> getAllOrderitemByOrder(int orderid) {
		String GETALL_ORDERITEM_QUERY="SELECT * FROM `orderitemsid`";
		
		ArrayList<Orderitems> orderitemList = new ArrayList<Orderitems>();
		
		try(Connection connection = SQLConnection.connect();
			Statement statement = connection.createStatement()){
			
			ResultSet res = statement.executeQuery(GETALL_ORDERITEM_QUERY);
			
					while(res.next()) {
						Orderitems orderitem = extractOrderitem(res);
						orderitemList.add(orderitem);
					}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return orderitemList;
	}

	Orderitems extractOrderitem(ResultSet res) throws SQLException{

		int orderitemsid=res.getInt("orderitemsid");
		int orderid=res.getInt("orderid");
		int bookid=res.getInt("bookid");
		int quantity=res.getInt("quantity");
		double price=res.getDouble("price");
		
		Orderitems orderitems = new Orderitems(orderitemsid, orderid, bookid, quantity, price);
		
		return orderitems;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
