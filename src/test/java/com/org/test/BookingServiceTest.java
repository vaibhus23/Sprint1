package com.org.test;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.org.entities.Booking;
import com.org.exceptions.InvalidBookingIdException;
import com.org.repository.IBookingRepository;
import com.org.service.IBookingServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
class BookingServiceTest {

	@Autowired
	private IBookingServiceImpl bookingService;

	@MockBean
	private IBookingRepository bookingRepository;

	/*
	 * Validation of addBooking method
	 */
	@Test
	private void addBookingValidTest() {
		Booking booking = new Booking();
		booking.setBookingId(1);
		Mockito.when(bookingRepository.save(booking)).thenReturn(booking);
		Assertions.assertThat(bookingService.addBooking(booking)).isEqualTo(booking);
	}

	/*
	 * Validation of getBookingDetails method
	 */
	@Test
	private void getBookingDetailsByIdValidTest() {
		Booking booking = new Booking();
		booking.setBookingId(1);
		Mockito.when(bookingRepository.findById(1)).thenReturn(Optional.of(booking));
		try {
			Assertions.assertThat(bookingService.getBookingDetailsById(1)).isEqualTo(booking);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * Validation of updateBooking method
	 */
	@Test
	public void updateBookingValidTest() {
		Booking booking = new Booking();
		booking.setBookingId(1);
		Mockito.when(bookingRepository.findById(1)).thenReturn(Optional.of(booking));
		Mockito.when(bookingRepository.save(booking)).thenReturn(booking);
		try {
			Assertions.assertThat(bookingService.updateBooking(booking)).isEqualTo(booking);
		} catch (InvalidBookingIdException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * Validation of deleteBooking method
	 */
	@Test
	public void deleteBookingValidTest() {
		Booking booking = new Booking();
		booking.setBookingId(1);
		Mockito.when(bookingRepository.findById(1)).thenReturn(Optional.of(booking));
		try {
			bookingService.deleteBooking(booking.getBookingId());
		} catch (InvalidBookingIdException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}