package com.book.DAO;

import java.util.List;

import com.book.model.User;

public interface UserDAO {

	void adduser(User user);
	User getuser(int userid);
	void updateuser(User user);
	void deleteuser(int userid);
	List<User>getAllUsers();
	User validateUser(String email,String password);
	
	
	
	
	
	
}
