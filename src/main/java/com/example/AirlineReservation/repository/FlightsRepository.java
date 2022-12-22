package com.example.AirlineReservation.repository;


import com.example.AirlineReservation.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightsRepository extends JpaRepository<Flight, Integer> {

    @Query(value="SELECT f.flight_id, f.route_id, f.aircraft_id, f.dept_time, f.arr_time, f.fare, f.dept_date, f.seats_left, r.dept_code, r.arr_code FROM flight f INNER JOIN route r ON f.route_id=r.route_id", nativeQuery=true)
    List<Flight> getAllFlights();

    //Search Flights Query

}
