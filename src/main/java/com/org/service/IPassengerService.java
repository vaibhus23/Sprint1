package com.org.service;

import com.org.entities.Passenger;
import com.org.exceptions.InvalidPassengerIdException;

public interface IPassengerService {

	public Passenger addPassenger(Passenger passenger);

	public Passenger updatePassenger(Passenger passenger);

	public Passenger getPassengerDetailsById(int passengerId) throws InvalidPassengerIdException;

	public void deletePassengerById(int passengerId);
}
