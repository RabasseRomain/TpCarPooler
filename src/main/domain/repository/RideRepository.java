package main.domain.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import main.domain.data.Ride;

@Repository
public interface RideRepository extends CrudRepository<Ride, Long> {


}