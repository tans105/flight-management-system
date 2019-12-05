package com.tanmay.flightreservation.controller;

import com.tanmay.flightreservation.entities.Users;
import com.tanmay.flightreservation.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Tanmay
 * @date 05/12/19
 **/

@Controller
public class UserController {

    @Autowired
    UserRepository userRepo;

    @RequestMapping("/showReg")
    public String showRegistrationPage() {
        return "login/registerUser";
    }

    @RequestMapping("/login")
    public String showLoginPage() {
        return "login/login";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@ModelAttribute Users user) {
        userRepo.save(user);
        return "login/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam("email") String email, @RequestParam("password") String password, ModelMap map) {
        Users user = userRepo.findByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            return "findFlights";
        } else {
            map.addAttribute("msg", "Credentials Incorrect");
            return "login/login";
        }

    }
}
