package com.hotel.promo;

import java.util.Calendar;

import com.hotel.price.Price;

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

	/**
	 * @param id
	 * @param type
	 * @param value
	 * @param startDate
	 * @param endDate
	 */
	public Promo(Integer id, PromoType type, Price value, Calendar startDate, Calendar endDate) {
		this.Id = id;
		this.type = type;
		this.value = value;
		this.startDate = startDate;
		this.endDate = endDate;
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

}
