package com.org.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "busoperator")
public class BusOperator {

	@Id
	@Column(name = "busOperatorUsername")
	private String busOperatorUserName;

	@Column(name = "password", nullable = false)
	private String password;

	/*
	 * One to many relationship between BusOperator and bus
	 */
	@JoinColumn(name = "busOperatorUsername")
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Bus.class)
	private List<Bus> bus;

	public String getBusOperatorUserName() {
		return busOperatorUserName;
	}

	public void setBusOperatorUserName(String busOperatorUserName) {
		this.busOperatorUserName = busOperatorUserName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Bus> getBus() {
		return bus;
	}

	public void setBus(List<Bus> bus) {
		this.bus = bus;
	}

}
