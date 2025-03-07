package com.book.DAOimpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.book.DAO.FictionDAO;
import com.book.connection.SQLConnection;
import com.book.model.Book;
import com.book.model.Fiction;

public class FictionDAOimpl implements FictionDAO {

	@Override
	public void addfictionn(Fiction fiction) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Fiction getFiction(int fictionid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateFiction(Fiction fiction) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteFiction(int fictionid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Fiction> getALLFictions() {
					String GET_ALL_FICTIONS="SELECT * FROM `fiction`";
		
					ArrayList<Fiction> fictionList = new ArrayList<>();
					
					try(Connection connection=SQLConnection.connect();
							Statement statement=connection.createStatement()){
						
							ResultSet res = statement.executeQuery(GET_ALL_FICTIONS);
									
							while(res.next()) {
								fictionList.add(extractFiction(res));
							}
						
					}
					catch (Exception e) {
							e.printStackTrace();
					
					}	
					return fictionList;
	}
	
	
	
		private Fiction extractFiction(ResultSet res) throws SQLException {
		    int fictionid = res.getInt("fictionid");
		    String fictionname = res.getString("fictionname");
		    int price = res.getInt("price");
		    float rating = res.getFloat("rating");
		    String imagepath = res.getString("imagepath");
		    String description = res.getString("description");
		   
		    return new Fiction(fictionid, fictionname, price, rating, imagepath, description);
		   
		}
	
	
	public static void main(String[] args) {
		FictionDAOimpl fictionDAOimpl = new FictionDAOimpl();
		List<Fiction> allFictions = fictionDAOimpl.getALLFictions();
		int count=0;
		
		for (Fiction fiction : allFictions) {
			if(fiction==fiction) {
				count++;
			}
		}
		System.out.println(count);
	}
	
	
	
	
	
	
	

}
