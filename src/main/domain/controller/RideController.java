package main.domain.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import main.domain.data.Ride;
import main.domain.data.User;
import main.domain.form.RideBooking;
import main.domain.form.RideCreation;
import main.domain.repository.RideRepository;
import main.domain.repository.UserRepository;
import main.domain.services.RideService;
import main.domain.services.UserService;

public class RideController extends WebMvcConfigurerAdapter  {
	
	@Autowired
	private UserService userService;
	@Autowired
    UserRepository userRepository;
	@Autowired
	private RideService rideService;
	@Autowired
    RideRepository rideRepository;
	
    // ----- OFFER RIDE ---------------------------------------------------------------------------
    // ----- Show Ride Form ---------------------
    @GetMapping("/RC")
    public String showRideForm(RideCreation rideCreation) {
        return "rideForm";
    }
    
    // ----- Check Ride Creation ----------------
    @PostMapping("/RideCreate")
    public String checkRideInfo(@Valid RideCreation rideCreation, BindingResult bindingResult) {
    	
    	if (bindingResult.hasErrors()) {
            return "rideForm";
        }

        Ride ride = new Ride();
        User user = userRepository.findOneByLogin(rideCreation.getLogin());
        
        if(user == null) {
        	return "rideForm";
        }
        
        ride.setDeparturePlace(rideCreation.getDeparturePlace());
        ride.setDepartureTime(rideCreation.getDepartureTime());
        ride.setArrivalPlace(rideCreation.getArrivalPlace());
        ride.setArrivalTime(rideCreation.getArrivalTime());
        ride.setMaxSeats(rideCreation.getMaxSeats());
        ride.setDriver(user);
        
        rideService.create(ride);
        
        return "redirect:/homepage";
    }
        
    // ----- BOOK RIDE ----------------------------------------------------------------------------
    // ----- Show Book Form ---------------------
    @GetMapping("/RB")
    public String showBookForm(RideBooking rideBooking) {
        return "bookForm";
    }
    
    // ----- Check Ride Booking ----------------
    @PostMapping("/RideBook")
    public String checkBookInfo(@Valid RideBooking rideBooking, BindingResult bindingResult) {
    	
    	if (bindingResult.hasErrors()) {
            return "bookForm";
        }

        Ride ride = rideRepository.findOne(rideBooking.getRideId());
        User user = userRepository.findOneByLogin(rideBooking.getLogin());
        
        if(user == null) {
        	return "bookForm";
        }
        if(ride == null) {
        	return "bookForm";
        }
        if(ride.getPassengers().size() == ride.getMaxSeats()) {
        	return "bookForm";
        }
        
        ride.getPassengers().add(user);
        user.getBookedRides().add(ride);
        
        rideService.update(rideBooking.getRideId(), ride);
        userService.update(user.getId(), user);
        
        return "redirect:/homepage";
    }
    
    // ----- VIEW ALL RIDE ---------------------------------------------------------------------------
    @GetMapping("/RL")
    public String list(Model model) {

        Iterable<Ride> rides;
        rides = rideRepository.findAll();
        model.addAttribute("rides", rides);
        return "rideList";
	}
    
}
