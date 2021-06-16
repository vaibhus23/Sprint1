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

import com.org.entities.BusOperator;
import com.org.exceptions.InvalidUsernameException;
import com.org.repository.IBusOperatorRepository;
import com.org.service.IBusOperatorServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
class BusOperatorServiceTest {

	@Autowired
	private IBusOperatorServiceImpl busOperatorSerivce;

	@MockBean
	private IBusOperatorRepository busOperatorRepository;

	/*
	 * Validation of addBusOperator method
	 */
	@Test
	public void addBusOperatorValidTest() {
		BusOperator busOperator = new BusOperator();
		busOperator.setBusOperatorUserName("Vaibhav");
		busOperator.setPassword("Vaibhav");
		Mockito.when(busOperatorRepository.save(busOperator)).thenReturn(busOperator);
		Assertions.assertThat(busOperatorSerivce.addBusOperator(busOperator)).isEqualTo(busOperator);
	}

	/*
	 * Validation of updateBusOperatorDetails method
	 */
	@Test
	public void updateBusOperatorDetailsValidTest() {
		BusOperator busOperator = new BusOperator();
		busOperator.setBusOperatorUserName("Vaibhav");
		busOperator.setPassword("Vaibhav");
		Mockito.when(busOperatorRepository.save(busOperator)).thenReturn(busOperator);
		Assertions.assertThat(busOperatorSerivce.updateBusOperatorDetails(busOperator)).isEqualTo(busOperator);
	}

	/*
	 * Validation of getBusOperatorDetails method
	 */
	@Test
	public void getBusOperatorDetailsValidTest() {
		BusOperator busOperator = new BusOperator();
		busOperator.setBusOperatorUserName("Vaibhav");
		busOperator.setPassword("Vaibhav");
		Mockito.when(busOperatorRepository.findById("vaibhav")).thenReturn(Optional.of(busOperator));
		try {
			Assertions.assertThat(busOperatorSerivce.getBusOperatorDetails("vaibhav")).isEqualTo(busOperator);
		} catch (InvalidUsernameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * Validation of deleteBusOperatorByUserNam method
	 */
	@Test
	public void deleteBusOperatorByUserNameValidTest() {
		BusOperator busOperator = new BusOperator();
		busOperator.setBusOperatorUserName("Vaibhav");
		busOperator.setPassword("Vaibhav");
		busOperatorSerivce.deleteBusOperatorByUserName(busOperator.getBusOperatorUserName());
	}

}
