 package main.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import main.domain.data.Ride;
import main.domain.repository.RideRepository;


@Service
public class RideService {
	
    @Autowired
    RideRepository rideDao;
    
    @Autowired
    private SimpMessagingTemplate template;

    public void create(Ride ride) {
        rideDao.save(ride);
        template.convertAndSend("/topic/rideList", ride);
    }
    
    public void update(Long oldRideId, Ride newRide) {
    	Ride oldRide = rideDao.findOne(oldRideId);
    	oldRide.setDriver(newRide.getDriver());
    	oldRide.setPassengers(newRide.getPassengers());
    	oldRide.setMaxSeats(newRide.getMaxSeats());
    	oldRide.setDeparturePlace(newRide.getDeparturePlace());
    	oldRide.setDepartureTime(newRide.getDepartureTime());
    	oldRide.setArrivalPlace(newRide.getArrivalPlace());
    	oldRide.setArrivalTime(newRide.getArrivalTime());
    	rideDao.save(oldRide);
    }
    
    public void delete(Long rideId) {
        rideDao.delete(rideId);
    }
}
