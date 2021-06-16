package com.org.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.org.entities.BusOperator;

/*
 *  Admin Repository
 */
@Repository
public interface IAdminRepository extends JpaRepository<BusOperator, Integer> {
	@Query(value = "select bus_operator_username from busoperator where bus_operator_username in(select bus_operator_username from bus where busrouteid=?1)", nativeQuery = true)
	public List<BusOperator> getAllBusOperatorsByRoute(int busrouteId);

	@Query(value = "Select sum(fare*numberofseats) from bus,booking where bookingdate=?1", nativeQuery = true)
	public Double getRevenueByDate(LocalDate date);

	@Query(value = "select sum(fare*numberofseats) from bus,booking where busrouteid=?1", nativeQuery = true)
	public Double getRevenueByBusRoute(int busrouteId);

	@Query(value = "select sum(fare*numberofseats) from bus,booking where bus_operator_username=?1", nativeQuery = true)
	public Double getRevenueByBusOperator(String operatorUserName);

	@Query(value = "delete from bus where bus_operator_username =?1", nativeQuery = true)
	public void deleteBusByOperator(String busOperatorUserName);

}
