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

	private HashMap<Integer, LinkedList<Booking>> listOfBookingsByRoomId = new HashMap<Integer, LinkedList<Booking>>();
	private HashMap<Calendar, LinkedList<Room>> listOfBookingsByDate = new HashMap<Calendar, LinkedList<Room>>();
	private LinkedList<Promo> promos = new LinkedList<Promo>();
	private LinkedList<Room> rooms = new LinkedList<Room>();

	/**
	 * @return the listOfBookingsByRoomId
	 */
	public HashMap<Integer, LinkedList<Booking>> getListOfBookingsByRoomId() {
		return listOfBookingsByRoomId;
	}

	/**
	 * @param listOfBookingsByRoomId
	 *            the listOfBookingsByRoomId to set
	 */
	public void setListOfBookingsByRoomId(HashMap<Integer, LinkedList<Booking>> listOfBookingsByRoomId) {
		this.listOfBookingsByRoomId = listOfBookingsByRoomId;
	}

	/**
	 * @return the listOfBookingsByDate
	 */
	public HashMap<Calendar, LinkedList<Room>> getListOfBookingsByDate() {
		return listOfBookingsByDate;
	}

	/**
	 * @param listOfBookingsByDate
	 *            the listOfBookingsByDate to set
	 */
	public void setListOfBookingsByDate(HashMap<Calendar, LinkedList<Room>> listOfBookingsByDate) {
		this.listOfBookingsByDate = listOfBookingsByDate;
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
