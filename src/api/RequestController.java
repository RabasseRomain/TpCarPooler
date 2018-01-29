package api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestController {
	
	// ----- TEST -----
	@RequestMapping("/greeting")
    public String greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return String.format("Hello %s!", name);
    }
    
	// ----- CREATE -----------------------------
	@RequestMapping("/create")
	public String createUser(@RequestParam(value="name", defaultValue="World") String name) {
		return String.format("%s was created!", name);
    }
	
	// ----- READ -------------------------------
	@RequestMapping("/read")
    public String readUser(@RequestParam(value="name", defaultValue="World") String name) {
    	return String.format("%s is here!", name);
    }
    
    // ----- UPDATE -----------------------------
	@RequestMapping("/update")
    public String updateUser(@RequestParam(value="name", defaultValue="World") String name) {
    	return String.format("%s was changed!", name);
    }
    
    // ----- DELETE -----------------------------
	@RequestMapping("/delete")
    public String deleteUser(@RequestParam(value="name", defaultValue="World") String name) {
    	return String.format("%s is gone!", name);
    }
}
