package com.org.controller;

import java.time.LocalDate;
import java.util.List;

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

import com.org.entities.Booking;
import com.org.exceptions.InvalidBookingIdException;
import com.org.service.IBookingServiceImpl;

/*
 * Booking Controller
 */
@RestController
@RequestMapping("/booking")
public class BookingController {

	@Autowired
	IBookingServiceImpl bookingService;

	/*
	 * add booking
	 */
	@PostMapping("/add")
	public ResponseEntity<Booking> insertBooking(@RequestBody Booking booking) {
		booking = bookingService.addBooking(booking);
		return new ResponseEntity<Booking>(booking, HttpStatus.OK);
	}

	/*
	 * get booking details by id
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Booking> getBookingDetailsById(@PathVariable int id) throws InvalidBookingIdException {
		Booking booking = bookingService.getBookingDetailsById(id);
		return new ResponseEntity<Booking>(booking, HttpStatus.OK);
	}

	/*
	 * update booking
	 */
	@PutMapping("/updateBooking")
	public void modifyBooking(@RequestBody Booking updateBooking) throws InvalidBookingIdException {
		bookingService.updateBooking(updateBooking);
	}

	/*
	 * Delete booking by id
	 */
	@DeleteMapping("/deleteBooking/{id}")
	public void deleteBookingByID(@PathVariable("id") int bookingId) throws InvalidBookingIdException {

		bookingService.deleteBooking(bookingId);
	}

	/*
	 * get booking by userName
	 */
	@GetMapping("/byUserName/{username}")
	public List<Booking> getBookingByUserName(@PathVariable String username) {
		return bookingService.getAllBookingsByUserName(username);
	}

	/*
	 * get booking by date
	 */
	@GetMapping("/byDate/{date}")
	public List<Booking> getBookingByDate(
			@RequestParam("start") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
		return bookingService.getAllBookingByDate(date);
	}

	/*
	 * get booking by bus number
	 */
	@GetMapping("/bybusNumber/{busNumber}")
	public List<Booking> getAllBookingByBusRoute(@PathVariable String busNumber) {
		return bookingService.getAllBookingByBusNumber(busNumber);

	}
}
