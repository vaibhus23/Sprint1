package com.org.service;

import java.time.LocalDate;
import java.util.List;

import com.org.entities.BusOperator;

public interface IAdminService {

	public List<BusOperator> getAllBusOperators();

	public Double getRevenueByDate(LocalDate date);

	public Double getRevenueByBusRoute(int busrouteId);

	public Double getRevenueByBusOperator(String operatorUserName);

}
