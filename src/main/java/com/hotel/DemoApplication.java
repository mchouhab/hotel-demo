package com.hotel;

import java.util.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import com.hotel.booking.ReservationBook;
import com.hotel.price.Price;
import com.hotel.promo.Promo;
import com.hotel.promo.PromoType;
import com.hotel.room.Room;
import com.hotel.room.RoomType;

@SpringBootApplication
@RestController
public class DemoApplication implements CommandLineRunner {

 	
	@Autowired
	ReservationBook reservationBook;
	
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(DemoApplication.class);
		app.run(args);

	}

	/* (non-Javadoc)
	 * @see org.springframework.boot.CommandLineRunner#run(java.lang.String[])
	 */
	@Override
	public void run(String... args) throws Exception {
		reservationBook.getPromos().add(new Promo(1, PromoType.Discount,new Price(10.0,Currency.getInstance("USD")),null,null));
		reservationBook.getRooms().add(new Room(1, RoomType.DoubleRoom,new Price(50.0,Currency.getInstance("USD")), null,null));
		
	}

}
