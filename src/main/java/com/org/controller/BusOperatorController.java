package com.org.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.org.entities.BusOperator;
import com.org.exceptions.InvalidUsernameException;
import com.org.service.IBusOperatorServiceImpl;

/*
 * Booking Controller
 */
@RestController
@RequestMapping("/BusOperator")
public class BusOperatorController {

	@Autowired
	IBusOperatorServiceImpl busOperatorService;
	
	/*
	 * add BusOperator
	 */
	@PostMapping("/add")
	public ResponseEntity<BusOperator> insertBusOperator(@RequestBody BusOperator busOperator) {
		busOperator = busOperatorService.addBusOperator(busOperator);
		return new ResponseEntity<BusOperator>(busOperator, HttpStatus.OK);
	}

	/*
	 * get BusOperator Details by userName 
	 */
	@GetMapping("/{busOperatorUsername}")
	public ResponseEntity<BusOperator> getBusOperatorDetailsByUserName(@PathVariable String busOperatorUsername)
			throws InvalidUsernameException {
		BusOperator busOperator = busOperatorService.getBusOperatorDetails(busOperatorUsername);
		return new ResponseEntity<BusOperator>(busOperator, HttpStatus.OK);
	}
	
	/*
	 * Update BusOperator
	 */
	@PutMapping("/update")
	public ResponseEntity<BusOperator> updateBusOperator(@RequestBody BusOperator busOperator) {
		busOperator = busOperatorService.updateBusOperatorDetails(busOperator);
		return new ResponseEntity<BusOperator>(busOperator, HttpStatus.OK);
	}
	
	/*
	 * Delete BusOperator
	 */
	@DeleteMapping("/deleteBusOperator/{busOperatorUsername}")
	public void deleteBusOperatorByUserName(@PathVariable("busOperatorUsername") String busOperatorUsername) {
		busOperatorService.deleteBusOperatorByUserName(busOperatorUsername);
	}

	/*
	 * Update BusOperator password using userName
	 */
	@PutMapping("/update/updatePassword/{username}/{newpassword}")
	public ResponseEntity<String> updatePassword(@PathVariable String username, @PathVariable String newpassword)
			throws InvalidUsernameException {
		int count = busOperatorService.updatePassoword(username, newpassword);
		if (count == 1) {
			return new ResponseEntity<String>("updated Password", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Not Updated", HttpStatus.OK);
		}
	}
	
	/*
	 * Get revenue by busrouteID 
	 */
	@GetMapping("/revenueByRouteId/{busrouteid}")
	public Double getRevenueByBusRouteId(int busrouteid) {
		return busOperatorService.getRevenueByBusRoute(busrouteid);

	}

	/*
	 * Get revenue by busrouteId and date 
	 */
	@GetMapping("/revenueByRouteIdandDate/{busrouteid}/{date}")
	public Double getRevenueByBusRouteAndDate(int busrouteid,
			@RequestParam("start") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
		return busOperatorService.getRevenueByBusRouteAndDate(busrouteid, date);
	}
	
	/*
	 * Get revenue monthly by busrouteId and month 
	 */
	@GetMapping("/monthlyRevenueByBusRoute/{busrouteid}/{month}")
	public Double getMonthlyRevenueByBusRouteID(@PathVariable int busrouteid, @PathVariable int month) {
		return busOperatorService.getMonthlyRevenueByBusRoute(busrouteid, month);
	}
	
	/*
	 * Get revenue Yearly by busrouteId and year 
	 */
	@GetMapping("/yearlyRevenueByBusRoute/{busrouteid}/{year}")
	public Double getYearlyRevenueByBusRouteID(@PathVariable int busrouteid, @PathVariable int year) {
		return busOperatorService.getYearlyRevenueByBusRoute(busrouteid, year);
	}

}
