package com.hotel.booking;

import java.util.Calendar;
import java.util.List;

import com.hotel.promo.Promo;
import com.hotel.room.Room;
import com.hotel.room.RoomFeature;

/**
 * @author mchouhab
 *
 *         Represents a booking entity with room and date details
 */
public class Booking {
	Room room;
	Calendar reservationStartDate;
	Calendar reservationEndDate;
	List<Promo> priceUpgrades; // Promotions that can be applied to a certain type of rooms
	List<RoomFeature> featureUpgrades; // Features that can apply to a certain type of rooms

	/**
	 * @param room
	 * @param reservationStartDate
	 * @param reservationEndDate
	 * @param priceUpgrades
	 * @param featureUpgrades
	 */
	public Booking(Room room, Calendar reservationStartDate, Calendar reservationEndDate, List<Promo> priceUpgrades,
			List<RoomFeature> featureUpgrades) {
		this.room = room;
		this.reservationStartDate = reservationStartDate;
		this.reservationEndDate = reservationEndDate;
		this.priceUpgrades = priceUpgrades;
		this.featureUpgrades = featureUpgrades;

	}

	/**
	 * @param start
	 * @param end
	 * @param promo
	 */
	public void ApplyPromoForTime(Calendar start, Calendar end, Promo promo) {

	}

	/**
	 * @param start
	 * @param end
	 * @param feature
	 */
	public void ApplyFeatureUpgradeForTime(Calendar start, Calendar end, RoomFeature feature) {

	}

	/**
	 * Method to book a room or remove reservation from a room
	 * 
	 * @param start
	 * @param end
	 * @param isAvailable
	 */
	public void setRoomAvailabilityForTime(Calendar start, Calendar end, Boolean isAvailable) {

	}

	/**
	 * @return the room
	 */
	public Room getRoom() {
		return room;
	}

	/**
	 * @param room
	 *            the room to set
	 */
	public void setRoom(Room room) {
		this.room = room;
	}

	/**
	 * @return the reservationStartDate
	 */
	public Calendar getReservationStartDate() {
		return reservationStartDate;
	}

	/**
	 * @param reservationStartDate
	 *            the reservationStartDate to set
	 */
	public void setReservationStartDate(Calendar reservationStartDate) {
		this.reservationStartDate = reservationStartDate;
	}

	/**
	 * @return the reservationEndDate
	 */
	public Calendar getReservationEndDate() {
		return reservationEndDate;
	}

	/**
	 * @param reservationEndDate
	 *            the reservationEndDate to set
	 */
	public void setReservationEndDate(Calendar reservationEndDate) {
		this.reservationEndDate = reservationEndDate;
	}

	/**
	 * @return the priceUpgrades
	 */
	public List<Promo> getPriceUpgrades() {
		return priceUpgrades;
	}

	/**
	 * @param priceUpgrades
	 *            the priceUpgrades to set
	 */
	public void setPriceUpgrades(List<Promo> priceUpgrades) {
		this.priceUpgrades = priceUpgrades;
	}

	/**
	 * @return the featureUpgrades
	 */
	public List<RoomFeature> getFeatureUpgrades() {
		return featureUpgrades;
	}

	/**
	 * @param featureUpgrades
	 *            the featureUpgrades to set
	 */
	public void setFeatureUpgrades(List<RoomFeature> featureUpgrades) {
		this.featureUpgrades = featureUpgrades;
	}

}