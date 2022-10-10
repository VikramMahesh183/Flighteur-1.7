package com.psa.flight_reservation_app.entity;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Reservation extends AbstractEntity {
	private boolean checkedIn;
	private int numberOfBags;
	@OneToOne
	private Passenger passenger;// One to one mapping- creating a passenger reference variable, i.e, passenger
								// table is mapped with reservation table with one to one concept(1 passenger-1
								// reservation)
	@OneToOne
	private Flight flight;

	public boolean isCheckedIn() {
		return checkedIn;
	}

	public void setCheckedIn(boolean checkedIn) {
		this.checkedIn = checkedIn;
	}

	public int getNumberOfBags() {
		return numberOfBags;
	}

	public void setNumberOfBags(int numberOfBags) {
		this.numberOfBags = numberOfBags;
	}

	public Passenger getPassenger() {
		return passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

}
