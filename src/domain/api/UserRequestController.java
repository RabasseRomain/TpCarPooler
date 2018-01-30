package domain.api;

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

import domain.data.Ride;
import domain.data.User;
import domain.repository.RideRepository;
import domain.repository.UserRepository;
import domain.services.UserService;

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
    
    // ----- UPDATE -----------------------------
	@PutMapping("{rideId}/{userId}")
    public void addRideToUser(@PathVariable("rideId") Long rideId, @PathVariable("userId") Long userId) {
        User user = userRepository.findOne(userId);
		Ride ride = rideRepository.findOne(rideId);
		
		user.getOfferedRides().add(ride);
		ride.setDriver(user);
		
		userRepository.save(user);
		rideRepository.save(ride);
    }
}
