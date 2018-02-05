package main.domain.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import main.domain.data.Ride;
import main.domain.repository.RideRepository;
import main.domain.services.RideService;

@RestController
@RequestMapping("/ride")
public class RideRequestController {
	@Autowired
    RideService rideService;

    @Autowired
    RideRepository rideRepository;
	
	// ----- TEST -----
	@RequestMapping("/greeting")
    public String greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return String.format("Hello %s!", name);
    }
    
	// ----- Create Ride -----------------------------
    @PostMapping
    public void signup(@RequestBody Ride ride) {
        System.out.println("Create | ride: " + ride);
        rideService.create(ride);
    }
	
	// ----- List Users -------------------------------
	@GetMapping("{id}")
    public Ride find(@PathVariable("id") Long rideId) {
        return rideRepository.findOne(rideId);
    }

    @GetMapping
    public Iterable<Ride> findAll() {
        return rideRepository.findAll();
    }
    
    // ----- UPDATE -----------------------------
  @PutMapping("{id}")
    public void update(@PathVariable("id") Long oldRideId, @RequestBody Ride newRide) {
        System.out.println("Updating | ride: " + newRide);
        rideService.update(oldRideId, newRide);
    }
    
    // ----- DELETE -----------------------------
    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Long rideId) {
        System.out.println("Delete | ride N°: " + rideId);
        rideService.delete(rideId);
    }
}
