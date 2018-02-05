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
import main.domain.data.User;
import main.domain.repository.RideRepository;
import main.domain.repository.UserRepository;
import main.domain.services.UserService;

@RestController
@RequestMapping("/user")
public class UserRequestController {
	
	@Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;
    
    @Autowired
    RideRepository rideRepository;
	
	// ----- TEST -----
	@RequestMapping("/greeting")
    public String greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return String.format("Hello %s!", name);
    }
    
	// ----- Signup User -----------------------------
    @PostMapping
    public void signup(@RequestBody User user) {
        System.out.println("Signup | user: " + user.getLogin());
        userService.signup(user);
    }
	
	// ----- List Users -------------------------------
	@GetMapping("{id}")
    public User find(@PathVariable("id") Long userId) {
        return userRepository.findOne(userId);
    }

    @GetMapping
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }
    
    // ----- UPDATE -----------------------------
  @PutMapping("{id}")
    public void update(@PathVariable("id") Long oldUserId, @RequestBody User newUser) {
        System.out.println("Updating | user: " + newUser.getLogin());
        userService.update(oldUserId, newUser);
    }
    
    // ----- DELETE -----------------------------
    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Long userId) {
        System.out.println("Delete | user N°: " + userId);
        userService.delete(userId);
    }
    
    // ----- OFFER A RIDE -----------------------
	@PutMapping("offer/{rideId}/{userId}")
    public void offerRide(@PathVariable("rideId") Long rideId, @PathVariable("userId") Long userId) {
        User user = userRepository.findOne(userId);
		Ride ride = rideRepository.findOne(rideId);
		
		user.getOfferedRides().add(ride);
		ride.setDriver(user);
	
		userRepository.save(user);
		rideRepository.save(ride);
    }
	
	// ----- GET ON A RIDE ----------------------
	@PutMapping("book/{rideId}/{userId}")
    public void bookRideAsPassenger(@PathVariable("rideId") Long rideId, @PathVariable("userId") Long userId) {
        User user = userRepository.findOne(userId);
		Ride ride = rideRepository.findOne(rideId);
		
		if(ride.getPassengers().size() < ride.getMaxSeats()) {		
			user.getBookedRides().add(ride);
			ride.getPassengers().add(user);
			userRepository.save(user);
			rideRepository.save(ride);
		} else {
			System.out.println("Full Ride !");
		}
    }
	
	// ----- GET OFF A RIDE ---------------------
	@PutMapping("unbook/{rideId}/{userId}")
    public void unbookUserFromRide(@PathVariable("rideId") Long rideId, @PathVariable("userId") Long userId) {
        User user = userRepository.findOne(userId);
		Ride ride = rideRepository.findOne(rideId);
		
		if(ride.getPassengers().contains(user)) {		
			user.getBookedRides().remove(ride);
			ride.getPassengers().remove(user);
			userRepository.save(user);
			rideRepository.save(ride);
		} else {
			System.out.println("Not on that Ride !");
		}
    }
	
}
