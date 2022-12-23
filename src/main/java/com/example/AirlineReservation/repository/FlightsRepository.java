package com.example.AirlineReservation.repository;


import com.example.AirlineReservation.model.Airport;
import com.example.AirlineReservation.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

@Repository
public interface FlightsRepository extends JpaRepository<Flight, Integer> {

    @Query(value="SELECT f.flight_id, f.route_id, f.aircraft_id, f.dept_time, f.arr_time, f.fare, f.dept_date, f.seats_left, r.dept_code, r.arr_code FROM flight f INNER JOIN route r ON f.route_id=r.route_id", nativeQuery=true)
    List<Flight> getAllFlights();

    //Search Flights Query
    @Query(value = "SELECT DISTINCT f.flight_id, f.fare, f.dept_date, r.dept_code, r.arr_code, f.dept_time, f.arr_time, a1.city as dept_city, a1.name as dept_name, a2.city as arr_city, a2.name as arr_name FROM route r INNER JOIN flight f ON f.route_id=r.route_id INNER JOIN airport a1 ON r.dept_code=a1.code_id INNER JOIN airport a2 ON r.arr_code=a2.code_id WHERE f.dept_date=:#{#date} AND a1.city=:#{#a1} AND a2.city=:#{#a2} AND f.seats_left>=0", nativeQuery = true)
    List<Flight> searchFlights(@Param("date") LocalDate date, @Param("a1") String a1, @Param("a2") String a2);

    // Get seats Query
    @Query(value = "SELECT seat_no FROM ticket t WHERE flight_id=:#{#flight.flight_id}", nativeQuery = true)
    List<Integer> getFlightSeats(@Param("flight") Flight flight);

}
