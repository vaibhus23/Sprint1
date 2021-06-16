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

import com.org.entities.Bus;
import com.org.exceptions.InvalidBusIdException;
import com.org.service.IBusServiceImpl;
/*
 * Bus Controller
 */
@RestController
@RequestMapping("/bus")
public class IBusController {

	@Autowired
	IBusServiceImpl busService;
	
	/*
	 *Add Bus
	 */
	@PostMapping("/add")
	public ResponseEntity<Bus> insertBus(@RequestBody Bus bus) {
		bus = busService.addBus(bus);
		return new ResponseEntity<Bus>(bus, HttpStatus.OK);
	}

	/*
	 *Get Bus Details by ID
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Bus> getBusDetailsById(@PathVariable int id) throws InvalidBusIdException {
		Bus Bus = busService.getBusDetailsById(id);
		return new ResponseEntity<Bus>(Bus, HttpStatus.OK);
	}

	/*
	 *Update Bus
	 */
	@PutMapping("/update}")
	public ResponseEntity<Bus> updateBus(@RequestBody Bus bus) {
		bus = busService.updateBus(bus);
		return new ResponseEntity<Bus>(bus, HttpStatus.OK);
	}

	/*
	 *Delete Bus
	 */
	@DeleteMapping("/deleteBus/{id}")
	public void deleteBusByID(@PathVariable("id") int busId) {
		busService.deleteBusIdById(busId);
	}
}
