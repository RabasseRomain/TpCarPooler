package dao;

import java.util.List;

import data.User;

public class UserDao{

	// ----- CRUD -------------------------------
	
    // ----- Create -----
    public void create(User user) {
    	
    }
    
    // ----- Read -----
	public User read(User user) {
		return user;
	}
    
    // ----- Update -----
    public void update(Long id, User newUser) {

    }
    
    // ----- Delete -----
    public void delete(Long id) {
    
    }
	
	// ----- MISC -------------------------------
    
    // ----- List -----
	public List<User> list(List<User> users) {
		return users;
	}
}
