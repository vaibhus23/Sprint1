package com.org.service;

import java.time.LocalDate;

import com.org.entities.BusOperator;
import com.org.exceptions.InvalidBusRouteIDException;
import com.org.exceptions.InvalidUsernameException;

public interface IBusOperatorService {

	public BusOperator addBusOperator(BusOperator busOperator);

	public BusOperator updateBusOperatorDetails(BusOperator busOperator);

	public BusOperator getBusOperatorDetails(String busOperatorUserName) throws InvalidUsernameException;

	public void deleteBusOperatorByUserName(String busOperatorUserName);

	public int updatePassoword(String userName, String newPassword) throws InvalidUsernameException;

	public Double getRevenueByBusRoute(int busrouteId) throws InvalidBusRouteIDException;
	
	public Double getRevenueByBusRouteAndDate(int busrouteId, LocalDate date);
	
	public Double getMonthlyRevenueByBusRoute(int busrouteId,int month);
	
	public Double getYearlyRevenueByBusRoute(int busrouteId,int year);
}
