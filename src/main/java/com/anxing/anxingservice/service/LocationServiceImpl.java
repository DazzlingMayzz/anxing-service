package com.anxing.anxingservice.service;

import com.anxing.anxingservice.model.Location;
import com.anxing.anxingservice.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    private LocationRepository locationRepository;

    @Override
    public int getFrequency(String longitude, String latitude) {
        if (locationRepository.findByLatitudeAndLongitude(longitude, latitude)!=null){
            Location location = locationRepository.findByLatitudeAndLongitude(longitude, latitude);
            return location.getFrequency();
        }else{
            Location newLocation = createLocation(longitude, latitude);
            return newLocation.getFrequency();
        }
    }

    @Override
    public Location createLocation(String longitude, String latitude) {
        Location location = new Location();
        location.setLongitude(longitude);
        location.setLatitude(latitude);
        return locationRepository.save(location);
    }

    @Override
    public Location updateLocation(String longitude, String latitude) {
        int id = locationRepository.findByLatitudeAndLongitude(longitude, latitude).getId();
        // System.out.println(id);
        Optional<Location> location = locationRepository.findById(id);
        Location newLocation = new Location();
        location.ifPresent(value -> {
            newLocation.setFrequency(value.getFrequency() + 1);
            newLocation.setLongitude(value.getLongitude());
            newLocation.setLatitude(value.getLatitude());
            newLocation.setId(value.getId());
        });
        // System.out.println(newLocation);
        return locationRepository.save(newLocation);
    }
}
