package com.org.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.org.entities.FeedBack;
import com.org.exceptions.InvalidFeedBackIdException;
import com.org.repository.IFeedBackRepository;

@Service
@Transactional
public class IFeedbackServiceImpl implements IFeedBackService {
	@Autowired
	private IFeedBackRepository feedBackRepository;

	/*
	 * Add Feedback
	 */
	@Override
	public FeedBack addFeedBack(FeedBack feedBack) {
		// TODO Auto-generated method stub
		return feedBackRepository.save(feedBack);
	}

	/*
	 * Update Feedback
	 */
	@Override
	public FeedBack updateFeedBack(FeedBack feedBack) {
		// TODO Auto-generated method stub
		return feedBackRepository.save(feedBack);
	}

	/*
	 * Get Feedback
	 */
	@Override
	public FeedBack getFeedBackDetailsById(int feedBackId) throws InvalidFeedBackIdException {
		// TODO Auto-generated method stub
		return feedBackRepository.findById(feedBackId)
				.orElseThrow(() -> new InvalidFeedBackIdException("Element no Found"));
	}

	/*
	 * Delete Feedback
	 */
	@Override
	public void deleteFeedBackById(int feedBackId) {
		// TODO Auto-generated method stub
		feedBackRepository.deleteById(feedBackId);
	}

}
