package com.org.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.entities.Passenger;
/*
 * Passenger Repository
 */
public interface IPassengerRepository extends JpaRepository<Passenger, Integer> {

}
