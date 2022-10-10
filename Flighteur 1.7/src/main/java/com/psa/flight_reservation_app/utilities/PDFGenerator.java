package com.psa.flight_reservation_app.utilities;

import java.io.FileOutputStream;

import org.springframework.stereotype.Component;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.psa.flight_reservation_app.entity.Reservation;

@Component
public class PDFGenerator {

	public void generateItinerary(Reservation reservation, String filePath) {
		Document document = new Document();
		try {

			PdfWriter.getInstance(document, new FileOutputStream(filePath));
			document.open();
			document.add(generateTable(reservation));
			document.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private PdfPTable generateTable(Reservation reservation) {
		PdfPTable table = new PdfPTable(1);
		PdfPCell cell;

		cell = new PdfPCell(new Phrase("Flight Itinerary"));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("Flight Details"));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("Departure City: " + reservation.getFlight().getDepartureCity()));
		cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("Arrival City: " + reservation.getFlight().getArrivalCity()));
		cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("Flight Number: " + reservation.getFlight().getFlightNumber()));
		cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("Operating Airline: " + reservation.getFlight().getOperatingAirlines()));
		cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("Departure Date: " + reservation.getFlight().getDateOfDeparture().toString()));
		cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		table.addCell(cell);

		cell = new PdfPCell(
				new Phrase("Departure Time: " + reservation.getFlight().getEstimatedDepartureTime().toString()));
		cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("Passenger Details"));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("First Name: " + reservation.getPassenger().getFirstName()));
		cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("Last Name: " + reservation.getPassenger().getLastName()));
		cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("Email: " + reservation.getPassenger().getEmail()));
		cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("Phone: " + reservation.getPassenger().getPhone()));
		cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		table.addCell(cell);

		return table;
	}

}
