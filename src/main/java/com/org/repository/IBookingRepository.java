package com.org.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.org.entities.Booking;

/*
 * Booking repository
 */
@Repository
public interface IBookingRepository extends JpaRepository<Booking, Integer> {

	@Query(value = "Select * from Booking b where b.username= ?1", nativeQuery = true)
	public List<Booking> getAllBookingsByUserName(String userName);

	@Query(value = "Select * from Booking b where b.bookingdate= ?1", nativeQuery = true)
	public List<Booking> getAllBookingByDate(LocalDate date);

	@Query(value = "select * from booking where busnumber=?1", nativeQuery = true)
	public List<Booking> getAllBookingByBusNumber(String busNumber);
}
