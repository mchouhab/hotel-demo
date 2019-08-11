package com.hotel.booking;

import java.util.Calendar;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hotel.promo.PromoType;
import com.hotel.room.RoomFeature;

/**
 * @author mchouhab
 *
 *         Represents a booking entity with room and date details
 */
public class Booking {
	
	private Integer id;
	private Integer roomId;
	private Calendar reservationStartDate;
	private Calendar reservationEndDate;
	private List<PromoType> priceUpgrades; // List of offers included in this booking
	private List<RoomFeature> featureUpgrades; // List of features included with this booking

	/**
	 * @param room
	 * @param reservationStartDate
	 * @param reservationEndDate
	 * @param priceUpgrades
	 * @param featureUpgrades
	 */
	@JsonCreator
	public Booking(@JsonProperty("id") Integer id, @JsonProperty("roomId") Integer roomId, @JsonProperty("reservationStartDate") Calendar reservationStartDate, 
			@JsonProperty("reservationEndDate") Calendar reservationEndDate, 
			@JsonProperty("priceUpgrades") List<PromoType> priceUpgrades,
			@JsonProperty("featureUpgrades") List<RoomFeature> featureUpgrades) {
		this.setId(id);
		this.roomId = roomId;
		this.reservationStartDate = reservationStartDate;
		this.reservationEndDate = reservationEndDate;
		this.priceUpgrades = priceUpgrades;
		this.featureUpgrades = featureUpgrades;

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
	public List<PromoType> getPriceUpgrades() {
		return priceUpgrades;
	}

	/**
	 * @param priceUpgrades
	 *            the priceUpgrades to set
	 */
	public void setPriceUpgrades(List<PromoType> priceUpgrades) {
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

	/**
	 * @return the roomId
	 */
	public Integer getRoomId() {
		return roomId;
	}

	/**
	 * @param roomId the roomId to set
	 */
	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

}