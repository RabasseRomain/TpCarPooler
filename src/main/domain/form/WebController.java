package main.domain.form;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import main.domain.data.Ride;
import main.domain.data.User;
import main.domain.repository.RideRepository;
import main.domain.repository.UserRepository;
import main.domain.services.RideService;
import main.domain.services.UserService;

@Controller
public class WebController extends WebMvcConfigurerAdapter {
	
	// ----- PARAMETERS ---------------------------------------------------------------------------
	@Autowired
	private UserService userService;
	@Autowired
	private RideService rideService;
	@Autowired
    UserRepository userRepository;
	@Autowired
    RideRepository rideRepository;
	
	// ----- FALLBACK URL -------------------------------------------------------------------------
	@GetMapping
	public String next() {
		System.out.println("NEXT");
		return "homepage";
	}
	
	// ----- Show Index -------------------------
    @GetMapping("/")
    public String showIndex() {
        return "Index";
    }
	
	// ----- Show Index -------------------------
    @GetMapping("/I")
    public String showIndexV2() {
        return "Index";
    }

    // ----- SIGN UP USER -------------------------------------------------------------------------
    // ----- Show User Form ---------------------
    @GetMapping("/U")
    public String showUserForm(UserCreation userCreation) {
        return "userForm";
    }
    
    // ----- Check User Sign up -----------------
    @PostMapping("/SignUp")
    public String checkUserInfo(@Valid UserCreation userCreation, BindingResult bindingResult) {
    	
    	if (bindingResult.hasErrors()) {
            return "userForm";
        }

        User user = new User();
        
        user.setLogin(userCreation.getLogin());
        user.setPassword(userCreation.getPassword());
        user.setEmail(userCreation.getEmail());
        user.setBirthDate(userCreation.getBirthDate());
        
        userService.signup(user);
        
        return "redirect:/homepage";
    }
    
    // ----- LOG IN USER --------------------------------------------------------------------------
    // ----- Show Login Form ---------------------
    @GetMapping("/L")
    public String showLoginForm(UserLoginForm logIn) {
        return "LoginForm";
    }
    
    // ----- Check User Log In -----------------
    @PostMapping("/Login")
    public String checkUserLogIn(@Valid UserLoginForm userLoginForm, BindingResult bindingResult) {

    	if (bindingResult.hasErrors()) {
            return "LoginForm";
        }
        
        User user = userRepository.findOneByLogin(userLoginForm.getLogin());
        
        if(user == null) {
        	return "userForm";
        }
        
        if (user.getPassword().equalsIgnoreCase(userLoginForm.getPassword())) {
        	System.out.println(user.getLogin());
        	return "redirect:/homepage";
        }
        
        return "LoginForm";
    }    
    
    // ----- OFFER RIDE ---------------------------------------------------------------------------
    // ----- Show Ride Form ---------------------
    @GetMapping("/R")
    public String showRideForm(RideCreation rideCreation) {
        return "rideForm";
    }
    
    // ----- Check Ride Creation ----------------
    @PostMapping("/RideOffer")
    public String checkRideInfo(@Valid RideCreation rideCreation, BindingResult bindingResult) {
    	
    	if (bindingResult.hasErrors()) {
            return "rideForm";
        }

        Ride ride = new Ride();
        User user = userRepository.findOneByLogin(rideCreation.getLogin());
        
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
    @GetMapping("/B")
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
        
        ride.getPassengers().add(user);
        user.getBookedRides().add(ride);
        
        rideService.update(rideBooking.getRideId(), ride);
        userService.update(user.getId(), user);
        
        return "redirect:/homepage";
    }
}
