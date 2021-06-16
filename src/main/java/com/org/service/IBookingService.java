package com.org.service;

import java.time.LocalDate;
import java.util.List;

import com.org.entities.Booking;
import com.org.exceptions.InvalidBookingIdException;

public interface IBookingService {

	public Booking addBooking(Booking booking);

	public Booking updateBooking(Booking booking) throws InvalidBookingIdException;

	public String deleteBooking(int bookingId) throws InvalidBookingIdException;

	public Booking getBookingDetailsById(int bookingId) throws InvalidBookingIdException;

	public List<Booking> getAllBookingsByUserName(String userName);

	public List<Booking> getAllBookingByDate(LocalDate date);

	public List<Booking> getAllBookingByBusNumber(String busNumber);

}
