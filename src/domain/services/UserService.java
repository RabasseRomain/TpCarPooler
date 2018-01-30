package domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.data.User;
import domain.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository userDao;

    public void signup(User user) {
        userDao.save(user);
    }
    
    public void update(User user) {
    	
    }
}