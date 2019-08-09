package com.hotel.price;

import java.util.Currency;

/**
 * @author mchouhab
 *
 *         Price and currency details
 */
public class Price {

	private Double amount;
	private Currency currency;

	/**
	 * @param amount
	 * @param cur
	 */
	public Price(Double amount, Currency cur) {
		this.amount = amount;
		this.currency = cur;
	}

	/**
	 * @return the amount
	 */
	public Double getAmount() {
		return amount;
	}

	/**
	 * @param amount
	 *            the amount to set
	 */
	public void setAmount(Double amount) {
		this.amount = amount;
	}

	/**
	 * @return the currency
	 */
	public Currency getCurrency() {
		return currency;
	}

	/**
	 * @param currency
	 *            the currency to set
	 */
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

}
