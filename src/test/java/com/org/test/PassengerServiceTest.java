package com.org.test;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.org.entities.Passenger;
import com.org.repository.IPassengerRepository;
import com.org.service.IPassengerServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
class PassengerServiceTest {

	@Autowired
	IPassengerServiceImpl passengerService;

	@MockBean
	IPassengerRepository passengerRepository;

	/*
	 * Validation of addPassenger method
	 */
	@Test
	public void addPassengerValidTest() {
		Passenger passenger = new Passenger();
		passenger.setPassengerId(1);
		Mockito.when(passengerRepository.save(passenger)).thenReturn(passenger);
		Assertions.assertThat(passengerService.addPassenger(passenger)).isEqualTo(passenger);
	}

	/*
	 * Validation of getPassengerDetailsById method
	 */
	@Test
	public void getPassengerDetailsByIdValidTest() {
		Passenger passenger = new Passenger();
		passenger.setPassengerId(1);
		Mockito.when(passengerRepository.findById(1)).thenReturn(Optional.of(passenger));
		try {
			Assertions.assertThat(passengerService.getPassengerDetailsById(1)).isEqualTo(passenger);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * Validation of updatePassenger method
	 */
	@Test
	public void updatePassengerValidTest() {
		Passenger passenger = new Passenger();
		passenger.setPassengerId(1);
		Mockito.when(passengerRepository.findById(1)).thenReturn(Optional.of(passenger));
		Mockito.when(passengerRepository.save(passenger)).thenReturn(passenger);
		Assertions.assertThat(passengerService.updatePassenger(passenger)).isEqualTo(passenger);
	}

	/*
	 * Validation of deletePassengerById method
	 */
	@Test
	public void deletePassengerByIdValidTest() {
		Passenger passenger = new Passenger();
		passenger.setPassengerId(1);
		Mockito.when(passengerRepository.findById(1)).thenReturn(Optional.of(passenger));
		passengerService.deletePassengerById(passenger.getPassengerId());

	}

}
