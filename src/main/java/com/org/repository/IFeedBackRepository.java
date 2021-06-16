package com.org.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.entities.FeedBack;

/*
 * Feedback Repository
 */
public interface IFeedBackRepository extends JpaRepository<FeedBack, Integer>{

}
