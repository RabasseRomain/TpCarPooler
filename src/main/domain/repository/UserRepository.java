package main.domain.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import main.domain.data.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	
	public User findOneByLogin(String login);

}
 