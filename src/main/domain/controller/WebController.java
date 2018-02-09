package main.domain.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Controller
public class WebController extends WebMvcConfigurerAdapter {

	// ----- FALLBACK URL -------------------------------------------------------------------------
	@GetMapping
	public String next() {
		//System.out.println("NEXT");
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

}
