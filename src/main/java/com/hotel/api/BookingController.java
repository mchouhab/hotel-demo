package com.hotel.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mchouhab
 *
 *         API to manage reservations
 */
@RestController
public class BookingController {

	/**
	 * Return list of bookings
	 * 
	 * @return
	 */
	@RequestMapping("/")
	public String getListOfBookings() {
		return "test hotel reservation system";

	}

	/**
	 * Add a booking
	 */
	public void addReservation() {

	}

	/**
	 * Delete a booking
	 */
	public void deleteReservation() {

	}

	/**
	 * Modify a booking
	 */
	public void modifyReservation() {

	}

	// use a room type filter
	// use a feature filter
	/**
	 * Retrieve list of available rooms during a time period
	 */
	public void getListOfAvailableRooms() {

	}

	// use room filter type
	/**
	 * Retrieve list of booked rooms during a time period
	 */
	public void getListOfBookedRooms() {

	}

}
