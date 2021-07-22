# hotel-demo
Hotel reservation system demo

# Under Development
Backend APIs to perform certain hotel reservation and promotion application tasks.

# Build Requirements
Gradle 5.4.1<br>
Java 8<br>
[Eclipse] Gradle command to build the project: gradle cleanEclipse eclipse build

# Initial APIs

GET /rooms<br>
GET /reservations<br>
GET /promos<br>

GET /rooms/{id}<br>
GET /reservations/{id}<br>
GET /promos/{id}<br>

POST /rooms<br>
POST /reservations<br>
POST /promos<br>

POST /rooms/bulk<br>
POST /promos/bulk<br>

PUT /rooms/{id}<br>
PUT /promos/{id}<br>

DELETE /rooms/{id}<br>
DELETE /reservations/{id}<br>
DELETE /promos/{id}<br>

GET /vacancies?roomType=?&start=?&end=?


# API Example


Get list of all rooms<br>
http://[IP]:[PORT]/rooms<br>

Get list of all promotions and the room ids that have the promo applied<br>
http://[IP]:[PORT]/promos<br>

Get list of all reservations on the system<br>
http://[IP]:[PORT]/reservations<br>

Get list of all reservations in a system booked against a certain room Id or type using a time range - filters are optional for this call<br>
http://[IP]:[PORT]/reservations?roomId=2&roomType=DoubleRoom&start=2019-08-01&end=2019-08-30<br>
<br>
Find rooms vacancies for certain dates - All filter parameters are required for this call<br>

Example of unavailable room type during a certain time range "DoubleRoom" - Return list will be empty due to unavailability of any room with this criteria<br>
http://[IP]:[PORT]/vacancies?roomType=DoubleRoom&start=2019-08-10&end=2019-09-25<br>

Example of available room type during same time range "LuxuryRoom"<br>
http://[IP]:[PORT]/vacancies?roomType=LuxuryRoom&start=2019-08-25&end=2019-09-25<br>

Another room type that is available during the same range "SingleRoom"<br>
http://[IP]:[PORT]/vacancies?roomType=SingleRoom&start=2019-08-25&end=2019-09-25<br>



# Class Diagram

![alt text](https://github.com/mchouhab/hotel-demo/blob/master/hotel-reservation-class-diagram.gif)

# Sample JSON Data

booking.json
```json
	{
		"roomId": 2,
		"start": "2019-08-01",
		"end": "2019-08-30",
		"priceUpgrades": [
			"Discount",
			"ExtraDay",
			"FeatureUpgrade"
		],
		"featureUpgrades": [
			"DoubleBed",
			"SingleBed",
			"QueenBed",
			"KingBed",
			"Microwave",
			"Fridge"
		]
	}
```
promo.json
```json
[
	{
		"id": 1,
		"type": "Discount",
		"value": {
			"amount": 10.0,
			"currency": "USD"
		},
		"startDate": "2018-08-14T00:00:00.000+0000",
		"endDate": "2019-08-14T00:00:00.000+0000",
		"roomIds": [1,2,3]
	},
	{
		"id": 2,
		"type": "ExtraDay",
		"value": {
			"amount": 150.0,
			"currency": "USD"
		},
		"startDate": "2019-08-14",
		"endDate": "2019-08-30",
		"roomIds": [1,2]
	},
	{
		"id": 3,
		"type": "FeatureUpgrade",
		"value": {
			"amount": 40.0,
			"currency": "USD"
		},
		"startDate": null,
		"endDate": null,
		"roomIds": [3]
	}	
]
```
room.json
```json
[
	{
		"id": 1,
		"type": "SingleRoom",
		"price": {
			"amount": 150.0,
			"currency": "USD"
		},
		"listOfApplicablePromos": [
			"Discount",
			"ExtraDay",
			"FeatureUpgrade"
		],
		"listOfApplicableFeatures": [
			"DoubleBed",
			"SingleBed",
			"QueenBed",
			"KingBed",
			"Microwave",
			"Fridge"
		]
	},
	{
		"id": 2,
		"type": "LuxuryRoom",
		"price": {
			"amount": 800.0,
			"currency": "USD"
		},
		"listOfApplicablePromos": [
			"FeatureUpgrade"
		],
		"listOfApplicableFeatures": [
			"OceanView",
			"GradenView",
			"Office",
			"DoubleBed",
			"SingleBed",
			"QueenBed",
			"KingBed",
			"NonSmoker",
			"YesSmoker",
			"Microwave",
			"Fridge",
			"Jacuzzi"
		]
	},
	{
		"id": 3,
		"type": "DoubleRoom",
		"price": {
			"amount": 250.0,
			"currency": "USD"
		},
		"listOfApplicablePromos": [
			"Discount",
			"ExtraDay",
			"FeatureUpgrade"
		],
		"listOfApplicableFeatures": [
			"GradenView",
			"Office",
			"DoubleBed",
			"SingleBed",
			"Microwave",
			"Fridge"
		]
	}
]
```
