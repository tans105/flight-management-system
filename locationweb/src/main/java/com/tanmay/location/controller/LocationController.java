package com.tanmay.location.controller;

import com.tanmay.location.entities.Location;
import com.tanmay.location.repo.LocationRepository;
import com.tanmay.location.service.LocationService;
import com.tanmay.location.util.EmailUtil;
import com.tanmay.location.util.ReportUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletContext;
import java.util.List;

/**
 * @author Tanmay
 * @date 30/11/19
 **/

@Controller
public class LocationController {

    @Autowired
    LocationService srvc;

    @Autowired
    EmailUtil email;

    @Autowired
    ReportUtil reportUtil;

    @Autowired
    LocationRepository locationRepository;

    @Autowired
    ServletContext context;

    @RequestMapping("/showCreate")
    public String showCreate() {
        return "createLocation";
    }

    @RequestMapping("/saveLoc")
    public String saveLocation(@ModelAttribute("location") Location location, ModelMap modelMap) {
        Location locationSaved = srvc.save(location);
        String msg = "Location saved successfully with id" + locationSaved.getId();
        modelMap.addAttribute("msg", msg);
//        email.sendEmail("tanmayawasthi105@yahoo.com", "Location created!", "Location saved successfully " + locationSaved.getName());
        return "createLocation";
    }

    @RequestMapping("/displayLocations")
    public String displayLocations(ModelMap map) {
        List<Location> locations = srvc.getLocations();
        map.put("locations", locations);
        return "displayLocations";
    }

    @RequestMapping("/deleteLocation")
    public String deleteLocation(@RequestParam int id, ModelMap map) {
        Location loc = srvc.getLocationById(id);
        srvc.delete(loc);
        List<Location> locations = srvc.getLocations();
        map.put("locations", locations);
        return "displayLocations";
    }

    @RequestMapping("/updateLocation")
    public String showLocation(@RequestParam int id, ModelMap map) {
        Location loc = srvc.getLocationById(id);
        map.put("location", loc);
        return "editLocation";
    }

    @RequestMapping("/updateLoc")
    public String updateLocation(@ModelAttribute Location loc, ModelMap map) {
        srvc.update(loc);
        map.addAttribute("locations", srvc.getLocations());
        return "displayLocations";
    }

    @RequestMapping("/generateReport")
    public String generateReport() {
        List<Object[]> dataset = locationRepository.findTypeAndCount();
        reportUtil.generatePieChart(context.getRealPath("/"),dataset);
        return "report";
    }
}
