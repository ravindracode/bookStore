package com.book.DAOimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.book.DAO.GenresDAO;
import com.book.connection.SQLConnection;
import com.book.model.Genres;

public class GenresDAOimpl implements GenresDAO {

	@Override
	public void addGenres(Genres genres) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Genres getGenres(int genresid) {
		String GET_GENRES_QUERY = "SELECT * FROM `genres` WHERE `genresid`=?";
		Genres genres = null;

        try (Connection connection = SQLConnection.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_GENRES_QUERY)) {

            preparedStatement.setInt(1, genresid);
            ResultSet res = preparedStatement.executeQuery();

            if (res.next()) {  
            	genres = executeGenres(res);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return genres;
	}

	@Override
	public void updateGenres(Genres genres) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteGenres(int genresid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Genres> getAllGenres() {

		String GETALL_GENRES_QUREY="SELECT * FROM `genres`";
		ArrayList<Genres> genreslist = new ArrayList<>();
		
		try(Connection connection=SQLConnection.connect();
				Statement statement=connection.createStatement();
					ResultSet res =statement.executeQuery(GETALL_GENRES_QUREY)){
			
			while(res.next()) {
				
				genreslist.add(executeGenres(res));
			}
			
		}
		catch (SQLException e) {
				e.printStackTrace();
		}
		return genreslist;
	}
	
	
	  Genres executeGenres(ResultSet res) throws SQLException{
		  
		  return new Genres(
				  
				  res.getInt("genresid"),
				  res.getString("name"),
				  res.getFloat("rating"),
				  res.getString("description"),
				  res.getString("imagepath"),
				  res.getInt("adminuserid"));
	  }
	
	
	public static void main(String[] args) {
		GenresDAOimpl genresDAOimpl = new GenresDAOimpl();
		
		System.out.println(genresDAOimpl.getAllGenres());
	}
	
	
	

}
