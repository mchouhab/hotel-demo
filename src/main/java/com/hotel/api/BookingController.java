package com.hotel.api;

import java.util.HashMap;
import java.util.LinkedList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.hotel.booking.Booking;
import com.hotel.booking.ReservationBook;
import com.hotel.room.Room;

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
	 */
	@GetMapping()
	public ResponseEntity<HashMap<Integer, LinkedList<Booking>>> getListOfBookings() {
		return new ResponseEntity<>(reservationBook.getListOfBookingsByRoomId(), HttpStatus.OK);
	}

	/**
	 * Create a new reservation with a new id, idempotent: no
	 * 
	 * @param request
	 * @param promo
	 */
	@PostMapping(consumes = "application/json")
	public ResponseEntity<HttpStatus> addReservation(@RequestBody Booking booking) {

		try {
			// If date already exists in calendar then add booked room to list
			// Used for date based retrieval
			if (reservationBook.getListOfBookingsByDate().containsKey(booking.getReservationStartDate())) {
				reservationBook.getListOfBookingsByDate().get(booking.getReservationStartDate())
						.add(reservationBook.getRooms().get(booking.getRoomId()));
			} else {
				// Add new start date to calendar and create new rooms list
				LinkedList<Room> rooms = new LinkedList<Room>();
				rooms.add(reservationBook.getRooms().get(booking.getRoomId()));
				reservationBook.getListOfBookingsByDate().put(booking.getReservationStartDate(), rooms);
			}

			// If room already exists then add booking to list of room bookings
			if (reservationBook.getListOfBookingsByRoomId().containsKey(booking.getRoomId())) {
				reservationBook.getListOfBookingsByRoomId().get(reservationBook.getRooms().get(booking.getRoomId()))
						.add(booking);
			} else {
				LinkedList<Booking> bookings = new LinkedList<Booking>();
				bookings.add(booking);
				reservationBook.getListOfBookingsByRoomId().put(booking.getRoomId(), bookings);
			}
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (IndexOutOfBoundsException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
