package com.org.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.org.entities.Bus;
import com.org.exceptions.InvalidBusIdException;
import com.org.repository.IBusRepository;

@Service
@Transactional
public class IBusServiceImpl implements IBusService {
	@Autowired
	private IBusRepository busRepository;

	/*
	 * add Bus
	 */
	@Override
	public Bus addBus(Bus bus) {
		// TODO Auto-generated method stub
		return busRepository.save(bus);
	}

	/*
	 * Update Bus
	 */
	@Override
	public Bus updateBus(Bus bus) {
		// TODO Auto-generated method stub
		return busRepository.save(bus);
	}

	/*
	 * Get Bus Details by Bus ID
	 */
	@Override
	public Bus getBusDetailsById(int busId) throws InvalidBusIdException {
		// TODO Auto-generated method stub
		return busRepository.findById(busId).orElseThrow(() -> new InvalidBusIdException("Element no Found"));
	}

	/*
	 * Delete Bus by Bus ID
	 */
	@Override
	public void deleteBusIdById(int busId) {
		// TODO Auto-generated method stub
		busRepository.deleteById(busId);
	}

}
