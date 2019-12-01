package com.tanmay.location.controller;

import com.tanmay.location.entities.Location;
import com.tanmay.location.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

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

    @RequestMapping("/displayLocations")
    public String displayLocations(ModelMap map) {
        List<Location> locations = srvc.getLocations();
        map.put("locations",locations);
        return "displayLocations";
    }

    @RequestMapping("/deleteLocation")
    public String deleteLocation(@RequestParam int id, ModelMap map) {
        Location loc = srvc.getLocationById(id);
        srvc.delete(loc);
        List<Location> locations = srvc.getLocations();
        map.put("locations",locations);
        return "displayLocations";
    }
}
