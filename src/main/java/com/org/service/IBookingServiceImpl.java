package com.org.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.org.entities.Booking;
import com.org.exceptions.InvalidBookingIdException;
import com.org.repository.IBookingRepository;

@Service
@Transactional
public class IBookingServiceImpl implements IBookingService {

	@Autowired
	private IBookingRepository bookingRepository;

	/*
	 * add booking
	 */
	@Override
	public Booking addBooking(Booking booking) {

		return bookingRepository.save(booking);
	}

	/*
	 * get booking details
	 */
	@Override
	public Booking getBookingDetailsById(int bookingId) throws InvalidBookingIdException {

		return bookingRepository.findById(bookingId).orElseThrow(() -> new InvalidBookingIdException("Element not found"));
	}

	/*
	 * update booking
	 */
	@Override
	public Booking updateBooking(Booking booking) throws InvalidBookingIdException {
		Optional<Booking> findBookingById = bookingRepository.findById(booking.getBookingId());
		if (findBookingById.isPresent()) {
			bookingRepository.save(booking);
		} else
			throw new InvalidBookingIdException("Booking with Booking Id: " + booking.getBookingId() + " not exists!!");
		return booking;
	}

	/*
	 * delete Booking
	 */
	@Override
	public String deleteBooking(int bookingId) throws InvalidBookingIdException {
		Optional<Booking> findBookingById = bookingRepository.findById(bookingId);
		if (findBookingById.isPresent()) {
			bookingRepository.deleteById(bookingId);
			return "Booking Deleted!!";
		} else
			throw new InvalidBookingIdException("Booking not found for the entered BookingID");
	}

	/*
	 * get all booking by userName
	 */
	@Override
	public List<Booking> getAllBookingsByUserName(String userName) {
		return bookingRepository.getAllBookingsByUserName(userName);
	}

	/*
	 * get all booking by date
	 */
	@Override
	public List<Booking> getAllBookingByDate(LocalDate date) {
		return bookingRepository.getAllBookingByDate(date);
	}

	/*
	 * get all booking by bus number
	 */
	@Override
	public List<Booking> getAllBookingByBusNumber(String busNumber) {
		// TODO Auto-generated method stub
		return bookingRepository.getAllBookingByBusNumber(busNumber);
	}
}
