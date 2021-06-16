package com.org.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.org.entities.Passenger;
import com.org.exceptions.InvalidPassengerIdException;
import com.org.repository.IPassengerRepository;

@Service
@Transactional
public class IPassengerServiceImpl implements IPassengerService {

	@Autowired
	private IPassengerRepository pasengerRepository;

	/*
	 * add passenger
	 */
	@Override
	public Passenger addPassenger(Passenger passenger) {
		return pasengerRepository.save(passenger);
	}

	/*
	 * Update Passenger
	 */
	@Override
	public Passenger updatePassenger(Passenger passenger) {

		return pasengerRepository.save(passenger);
	}

	/*
	 * Get Passenger Details By id
	 */
	@Override
	public Passenger getPassengerDetailsById(int passengerId) throws InvalidPassengerIdException {
		return pasengerRepository.findById(passengerId)
				.orElseThrow(() -> new InvalidPassengerIdException("Element no Found"));
	}

	/*
	 * Delete Passenger By Id
	 */
	@Override
	public void deletePassengerById(int passengerId) {
		pasengerRepository.deleteById(passengerId);
	}

}
