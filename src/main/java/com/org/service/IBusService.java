package com.org.service;

import com.org.entities.Bus;
import com.org.exceptions.InvalidBusIdException;

public interface IBusService {
	public Bus addBus(Bus bus);

	public Bus updateBus(Bus bus);

	public Bus getBusDetailsById(int busId) throws InvalidBusIdException;

	public void deleteBusIdById(int busId);
}
