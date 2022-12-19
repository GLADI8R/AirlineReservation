package com.example.AirlineReservation.controller;

import com.example.AirlineReservation.model.Airport;
import com.example.AirlineReservation.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/v1/api")
@CrossOrigin
public class AirportsController {

    @Autowired
    private AirportService airportService;

    @PostMapping("/add")
    public String add(@RequestBody Airport airport) {
        airportService.saveAirport(airport);
        return "New Airport added";
    }

    @GetMapping("/getAll")
    public List<Airport> list() {
        return airportService.getAllAirports();
    }

}
