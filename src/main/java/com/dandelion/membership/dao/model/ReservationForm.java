package com.dandelion.membership.dao.model;

import java.util.List;

public class ReservationForm {
	List<Reservation> reservations;

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	} 
}
