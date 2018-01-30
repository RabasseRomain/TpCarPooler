package domain.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import domain.data.Ride;

@Repository
public interface RideRepository extends CrudRepository<Ride, Long> {


}