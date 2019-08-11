package com.hotel.api;

import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.hotel.booking.ReservationBook;
import com.hotel.room.Room;

/**
 * @author mchouhab
 *
 *         API to manage rooms
 */
@RestController
@RequestMapping("/rooms")
public class RoomController {

	@Autowired
	ReservationBook reservationBook;

	/**
	 * Get list of all rooms in the system
	 * 
	 * @return
	 */
	@GetMapping(produces = "application/json")
	public ResponseEntity<LinkedList<Room>> getListOfRooms() {
		return new ResponseEntity<>(reservationBook.getRooms(), HttpStatus.OK);
	}

	/**
	 * Create a new room with a new id, idempotent: no
	 * 
	 * @param room
	 */
	@PostMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public void addRoom(@RequestBody Room room) {
		int id = reservationBook.getRooms().size();
		room.setId(id);
		reservationBook.getRooms().add(id, room);
	}

	/**
	 * Bulk upload a list of room using a json array [{],{}]
	 * 
	 * @param rooms
	 */
	@PostMapping(path = "bulk", consumes = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public void addRoomBulkUpload(@RequestBody List<Room> rooms) {
		for (Room room : rooms) {
			int id = reservationBook.getRooms().size();
			room.setId(id);
			reservationBook.getRooms().add(id, room);
		}
	}

	/**
	 * Delete a room from list of rooms
	 * 
	 * @param Id
	 * @return
	 */
	@RequestMapping(path = "/{Id}", method = RequestMethod.DELETE)
	public ResponseEntity<HttpStatus> deleteRoom(@PathVariable("Id") Integer id) {
		try {
			reservationBook.getRooms().remove(id.intValue());
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (IndexOutOfBoundsException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * Update an existing room, idempotent: yes Return Not Found if no
	 * room element is found
	 * 
	 * @param id
	 * @param room
	 */
	@PutMapping(path = "/{Id}", consumes = "application/json")
	public ResponseEntity<HttpStatus> updateRoom(@PathVariable("Id") Integer id, @RequestBody Room room) {
		try {
			if (reservationBook.getRooms().get(id.intValue()) != null) {
				reservationBook.getRooms().add(id, room);
				return new ResponseEntity<>(HttpStatus.OK);
			}
		} catch (IndexOutOfBoundsException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}

}
