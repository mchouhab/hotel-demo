package com.hotel.promo;

import java.util.Calendar;
import java.util.LinkedList;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hotel.price.Price;
import com.hotel.room.Room;

/**
 * @author mchouhab
 *
 *         Promotion details
 */
public class Promo {

	private Integer Id;
	private PromoType type;
	private Price value;
	private Calendar startDate;
	private Calendar endDate;
	private LinkedList<Integer> roomIds = new LinkedList<Integer>();

	/**
	 * @param id
	 * @param type
	 * @param value
	 * @param startDate
	 * @param endDate
	 */
	@JsonCreator
	public Promo(@JsonProperty("id") Integer id, @JsonProperty("type") PromoType type, @JsonProperty("value") Price value, 
			@JsonProperty("startDate") Calendar startDate, @JsonProperty("endDate") Calendar endDate, @JsonProperty("roomIds") LinkedList<Integer> roomIds) {
		this.Id = id;
		this.type = type;
		this.value = value;
		this.startDate = startDate;
		this.endDate = endDate;
		this.roomIds = roomIds;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return Id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		Id = id;
	}

	/**
	 * @return the type
	 */
	public PromoType getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(PromoType type) {
		this.type = type;
	}

	/**
	 * @return the value
	 */
	public Price getValue() {
		return value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(Price value) {
		this.value = value;
	}

	/**
	 * @return the startDate
	 */
	public Calendar getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate
	 *            the startDate to set
	 */
	public void setStartDate(Calendar startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public Calendar getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate
	 *            the endDate to set
	 */
	public void setEndDate(Calendar endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return the roomIds
	 */
	public LinkedList<Integer> getRoomIds() {
		return roomIds;
	}

	/**
	 * @param roomIds the roomIds to set
	 */
	public void setRoomIds(LinkedList<Integer> roomIds) {
		this.roomIds = roomIds;
	}

}
