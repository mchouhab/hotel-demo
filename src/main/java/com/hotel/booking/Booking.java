package com.hotel.booking;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hotel.promo.PromoType;
import com.hotel.room.RoomFeature;
import com.hotel.room.RoomType;

/**
 * @author mchouhab
 *
 *         Represents a booking entity with room and date details
 */
public class Booking {

	private Integer id;
	private Integer roomId;
	private RoomType roomType;
	private Calendar start;
	private Calendar end;
	private List<PromoType> priceUpgrades; // List of offers included in this
											// booking
	private List<RoomFeature> featureUpgrades; // List of features included with
	
	/**
	 * @param room
	 * @param start
	 * @param end
	 * @param priceUpgrades
	 * @param featureUpgrades
	 */
	@JsonCreator
	public Booking(@JsonProperty("id") Integer id, @JsonProperty("roomId") Integer roomId,
			@JsonProperty("start") Calendar start,
			@JsonProperty("end") Calendar end,
			@JsonProperty("priceUpgrades") List<PromoType> priceUpgrades,
			@JsonProperty("featureUpgrades") List<RoomFeature> featureUpgrades) {
		this.setId(id);
		this.roomId = roomId;
		this.start = start;
		this.end = end;
		this.priceUpgrades = priceUpgrades;
		this.featureUpgrades = featureUpgrades;

	}

	/**
	 * @return the start
	 */
	public Calendar getStart() {
		return start;
	}

	/**
	 * @param start
	 *            the start to set
	 */
	public void setStart(Calendar start) {
		this.start = start;
	}

	/**
	 * @return the end
	 */
	public Calendar getEnd() {
		return end;
	}

	/**
	 * @param end
	 *            the end to set
	 */
	public void setEnd(Calendar end) {
		this.end = end;
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
	 * @param roomId
	 *            the roomId to set
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
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the roomType
	 */
	public RoomType getRoomType() {
		return roomType;
	}

	/**
	 * @param roomType the roomType to set
	 */
	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}

}