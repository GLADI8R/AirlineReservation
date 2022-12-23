package com.example.AirlineReservation.controller;


import com.example.AirlineReservation.model.Flight;
import com.example.AirlineReservation.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api")
@CrossOrigin
public class FlightsController {

    @Autowired
    private FlightService flightService;

    @GetMapping("/allFlights")
    public List<Flight> getFlights() {
        return flightService.getAllFlights();
    }

    @GetMapping("/flightSeats/{id}")
    public List<Integer> flightSeats(@PathVariable int id) {
        List<Flight> allFlights = flightService.getAllFlights();
        Flight flight = null;

        for(Flight f : allFlights) {
            if(f.getFlight_id() == id) {
                flight = f;
                break;
            }
        }

        return flightService.getFlightSeats(flight);
    }
}
