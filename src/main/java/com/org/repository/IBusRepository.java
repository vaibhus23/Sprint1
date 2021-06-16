package com.org.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.entities.Bus;
/*
 * Bus Repository
 */
public interface IBusRepository extends JpaRepository<Bus, Integer>{

}
