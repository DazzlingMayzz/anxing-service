package com.anxing.anxingservice.controller;

import com.anxing.anxingservice.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LocationController {
    @Autowired
    private LocationService locationService;

    @PutMapping("/frequency/{longitude}/{latitude}")
    public int getLocationFrequency(@PathVariable("longitude") String longitude,@PathVariable("latitude") String latitude) {
        return locationService.getFrequency(longitude, latitude);
    }

    @PutMapping("/location/{longitude}/{latitude}")
    public void updateLocationFrequency(@PathVariable("longitude") String longitude, @PathVariable("latitude") String latitude) {
        locationService.updateLocation(longitude, latitude);
    }
}
