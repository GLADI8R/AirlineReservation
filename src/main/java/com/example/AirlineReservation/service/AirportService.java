package com.example.AirlineReservation.service;

import com.example.AirlineReservation.model.Airport;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AirportService {
    public Airport saveAirport(Airport airport);
    public List<Airport> getAllAirports();
}
