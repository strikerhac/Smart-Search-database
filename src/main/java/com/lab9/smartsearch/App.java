package com.lab9.smartsearch;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.opencsv.CSVReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
public class App {
	private static DBhandler handler = new DBhandler();
	private static List<Country> records = handler.findAll();
	
	public void data_entry(String csvfilepath) throws NumberFormatException, IOException {

		FileReader filereader = new FileReader(csvfilepath);
		CSVReader csvReader = new CSVReader(filereader);
		DBhandler db = new DBhandler();
		String[] Rec;
		Country c;

		while ((Rec = csvReader.readNext()) != null) {
			c = new Country(Integer.parseInt(Rec[0]), Rec[1], Rec[2], Rec[3], Integer.parseInt(Rec[4]),
					Double.parseDouble(Rec[5]), Double.parseDouble(Rec[6]), Integer.parseInt(Rec[7]),
					Integer.parseInt(Rec[8]));
			db.save(c);
		}

	}


	// Method to find distance between two points.
	static double distanceInKm(double startLati, double startLong, double endLati, double endLong) {
		double diffLati = Math.toRadians(endLati - startLati);
		double diffLong = Math.toRadians(endLong - startLong);
		double radiusStartLati = Math.toRadians(startLati);
		double radiusEndLati = Math.toRadians(endLati);
		double a = Math.pow(Math.sin(diffLati / 2), 2)
				+ Math.pow(Math.sin(diffLong / 2), 2) * Math.cos(radiusStartLati) * Math.cos(radiusEndLati);
		double c = 2 * Math.asin(Math.sqrt(a));

		return 6370 * c;
	}

	static void getLatitudeLongitude(String cityName) {
		List<Country> records = handler.findAll();
		for (Country record : records) {
			if (record.getCity().equals(cityName)) {
				System.out.println("City Name: " + record.getCity() + "\n" + "Latitude: " + record.getLatitude() + "\n"
						+ "Longitude: " + record.getLongitude());
				System.out.println();
			}
		}
	}

	private static Country getRecord(String cityName) {
		for (Country record : records) {
			if (record.getCity().equals(cityName)) {
				return record;
			}
		}
		return null;
	}

	// Finding distances between target city and all other cities based on city
	// name.
	static void findNeighbors(String targetCity, int numberOfNeighbors) {
		Country targetCityRecord = getRecord(targetCity);
		List<NeighborCity> neighborCities = new ArrayList<NeighborCity>();
		for (Country record : records) {
			NeighborCity city = new NeighborCity();

			city.setDistance(distanceInKm(Objects.requireNonNull(targetCityRecord).getLatitude(),
					targetCityRecord.getLongitude(), record.getLatitude(),
					record.getLongitude()));
			city.setName(record.getCity());
			neighborCities.add(city);
		}
		print(neighborCities, numberOfNeighbors);
	}

	// Finding distances based on latitude and longitude values.
	static void findNeighbors(double latitude, double longitude, int numberOfNeighbors) {
		List<NeighborCity> neighborCities = new ArrayList<NeighborCity>();
		for (Country record : records) {
			NeighborCity city = new NeighborCity();

			city.setDistance(distanceInKm(latitude,longitude,
					record.getLatitude(),record.getLongitude()));
			city.setName(record.getCity());
			neighborCities.add(city);
		}
		print(neighborCities, numberOfNeighbors);
	}

	private static void print(List<NeighborCity> neighborCities, int numberOfNeighbors) {
		neighborCities.sort(Comparator.comparing(NeighborCity::getDistance));
		for (int i = 1; i < numberOfNeighbors + 1; i++) {
			System.out.println("City Name: " + neighborCities.get(i).getName() + "\n" + "Distance: "
					+ neighborCities.get(i).getDistance() + " Kilometers" + "\n");
		}
	}

}
