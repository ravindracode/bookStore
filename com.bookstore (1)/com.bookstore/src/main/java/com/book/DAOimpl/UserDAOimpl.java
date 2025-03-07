package com.book.DAOimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.book.DAO.UserDAO;
import com.book.connection.SQLConnection;
import com.book.model.User;

public class UserDAOimpl implements UserDAO{

	@Override
	public void adduser(User user) {
		String INSERT_USER_QUERY = "INSERT INTO User (name, password, email) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = SQLConnection.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER_QUERY)) {

            preparedStatement.setString(1, user.getName());
            
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getEmail());
            

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
	}

	@Override
	public User getuser(int userid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateuser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteuser(int userid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User validateUser(String email, String password) {
		String VALIDATE_USER_QUERY = "SELECT * FROM user WHERE email = ? AND password = ?";
        User user = null;

        try (Connection connection = SQLConnection.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(VALIDATE_USER_QUERY)) {

            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            ResultSet res = preparedStatement.executeQuery();

            if (res.next()) {
                user = extractUser(res);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    private User extractUser(ResultSet res) throws SQLException {
        return new User(
            res.getInt("userid"),
            res.getString("name"),
           
            res.getString("password"),
            res.getString("email"),
           
            
            res.getTimestamp("createdDate"),
            res.getTimestamp("lastLoginDate")
        );
    }
	

}
