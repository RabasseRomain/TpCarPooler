package domain.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import domain.data.User;
import domain.repository.UserRepository;
import domain.services.UserService;

@RestController
public class RequestController {
	
	@Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;
	
	// ----- TEST -----
	@RequestMapping("/greeting")
    public String greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return String.format("Hello %s!", name);
    }
    
	// ----- Signup User -----------------------------
    @PostMapping
    public void signup(@RequestBody User user) {
        System.out.println("Signup | user: " + user);
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
  @PutMapping
    public void update(@RequestBody User user) {
        System.out.println("Updating | user: " + user);
        userService.update(user);
    }
    
    // ----- DELETE -----------------------------

}
