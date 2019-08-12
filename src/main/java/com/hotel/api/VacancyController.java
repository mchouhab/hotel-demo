/**
 * 
 */
package com.hotel.api;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.booking.Booking;
import com.hotel.booking.ReservationBook;
import com.hotel.room.Room;

/**
 * @author mchouhab
 * 
 *  This is not a fully Restful API, however, it is used to lookup rooms availability
 *
 */
@RestController
@RequestMapping("/vacancies")
public class VacancyController {

	@Autowired
	ReservationBook reservationBook;

	@Autowired
	BookingController bookingController;

	/**
	 * Get list of vacant rooms
	 * 
	 * @return
	 * @throws ParseException
	 */
	// http://localhost:9090/vacancies?roomType=DoubleRoom&start=2018-08-01&end=2019-08-10
	@GetMapping()
	public ResponseEntity<Set<Room>> getListOfVacancies(@RequestParam(required = false) Integer roomId,
			@RequestParam(required = true) String roomType, @RequestParam(required = true) String start,
			@RequestParam(required = true) String end) {

		LinkedList<Booking> list = new LinkedList<Booking>();
		for (Booking booking : reservationBook.getBookings())
			list.add(booking);

		// Filter for the date range
		if (start != null && end != null) {

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar startCl = new GregorianCalendar();
			try {
				startCl.setTime(sdf.parse(start));

				Calendar endCl = new GregorianCalendar();
				endCl.setTime(sdf.parse(end));
				sdf.setCalendar(endCl);

				startCl = bookingController.setTime(startCl);
				list = bookingController.getListOfReservations(roomId, roomType, startCl, endCl);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		// Filter for roomId
		if (roomId != null) {
			for (Booking booking : list) {
				if (booking.getRoomId() != roomId)
					list.remove(booking);
			}
		}
		// Filter for roomType
		if (roomType != null) {
			for (Booking booking : list) {
				if (!(booking.getRoomType().name().equalsIgnoreCase(roomType.trim())))
					list.remove(booking);
			}
		}
		
		Set<Integer> bookedRooms = new HashSet<Integer>();
		for (Booking booking : list){
			bookedRooms.add(booking.getRoomId());
		}
		
		Set<Room> vacantRooms = new HashSet<Room>();
		for (Room room : this.reservationBook.getRooms()){
			if ((!bookedRooms.contains(room.getId())) && (room.getType().name().toString().equalsIgnoreCase(roomType.trim())))
					vacantRooms.add(room);
		}
		return new ResponseEntity<>(vacantRooms, HttpStatus.OK);
	}

}
