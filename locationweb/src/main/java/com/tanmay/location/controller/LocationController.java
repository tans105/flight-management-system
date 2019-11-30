package com.tanmay.location.controller;

import com.tanmay.location.entities.Location;
import com.tanmay.location.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Tanmay
 * @date 30/11/19
 **/

@Controller
public class LocationController {

    @Autowired
    LocationService srvc;

    @RequestMapping("/showCreate")
    public String showCreate() {
        return "createLocation";
    }

    @RequestMapping("/saveLoc")
    public String saveLocation(@ModelAttribute("location") Location location, ModelMap modelMap) {
        Location locationSaved = srvc.save(location);
        String msg = "Location saved successfully with id" + locationSaved.getId();
        modelMap.addAttribute("msg", msg);
        return "createLocation";
    }
}
