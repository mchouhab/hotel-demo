package com.hotel.booking;

import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import org.springframework.context.annotation.Configuration;
import com.hotel.promo.Promo;
import com.hotel.room.Room;
import com.hotel.room.RoomType;

/**
 * @author mchouhab
 * 
 *         Book containing list of rooms and availability details
 * 
 */
@Configuration
public class ReservationBook {

	private HashMap<Calendar, LinkedList<Booking>> listOfBookingsByStartDate = new HashMap<Calendar, LinkedList<Booking>>();
	private HashMap<Calendar, LinkedList<Booking>> listOfBookingsByEndDate = new HashMap<Calendar, LinkedList<Booking>>();
	private LinkedList<Booking> bookings = new LinkedList<Booking>();
	private LinkedList<Promo> promos = new LinkedList<Promo>();
	private LinkedList<Room> rooms = new LinkedList<Room>();

	/**
	 * Start date to booking map
	 * 
	 * @param booking
	 */
	public void indexByStartDate(Booking booking) {
		// If date already exists in calendar then add booked room to list
		// Used for date based retrieval
		if (this.getlistOfBookingsByStartDate().containsKey(booking.getStart())) {
			this.getlistOfBookingsByStartDate().get(booking.getStart())
					.add(booking);
		} else {
			// Add new start date to calendar and create new rooms list
			LinkedList<Booking> bookings = new LinkedList<Booking>();
			bookings.add(booking);
			this.getlistOfBookingsByStartDate().put(booking.getStart(), bookings);
		}
	}
	
	/**
	 * End date to booking map
	 * 
	 * @param booking
	 */
	public void indexByEndDate(Booking booking) {
		// If date already exists in calendar then add booked room to list
		// Used for date based retrieval
		if (this.getlistOfBookingsByEndDate().containsKey(booking.getEnd())) {
			this.getlistOfBookingsByEndDate().get(booking.getEnd())
					.add(booking);
		} else {
			// Add new start date to calendar and create new rooms list
			LinkedList<Booking> bookings = new LinkedList<Booking>();
			bookings.add(booking);
			this.getlistOfBookingsByEndDate().put(booking.getEnd(), bookings);
		}
	}

	public void deleteBooking(Booking booking) {
		
		// Remove booking for list of booking
		this.getBookings().remove(booking.getId().intValue());

		// Remove booking from start date index
		this.getlistOfBookingsByStartDate().get(booking.getStart()).forEach(x -> {
			if (x.getId().intValue() == booking.getId().intValue())
				this.getlistOfBookingsByStartDate().get(booking.getStart())
						.remove(booking.getId().intValue());
		});
		
		// Remove booking from end date index
		this.getlistOfBookingsByEndDate().get(booking.getEnd()).forEach(x -> {
			if (x.getId().intValue() == booking.getId().intValue())
				this.getlistOfBookingsByEndDate().get(booking.getEnd())
						.remove(booking.getId().intValue());
		});

	}


	/**
	 * @return the promos
	 */
	public LinkedList<Promo> getPromos() {
		return promos;
	}

	/**
	 * @param promos
	 *            the promos to set
	 */
	public void setPromos(LinkedList<Promo> promos) {
		this.promos = promos;
	}

	/**
	 * @return the rooms
	 */
	public LinkedList<Room> getRooms() {
		return rooms;
	}

	/**
	 * @param rooms
	 *            the rooms to set
	 */
	public void setRooms(LinkedList<Room> rooms) {
		this.rooms = rooms;
	}

	/**
	 * @return the bookings
	 */
	public LinkedList<Booking> getBookings() {
		for (Booking booking : bookings){
			booking.setRoomType(this.rooms.get(booking.getRoomId()).getType());
		}
		return bookings;
	}

	/**
	 * @param bookings
	 *            the bookings to set
	 */
	public void setBookings(LinkedList<Booking> bookings) {
		this.bookings = bookings;
	}


	/**
	 * @return the listOfBookingsByEndDate
	 */
	public HashMap<Calendar, LinkedList<Booking>> getlistOfBookingsByEndDate() {
		return listOfBookingsByEndDate;
	}

	/**
	 * @param listOfBookingsByEndDate the listOfBookingsByEndDate to set
	 */
	public void setlistOfBookingsByEndDate(HashMap<Calendar, LinkedList<Booking>> listOfBookingsByEndDate) {
		this.listOfBookingsByEndDate = listOfBookingsByEndDate;
	}

	/**
	 * @return the listOfBookingsByStartDate
	 */
	public HashMap<Calendar, LinkedList<Booking>> getlistOfBookingsByStartDate() {
		return listOfBookingsByStartDate;
	}

	/**
	 * @param listOfBookingsByStartDate the listOfBookingsByStartDate to set
	 */
	public void setlistOfBookingsByStartDate(HashMap<Calendar, LinkedList<Booking>> listOfBookingsByStartDate) {
		this.listOfBookingsByStartDate = listOfBookingsByStartDate;
	}

}
