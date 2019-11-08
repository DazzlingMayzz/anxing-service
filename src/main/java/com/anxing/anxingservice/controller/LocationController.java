package com.anxing.anxingservice.controller;

import com.anxing.anxingservice.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LocationController {
    @Autowired
    private LocationService locationService;

    @GetMapping("/location")
    public List<Integer> getLocationFrequency(String[] longitude, String[] latitude) {
        return locationService.getFrequency(longitude, latitude);
    }

    @PutMapping("/location/{longitude}/{latitude}")
    public void updateLocationFrequency(@PathVariable("longitude") String longitude, @PathVariable("latitude") String latitude) {
        locationService.updateLocation(longitude, latitude);
    }
}
