package com.hotel.room;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hotel.price.Price;
import com.hotel.promo.PromoType;

/**
 * @author mchouhab
 *
 *         Room details
 */
public class Room {

	private Integer id;
	private RoomType type;
	private Price price;
	private List<PromoType> listOfApplicablePromos; // List of promotions types that can be applied to this room
	private List<RoomFeature> listOfApplicableFeatures; // List of features that can be added to this room

	/**
	 * @param id
	 * @param type
	 * @param price
	 * @param listOfApplicablePromos
	 * @param listOfApplicableFeatures
	 */
	@JsonCreator
	public Room(@JsonProperty("id") Integer id, @JsonProperty("type") RoomType type, @JsonProperty("price") Price price, 
			@JsonProperty("listOfApplicablePromos") List<PromoType> listOfApplicablePromos,
			@JsonProperty("listOfApplicableFeatures") List<RoomFeature> listOfApplicableFeatures) {
		this.id = id;
		this.type = type;
		this.price = price;
		this.setListOfApplicablePromos(listOfApplicablePromos);
		this.listOfApplicableFeatures = listOfApplicableFeatures;
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

	/**
	 * @return the listOfApplicablePromos
	 */
	public List<PromoType> getListOfApplicablePromos() {
		return listOfApplicablePromos;
	}

	/**
	 * @param listOfApplicablePromos the listOfApplicablePromos to set
	 */
	public void setListOfApplicablePromos(List<PromoType> listOfApplicablePromos) {
		this.listOfApplicablePromos = listOfApplicablePromos;
	}

}
