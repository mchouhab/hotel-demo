package com.hotel.booking;

import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import org.springframework.context.annotation.Configuration;
import com.hotel.promo.Promo;
import com.hotel.room.Room;

/**
 * @author mchouhab
 * 
 *         Book containing list of rooms and availability details
 * 
 */
@Configuration
public class ReservationBook {

	HashMap<Room, List<Booking>> listOfBookings;
	LinkedList<Promo> promos = new LinkedList<Promo>();
	LinkedList<Room> rooms = new LinkedList<Room>();

	/**
	 * Check room availability for a given range
	 * 
	 * @param start
	 * @param end
	 */
	public void isRoomAvailableForTime(Calendar start, Calendar end) {

	}

	/**
	 * Apply offer to all time the room is available
	 * 
	 * @param promo
	 * @param room
	 * @return
	 */
	public boolean ApplyPromo(Promo promo, Room... room) {
		return false;

	}

	/**
	 * Apply promo for a certain period of time
	 * 
	 * @param promo
	 * @param start
	 * @param end
	 * @param room
	 * @return
	 */
	public boolean ApplyPromoForTime(Promo promo, Calendar start, Calendar end, Room... room) {
		return false;

	}

	/**
	 * Book room for a certain date range
	 * 
	 * @param start
	 * @param end
	 * @return true is successful, false if unsuccessful
	 */
	public boolean bookRoomForTime(Calendar start, Calendar end) {
		return false;
	}

	public boolean addPromo(Promo promo) {
		return this.promos.add(promo);
	}

	/**
	 * @return the listOfBookings
	 */
	public HashMap<Room, List<Booking>> getListOfBookings() {
		return listOfBookings;
	}

	/**
	 * @param listOfBookings
	 *            the listOfBookings to set
	 */
	public void setListOfBookings(HashMap<Room, List<Booking>> listOfBookings) {
		this.listOfBookings = listOfBookings;
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

}
