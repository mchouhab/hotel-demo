# hotel-demo
Hotel reservation system demo

# Under Development
Backend APIs to perform certain hotel reservation and promotion application tasks.

# Build Requirements
Gradle 5.4.1<br>
Java 8

# Initial APIs

GET /rooms<br>
GET /reservastions<br>
GET /promos<br>

GET /rooms/{id}<br>
GET /reservastions/{id}<br>
GET /promos/{id}<br>

POST /rooms<br>
POST /reservations<br>
POST /promos<br>

POST /rooms/bulk<br>
POST /promos/bulk<br>

PUT /rooms/{id}<br>
PUT /reservations/{id}<br>
PUT /promos/{id}<br>

DELETE /rooms/{id}<br>
DELETE /reservastions/{id}<br>
DELETE /promos/{id}<br>

# Class Diagram

![alt text](https://github.com/mchouhab/hotel-demo/blob/master/hotel-reservation-class-diagram.jpg)

# Sample JSON Data

booking.json
```json
[
	{
		"id": 1,
		"roomId": 2,
		"startDate": "2018-08-14T00:00:00.000+0000",
		"endDate": "2019-08-14T00:00:00.000+0000",
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
]
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
