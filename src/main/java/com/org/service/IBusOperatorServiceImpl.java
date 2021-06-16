package com.org.service;

import java.time.LocalDate;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.entities.BusOperator;
import com.org.exceptions.InvalidUsernameException;
import com.org.repository.IBusOperatorRepository;

@Service
@Transactional
public class IBusOperatorServiceImpl implements IBusOperatorService {

	@Autowired
	IBusOperatorRepository busOperatorRepository;

	/*
	 * Add BusOperator
	 */
	@Override
	public BusOperator addBusOperator(BusOperator busOperator) {
		return busOperatorRepository.save(busOperator);
	}

	/*
	 * Update BusOperator
	 */
	@Override
	public BusOperator updateBusOperatorDetails(BusOperator busOperator) {
		return busOperatorRepository.save(busOperator);
	}

	/*
	 * Get BusOperator details by BusoperatorUsername
	 */

	@Override
	public BusOperator getBusOperatorDetails(String busOperatorUserName) throws InvalidUsernameException {
		return busOperatorRepository.findById(busOperatorUserName)
				.orElseThrow(() -> new InvalidUsernameException("UserName not Found"));
	}

	/*
	 * Delete BusOperator details by BusOperatorUserName
	 */
	@Override
	public void deleteBusOperatorByUserName(String busOperatorUserName) {
		busOperatorRepository.deleteById(busOperatorUserName);
	}

	/*
	 * Update BusOperator password by BusOperatorUserName
	 */
	@Override
	public int updatePassoword(String userName, String newPassword) throws InvalidUsernameException {
		Optional<BusOperator> findBusOperatorByUserName = busOperatorRepository.findById(userName);
		if (findBusOperatorByUserName.isPresent()) {
			return busOperatorRepository.updatePassoword(userName, newPassword);
		} else
			throw new InvalidUsernameException("BusOperator username not exists!!");
	}

	/*
	 * Get Revenue by BusRoute using BusRoute Id
	 */
	@Override
	public Double getRevenueByBusRoute(int busrouteId) {
		return busOperatorRepository.getRevenueByBusRoute(busrouteId);
	}
	
	/*
	 * Get Revenue by BusRoute using BusRoute Id
	 */
	@Override
	public Double getRevenueByBusRouteAndDate(int busrouteId, LocalDate date) {
		return busOperatorRepository.getRevenueByBusRouteIdAndDate(busrouteId, date);
	}
	
	/*
	 * Get Revenue by BusRoute using BusRoute Id and month
	 */
	@Override
	public Double getMonthlyRevenueByBusRoute(int busrouteId, int month) {
		return busOperatorRepository.getMonthlyRevenueByBusRoute(busrouteId, month);
	}
	
	/*
	 * Get Revenue by BusRoute using BusRoute Id and year
	 */
	@Override
	public Double getYearlyRevenueByBusRoute(int busrouteId, int year) {
		return busOperatorRepository.getYearlyRevenueByBusRoute(busrouteId, year);
	}
}
