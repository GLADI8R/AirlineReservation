package com.example.AirlineReservation.controller;


import com.example.AirlineReservation.model.Flight;
import com.example.AirlineReservation.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/api")
@CrossOrigin
public class FlightsController {

    @Autowired
    private FlightService flightService;

    @GetMapping("/flights")
    public List<Flight> getFlights() {
        return flightService.getAllFlights();
    }
}
