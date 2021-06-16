package com.org.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.entities.Passenger;
import com.org.exceptions.InvalidPassengerIdException;
import com.org.service.IPassengerServiceImpl;

/*
 * Passenger Controller
 */
@RestController
@RequestMapping("/passenger")
public class PassengerController {

	@Autowired
	IPassengerServiceImpl passengerService;

	/*
	 * Add Passenger
	 */
	@PostMapping("/add")
	public ResponseEntity<Passenger> insertPassenger(@RequestBody Passenger passenger) {
		passenger = passengerService.addPassenger(passenger);
		return new ResponseEntity<Passenger>(passenger, HttpStatus.OK);
	}

	/*
	 * Get Details By passenger Id
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Passenger> getPassengerDetailsById(@PathVariable int id) throws InvalidPassengerIdException {
		Passenger passenger = passengerService.getPassengerDetailsById(id);
		return new ResponseEntity<Passenger>(passenger, HttpStatus.OK);
	}

	/*
	 * Update Passenger
	 */
	@PutMapping("/update")
	public ResponseEntity<Passenger> updatePassenger(@RequestBody Passenger passenger) {
		passenger = passengerService.updatePassenger(passenger);
		return new ResponseEntity<Passenger>(passenger, HttpStatus.OK);
	}

	/*
	 * Delete Passenger
	 */
	@DeleteMapping("/deletepassenger/{id}")
	public void deletePassengerByID(@PathVariable("id") int passengerId) {
		passengerService.deletePassengerById(passengerId);
	}

}
