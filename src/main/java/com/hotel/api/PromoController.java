package com.hotel.api;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.hotel.booking.ReservationBook;
import com.hotel.promo.Promo;

/**
 * @author mchouhab
 *
 *         API to manage promotions list
 */
@RestController
@RequestMapping("/promos")
public class PromoController {

	@Autowired
	ReservationBook reservationBook;

	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody ResponseEntity<List<Promo>> getListOfPromos() {

		return new ResponseEntity<>(reservationBook.getPromos(), HttpStatus.OK);
	}

	// Content-Type: application/json
	@RequestMapping(method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public void addPromo(HttpServletRequest request, @RequestBody Promo promo) {
		reservationBook.addPromo(promo);
		System.out.println("count: " + reservationBook.getPromos().size());
		System.out.println(reservationBook.getPromos().getFirst());
	}

	@RequestMapping(path = "/{Id}", method = RequestMethod.DELETE, produces = "application/json")
	public void deletePromo(@PathVariable("Id") String Id) {

		reservationBook.getPromos().remove(Id);
	}

	public void updatePromo() {

	}

}
