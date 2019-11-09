package com.anxing.anxingservice.service;

import com.anxing.anxingservice.model.Location;

import java.util.List;

public interface LocationService {
    int getFrequency(String longitude, String latitude);

    Location createLocation(String longitude, String latitude);

    Location updateLocation(String longitude, String latitude);
}
