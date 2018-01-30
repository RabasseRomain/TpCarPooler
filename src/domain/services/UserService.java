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
    
    public void update(Long oldUserId, User newUser) {
    	User oldUser = userDao.findOne(oldUserId);
    	oldUser.setLogin(newUser.getLogin());
    	oldUser.setPassword(newUser.getPassword());
    	oldUser.setBirthDate(newUser.getBirthDate());
    	oldUser.setFirstName(newUser.getFirstName());
    	oldUser.setLastName(newUser.getLastName());
    	oldUser.setEmail(newUser.getEmail());
    	oldUser.setRating(newUser.getRating());
    	oldUser.setConfirmed(newUser.isConfirmed());
    	userDao.save(oldUser);
    }
    
    public void delete(Long userId) {
        userDao.delete(userId);
    }
}