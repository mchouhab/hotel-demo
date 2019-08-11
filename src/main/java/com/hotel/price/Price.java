package com.hotel.price;

import java.util.Currency;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

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
	@JsonCreator
	public Price(@JsonProperty("amount") Double amount, @JsonProperty("currency")  Currency currency) {
		this.amount = amount;
		this.currency = currency;
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
