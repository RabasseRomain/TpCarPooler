package domain.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import domain.data.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {


}
 