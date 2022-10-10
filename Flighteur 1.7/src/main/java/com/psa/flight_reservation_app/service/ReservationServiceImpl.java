package com.psa.flight_reservation_app.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.psa.flight_reservation_app.dto.ReservationRequest;
import com.psa.flight_reservation_app.entity.Flight;
import com.psa.flight_reservation_app.entity.Passenger;
import com.psa.flight_reservation_app.entity.Reservation;
import com.psa.flight_reservation_app.repository.FlightRepository;
import com.psa.flight_reservation_app.repository.PassengerRepository;
import com.psa.flight_reservation_app.repository.ReservationRepository;
import com.psa.flight_reservation_app.utilities.EmailUtil;
import com.psa.flight_reservation_app.utilities.PDFGenerator;

@Service // serviceLayer
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	private EmailUtil emailUtil;

	@Autowired
	private PDFGenerator pdfGenerator;

	@Autowired
	private PassengerRepository passengerRepo;

	@Autowired
	private FlightRepository flightRepo;

	@Autowired
	private ReservationRepository reservationRepo;

	@Override
	public Reservation bookFlight(ReservationRequest request) {

		Passenger passenger = new Passenger();
		passenger.setFirstName(request.getFirstName());
		passenger.setLastName(request.getLastName());
		passenger.setMiddleName(request.getMiddleName());
		passenger.setEmail(request.getEmail());
		passenger.setPhone(request.getPhone());
		passengerRepo.save(passenger);

		long flightId = request.getFlightId();
		Optional<Flight> findById = flightRepo.findById(flightId);
		Flight flight = findById.get();

		Reservation reservation = new Reservation();
		reservation.setFlight(flight);
		reservation.setPassenger(passenger);
		reservation.setCheckedIn(false);
		reservation.setNumberOfBags(0);
		reservationRepo.save(reservation);
		String filePath = "F:\\STS workspace\\flight_reservation_app\\tickets\\reservation" + reservation.getId()
				+ ".pdf";
		pdfGenerator.generateItinerary(reservation, filePath);
		emailUtil.sendItinerary(passenger.getEmail(), filePath);
		return reservation;
	}

}
