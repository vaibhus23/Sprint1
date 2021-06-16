package com.org.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.org.entities.BusOperator;
import com.org.exceptions.InvalidUsernameException;

/*
 * BusOperator repository
 */
public interface IBusOperatorRepository extends JpaRepository<BusOperator, String> {

	@Modifying
	@Query(value = "update BusOperator b set b.password=:password where b.busOperatorUserName=:username")
	public int updatePassoword(@Param("username") String userName, @Param("password") String newPassword)
			throws InvalidUsernameException;

	@Query(value = "select sum(fare*numberofseats) from bus,booking where busrouteid=?1", nativeQuery = true)
	public Double getRevenueByBusRoute(int busrouteId);

	@Query(value = "select sum(fare*numberofseats) from bus,booking where bookingdate=?2 and busrouteid=?1", nativeQuery = true)
	public Double getRevenueByBusRouteIdAndDate(int busrouteId, LocalDate date);

	@Query(value = "Select sum(fare*numberofseats) from bus,booking WHERE EXTRACT(month from TO_DATE(BOOKINGDATE,'DD-MM-YYYY'))=?2 and busrouteid=?1", nativeQuery = true)
	public Double getMonthlyRevenueByBusRoute(int busrouteId, int month);

	@Query(value = "Select sum(fare*numberofseats) from bus,booking WHERE EXTRACT(Year from TO_DATE(BOOKINGDATE,'DD-MM-YYYY'))=?2 and busrouteid=?1", nativeQuery = true)
	public Double getYearlyRevenueByBusRoute(int busrouteId, int year);

}
