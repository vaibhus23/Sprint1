package com.org.controller;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.org.entities.BusOperator;
import com.org.service.IAdminServiceImpl;

@RestController
@RequestMapping("/Admin")
public class AdminController {

	@Autowired
	IAdminServiceImpl adminService;
	
	/*
	 * Get All Bus Operator
	 */
	@GetMapping("/findAllBusOperator")
	public List<BusOperator> getAllBusOperators() {
		return adminService.getAllBusOperators();
	}
	
	/*
	 * Get Revenue by Bus Route ID and Date
	 */
	@GetMapping("/revenueByRouteIdandDate/{date}")
	public Double getRevenueByBusRouteAndDate(
			@RequestParam("start") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
		return adminService.getRevenueByDate(date);
	}

	/*
	 * Get Revenue by BusOperator UserName
	 */
	@GetMapping("/revenueByRouteId/{operatorUserName}")
	public Double getRevenueByBusRoute(String operatorUserName) {
		return adminService.getRevenueByBusOperator(operatorUserName);

	}

}
