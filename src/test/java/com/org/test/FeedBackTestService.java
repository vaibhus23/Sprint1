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

import com.org.entities.FeedBack;
import com.org.repository.IFeedBackRepository;
import com.org.service.IFeedbackServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
class FeedBackTestService {

	@Autowired
	IFeedbackServiceImpl feedBackService;

	@MockBean
	IFeedBackRepository feedBackRepository;

	/*
	 * Validation of addFeedBack method
	 */
	@Test
	public void addFeedBackValidTest() {
		FeedBack feedback = new FeedBack();
		feedback.setFeedbackId(1);
		Mockito.when(feedBackRepository.save(feedback)).thenReturn(feedback);
		Assertions.assertThat(feedBackService.addFeedBack(feedback)).isEqualTo(feedback);
	}

	/*
	 * Validation of getFeedBackDetailsById method
	 */
	@Test
	public void getFeedBackDetailsByIdValidTest() {
		FeedBack feedback = new FeedBack();
		feedback.setFeedbackId(1);
		Mockito.when(feedBackRepository.findById(1)).thenReturn(Optional.of(feedback));
		try {
			Assertions.assertThat(feedBackService.getFeedBackDetailsById(1)).isEqualTo(feedback);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * Validation of updateFeedBack method
	 */
	@Test
	public void updateFeedBackValidTest() {
		FeedBack feedback = new FeedBack();
		feedback.setFeedbackId(1);
		Mockito.when(feedBackRepository.findById(1)).thenReturn(Optional.of(feedback));
		Mockito.when(feedBackRepository.save(feedback)).thenReturn(feedback);
		Assertions.assertThat(feedBackService.updateFeedBack(feedback)).isEqualTo(feedback);
	}

	/*
	 * Validation of deletePassengerById method
	 */
	@Test
	public void deletePassengerByIdValidTest() {
		FeedBack feedback = new FeedBack();
		feedback.setFeedbackId(1);
		Mockito.when(feedBackRepository.findById(1)).thenReturn(Optional.of(feedback));
		feedBackService.deleteFeedBackById(feedback.getFeedbackId());

	}
}