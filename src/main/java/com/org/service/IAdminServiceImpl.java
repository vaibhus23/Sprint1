package com.org.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.org.entities.BusOperator;
import com.org.repository.IAdminRepository;

@Service
@Transactional
public class IAdminServiceImpl implements IAdminService {

	@Autowired
	private IAdminRepository adminRepository;
	
	/*
	 * Get All BusOperators 
	 */
	@Override
	public List<BusOperator> getAllBusOperators() {
		return adminRepository.findAll();
	}

	@Override
	public Double getRevenueByDate(LocalDate date) {
		return adminRepository.getRevenueByDate(date);
	}

	/*
	 * Get Revenue by bus RouteID
	 */
	@Override
	public Double getRevenueByBusRoute(int busrouteId) {
		return adminRepository.getRevenueByBusRoute(busrouteId);
	}

	/*
	 * Get Revenue by BusOperator UserName
	 */
	@Override
	public Double getRevenueByBusOperator(String operatorUserName) {
		return adminRepository.getRevenueByBusOperator(operatorUserName);
	}

}
