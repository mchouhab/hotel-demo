package com.hotel.api;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.hotel.booking.Booking;
import com.hotel.booking.ReservationBook;

/**
 * @author mchouhab
 *
 *         API to manage reservations
 */
@RestController
@RequestMapping("/reservations")
public class BookingController {

	@Autowired
	ReservationBook reservationBook;

	/**
	 * Return list of bookings per room
	 * 
	 * @return
	 * @throws ParseException
	 */
	// http://localhost:9090/reservations?roomId=2&roomType=DoubleRoom&start=2018-08-01&end=2019-08-10
	@GetMapping()
	public ResponseEntity<LinkedList<Booking>> getListOfBookings(@RequestParam(required = false) Integer roomId,
			@RequestParam(required = false) String roomType, @RequestParam(required = false) String start,
			@RequestParam(required = false) String end) {

		if (roomId == null && roomType == null && start == null && end == null) {
			return new ResponseEntity<>(reservationBook.getBookings(), HttpStatus.OK);
		} else {
			LinkedList<Booking> list = new LinkedList<Booking>();
			for (Booking booking : reservationBook.getBookings())
				list.add(booking);

			// Filter for the date range
			if (start != null && end != null) {

				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Calendar startCl = new GregorianCalendar();
				try {
					startCl.setTime(sdf.parse(start));

					Calendar endCl = new GregorianCalendar();
					endCl.setTime(sdf.parse(end));
					sdf.setCalendar(endCl);

					startCl = this.setTime(startCl);
					list = this.getListOfReservations(roomId, roomType, startCl, endCl);
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
			// Filter for roomId
			if (roomId != null) {
				for (Booking booking : list) {
					if (booking.getRoomId() != roomId)
						list.remove(booking);
				}
			}
			// Filter for roomType
			if (roomType != null) {
				for (Booking booking : list) {
					if (!(booking.getRoomType().name().equalsIgnoreCase(roomType.trim())))
						list.remove(booking);
				}
			}
			return new ResponseEntity<>(list, HttpStatus.OK);
		}
	}

	/**
	 * If start and end date values exist, then filter for all bookings within
	 * the date Four scenarios: Either booking starts and end within range Or
	 * booking starts before range and ends within range Or booking starts after
	 * range and ends after range Or booking starts and ends outside of time
	 * range
	 * 
	 * @param roomId
	 * @param roomType
	 * @param start
	 * @param end
	 * @return list of unique reservations
	 */
	public LinkedList<Booking> getListOfReservations(Integer roomId, String roomType, Calendar start,
			Calendar end) {

		Calendar startCl = new GregorianCalendar(start.get(Calendar.YEAR), start.get(Calendar.MONTH), start.get(Calendar.DATE));
		Calendar endCl = new GregorianCalendar(end.get(Calendar.YEAR), end.get(Calendar.MONTH), end.get(Calendar.DATE));
		
		LinkedList<Booking> list = new LinkedList<Booking>();

		// Booking starts after start of range
		while (startCl.before(endCl)) {
			if (reservationBook.getlistOfBookingsByStartDate().containsKey(startCl)
					&& reservationBook.getlistOfBookingsByStartDate().get(startCl) != null) {
				list.addAll(reservationBook.getlistOfBookingsByStartDate().get(startCl));
			}

			startCl.add(Calendar.DATE, 1);
		}

		// Booking starts before end of range
		while (endCl.after(startCl)) {
			if (reservationBook.getlistOfBookingsByEndDate().containsKey(endCl)
					&& reservationBook.getlistOfBookingsByEndDate().get(endCl) != null) {
				list.addAll(reservationBook.getlistOfBookingsByEndDate().get(endCl));
			}

			endCl.add(Calendar.DATE, -1);
		}

		// Booking starts and ends outside of time range
		for (Booking booking : reservationBook.getBookings()) {
			if (booking.getStart().before(startCl) && booking.getEnd().after(endCl))
				list.add(booking);
		}
		list = list.stream().distinct().collect(Collectors.toCollection(LinkedList::new));
		return list;

	}

	/**
	 * Remove time from date
	 * 
	 * @param cl
	 * @return
	 */
	public Calendar setTime(Calendar cl) {
		return new GregorianCalendar(cl.get(Calendar.YEAR), cl.get(Calendar.MONTH), cl.get(Calendar.DATE));
	}

	/**
	 * Create a new reservation with a new id, idempotent: no
	 * 
	 * @param booking
	 */
	@PostMapping(consumes = "application/json")
	public ResponseEntity<String> addReservation(@RequestBody Booking booking) {
		try {
			// Add booking to list
			int id = reservationBook.getBookings().size();
			booking.setId(id);

			
			Booking bk = new Booking(booking.getId(), booking.getRoomId(), booking.getStart(), booking.getEnd(),
					booking.getPriceUpgrades(), booking.getFeatureUpgrades());
			LinkedList<Booking> list = this.getListOfReservations(bk.getRoomId(), null, bk.getStart(), bk.getEnd());

			if (!(list.size() > 0)) {
				booking.setStart(this.setTime(booking.getStart()));
				booking.setEnd(this.setTime(booking.getEnd()));
				reservationBook.getBookings().add(id, booking);

				// Add booking to index
				reservationBook.indexByStartDate(booking);
				reservationBook.indexByEndDate(booking);

				return new ResponseEntity<>(HttpStatus.OK);
			} else {
				return ResponseEntity.status(HttpStatus.CONFLICT)
						.body("Reservation could not be added, room is booked during this date");
			}
		} catch (Exception e) {
			System.out.println(e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Reservation could not be added.");
		}
	}

	/**
	 * Delete a reservation from list of reservations
	 * 
	 * @param Id
	 * @return
	 */
	@RequestMapping(path = "/{Id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteReservation(@PathVariable("Id") Integer id) {
		try {
			reservationBook.deleteBooking(reservationBook.getBookings().get(id));
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Element with id " + id + " could not be not found or an error had prevented the reservation from being delete");
		}
	}

}
