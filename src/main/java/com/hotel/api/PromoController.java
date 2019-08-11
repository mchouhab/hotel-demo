package com.hotel.api;

import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.hotel.booking.ReservationBook;
import com.hotel.promo.Promo;

/**
 * @author mchouhab
 *
 *         API to manage promotions list JSON header is required: [Content-Type:
 *         application/json]
 */
@RestController
@RequestMapping("/promos")
public class PromoController {

	@Autowired
	ReservationBook reservationBook;

	/**
	 * Get list of all promotions in the system
	 * 
	 * @return
	 */
	@GetMapping(produces = "application/json")
	public ResponseEntity<LinkedList<Promo>> getListOfPromos() {
		return new ResponseEntity<>(reservationBook.getPromos(), HttpStatus.OK);
	}

	/**
	 * Create a new promotion with a new id, idempotent: no
	 * 
	 * @param promo
	 */
	@PostMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public void addPromo(@RequestBody Promo promo) {
		int id = reservationBook.getPromos().size();
		promo.setId(id);
		reservationBook.getPromos().add(id, promo);
	}

	/**
	 * Bulk upload a list of promotion using a json array [{],{}]
	 * 
	 * @param promos
	 */
	@PostMapping(path = "bulk", consumes = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public void addPromoBulkUpload(@RequestBody List<Promo> promos) {
		for (Promo promo : promos) {
			int id = reservationBook.getPromos().size();
			promo.setId(id);
			reservationBook.getPromos().add(id, promo);
		}
	}

	/**
	 * Delete a promotion from list of promotions
	 * 
	 * @param Id
	 * @return
	 */
	@RequestMapping(path = "/{Id}", method = RequestMethod.DELETE)
	public ResponseEntity<HttpStatus> deletePromo(@PathVariable("Id") Integer id) {
		try {
			reservationBook.getPromos().remove(id.intValue());
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (IndexOutOfBoundsException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * Update an existing promotion, idempotent: yes Return Not Found if no
	 * promotion element is found
	 * 
	 * @param id
	 * @param promo
	 */
	@PutMapping(path = "/{Id}", consumes = "application/json")
	public ResponseEntity<HttpStatus> updatePromo(@PathVariable("Id") Integer id, @RequestBody Promo promo) {
		try {
			if (reservationBook.getPromos().get(id.intValue()) != null) {
				reservationBook.getPromos().add(id, promo);
				return new ResponseEntity<>(HttpStatus.OK);
			}
		} catch (IndexOutOfBoundsException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}

}
