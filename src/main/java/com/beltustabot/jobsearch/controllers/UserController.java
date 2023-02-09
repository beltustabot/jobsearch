package com.beltustabot.jobsearch.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.beltustabot.jobsearch.models.LoginUser;
import com.beltustabot.jobsearch.models.User;
import com.beltustabot.jobsearch.services.UserService;

@Controller
public class UserController {
	
    @Autowired
    private UserService userService;
    
    @GetMapping("/")
    public String welcome(Model model) {
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());
  
       return "index.jsp";
	}
    
    @GetMapping("/home")
    public String dashboard(Model model) {
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());
  
       return "dashboard.jsp";
	}
//    @GetMapping("/")
//    public String logregform(Model model) {
//    
//        // Bind empty User and LoginUser objects to the JSP
//        // to capture the form input
//        model.addAttribute("newUser", new User());
//        model.addAttribute("newLogin", new LoginUser());
//        return "logreg.jsp";
//    }
    //Register route
	@GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());
    
       return "register.jsp";
	}
    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser, 
            BindingResult result, Model model, HttpSession session) {
            User registeredUser= userService.register(newUser, result);
        
        if(result.hasErrors()) {
            model.addAttribute("newLogin", new LoginUser());
            return "register.jsp";
        } 
        session.setAttribute("userId" , registeredUser.getId());
        session.setAttribute("userName", registeredUser.getUserName());
        return "redirect:/home";
    }
    // Login route
    
    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());
    
       return "login.jsp";
	}
    
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
            BindingResult result, Model model, HttpSession session) {
    	User loginUser = userService.login(newLogin, result);
        // Add once service is implemented:
        // User user = userServ.login(newLogin, result);
    
        if(result.hasErrors()) {
            model.addAttribute("newUser", new User());
            return "login.jsp";
        }
        // No errors! 
        // TO-DO Later: Store their ID from the DB in session, 
        // in other words, log them in.
        session.setAttribute("userId", loginUser.getId());
        session.setAttribute("userName", loginUser.getUserName());
        return "redirect:/home";
    }
    
    
	@GetMapping("/logout")
	    public String logout(HttpSession session) {
	    	session.invalidate();
	    	return "redirect:/";
	    	
	    	
	    }

}
