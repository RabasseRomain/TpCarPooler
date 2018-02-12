package main.domain.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import main.domain.data.User;
import main.domain.form.UserCreation;
import main.domain.form.UserLogin;
import main.domain.repository.UserRepository;
import main.domain.services.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	@Autowired
    UserRepository userRepository;
	
    // ----- SIGN UP USER -------------------------------------------------------------------------
    // ----- Show User Form ---------------------
    @GetMapping("/US")
    public String showUserForm(UserCreation userCreation) {
        return "userForm";
    }
    
    // ----- Check User Sign up -----------------
    @PostMapping("/UserSignup")
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
        
        return "redirect:/H";
    }
    
    // ----- LOG IN USER --------------------------------------------------------------------------
    // ----- Show Login Form ---------------------
    @GetMapping("/UL")
    public String showLoginForm(UserLogin logIn) {
        return "LoginForm";
    }
    
    // ----- Check User Log In -----------------
    @PostMapping("/UserLogin")
    public String checkUserLogIn(@Valid UserLogin userLoginForm, BindingResult bindingResult) {

    	if (bindingResult.hasErrors()) {
            return "LoginForm";
        }
        
        User user = userRepository.findOneByLogin(userLoginForm.getLogin());
        
        if(user == null) {
        	return "userForm";
        }
        
        if (user.getPassword().equalsIgnoreCase(userLoginForm.getPassword())) {
        	return "redirect:/H";
        }
        
        return "LoginForm";
    }    
    
}
