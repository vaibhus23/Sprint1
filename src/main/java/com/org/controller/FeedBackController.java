package com.org.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.entities.FeedBack;
import com.org.exceptions.InvalidFeedBackIdException;
import com.org.service.IFeedbackServiceImpl;

@RestController
@RequestMapping("/feedback")
public class FeedBackController {
	@Autowired
	IFeedbackServiceImpl feedbackService;

	/*
	 * Add Feedback
	 */
	@PostMapping("/add")
	public ResponseEntity<FeedBack> insertFeedBack(@RequestBody FeedBack feedback) {
		feedback = feedbackService.addFeedBack(feedback);
		return new ResponseEntity<FeedBack>(feedback, HttpStatus.OK);
	}

	/*
	 * Get Feedback
	 */
	@GetMapping("/{id}")
	public ResponseEntity<FeedBack> getFeedBackDetailsById(@PathVariable int id) throws InvalidFeedBackIdException {
		FeedBack feedback = feedbackService.getFeedBackDetailsById(id);
		return new ResponseEntity<FeedBack>(feedback, HttpStatus.OK);
	}

	/*
	 * Update feedback
	 */
	@PutMapping("/update")
	public ResponseEntity<FeedBack> updateFeedBack(@RequestBody FeedBack feedback) {
		feedback = feedbackService.updateFeedBack(feedback);
		return new ResponseEntity<FeedBack>(feedback, HttpStatus.OK);
	}

	/*
	 * Delete feedback
	 */
	@DeleteMapping("/deletefeedback/{id}")
	public void deleteFeedBackByID(@PathVariable("id") int feedbackId) {
		feedbackService.deleteFeedBackById(feedbackId);
	}

}
