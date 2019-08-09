package com.hotel.room;

import java.util.List;

import com.hotel.price.Price;
import com.hotel.promo.Promo;

/**
 * @author mchouhab
 *
 *         Room details
 */
public class Room {

	private Integer roomNumber;
	private RoomType type;
	private Price price;
	private List<Promo> listOfApplicablePromos;
	private List<RoomFeature> listOfApplicableFeatures;

	/**
	 * @param i
	 * @param doubleroom
	 * @param price2
	 * @param object
	 * @param object2
	 */
	public Room(Integer num, RoomType type, Price price, List<Promo> listOfApplicablePromos,
			List<RoomFeature> listOfApplicableFeatures) {
		this.roomNumber = num;
		this.type = type;
		this.price = price;
		this.listOfApplicablePromos = listOfApplicablePromos;
		this.listOfApplicableFeatures = listOfApplicableFeatures;
	}

	/**
	 * @return the roomNumber
	 */
	public Integer getRoomNumber() {
		return roomNumber;
	}

	/**
	 * @param roomNumber
	 *            the roomNumber to set
	 */
	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	/**
	 * @return the type
	 */
	public RoomType getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(RoomType type) {
		this.type = type;
	}

	/**
	 * @return the price
	 */
	public Price getPrice() {
		return price;
	}

	/**
	 * @param price
	 *            the price to set
	 */
	public void setPrice(Price price) {
		this.price = price;
	}

	/**
	 * @return the listOfApplicablePromos
	 */
	public List<Promo> getListOfApplicablePromos() {
		return listOfApplicablePromos;
	}

	/**
	 * @param listOfApplicablePromos
	 *            the listOfApplicablePromos to set
	 */
	public void setListOfApplicablePromos(List<Promo> listOfApplicablePromos) {
		this.listOfApplicablePromos = listOfApplicablePromos;
	}

	/**
	 * @return the listOfApplicableFeatures
	 */
	public List<RoomFeature> getListOfApplicableFeatures() {
		return listOfApplicableFeatures;
	}

	/**
	 * @param listOfApplicableFeatures
	 *            the listOfApplicableFeatures to set
	 */
	public void setListOfApplicableFeatures(List<RoomFeature> listOfApplicableFeatures) {
		this.listOfApplicableFeatures = listOfApplicableFeatures;
	}

}
