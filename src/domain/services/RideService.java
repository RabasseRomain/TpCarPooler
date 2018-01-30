package domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.data.Ride;
import domain.repository.RideRepository;


@Service
public class RideService {
	
    @Autowired
    RideRepository rideDao;

    public void create(Ride ride) {
        rideDao.save(ride);
    }
    
    public void update(Long oldRideId, Ride newRide) {
    	Ride oldRide = rideDao.findOne(oldRideId);
    	oldRide.setDriver(newRide.getDriver());
    	oldRide.setPassengers(newRide.getPassengers());
    	oldRide.setMaxSeats(newRide.getMaxSeats());
//    	oldRide.setLocations(newRide.getLocations());
//    	oldRide.setTimeStamps(newRide.getTimeStamps());
//    	oldRide.setCaracteristics(newRide.getCaracteristics());
    	rideDao.save(oldRide);
    }
    
    public void delete(Long rideId) {
        rideDao.delete(rideId);
    }
}
