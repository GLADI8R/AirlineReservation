package com.example.AirlineReservation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.example.AirlineReservation.service"})
@SpringBootApplication
public class AirlineReservationApplication {

	public static void main(String[] args) {
		SpringApplication.run(AirlineReservationApplication.class, args);
	}

}
