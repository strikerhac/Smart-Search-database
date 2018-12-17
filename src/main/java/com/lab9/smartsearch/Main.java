package com.lab9.smartsearch;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		int max;
		int choice;
		String cityname;
		double latitude;
		double longitude;
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		App app = new App();

		while (true) {
			System.out.println("Menu{Search lat/long by cityname = 1 | Search nearby Neighbors = 2}");
			System.out.print("Your choice? ");
			choice = input.nextInt();

			if (choice == 1) {
				System.out.print("Enter city name = ");
				input.nextLine();
				cityname = input.nextLine();
				app.getLatitudeLongitude(cityname);
				choice = 0;
			}

			else if (choice == 2) {
				choice = 0;
				System.out.println("Menu{Search by lat/long = 1 | Search by cityname= 2}");
				System.out.print("Your choice? ");
				choice = input.nextInt();

				if (choice == 1) {
					System.out.print("Enter latitude = ");
					latitude = input.nextDouble();
					System.out.print("Enter longitude = ");
					longitude = input.nextDouble();
					System.out.print("Enter Max number of Neighbors = ");
					max = input.nextInt();
					app.findNeighbors(latitude, longitude, max);
				}

				else if (choice == 2) {
					System.out.print("Enter city name = ");
					input.nextLine();
					cityname = input.nextLine();
					System.out.print("Enter Max number of Neighbors = ");
					max = input.nextInt();
					app.findNeighbors(cityname, max);
				}

				else
					System.out.print("Enter valid choice");
			}

			else
				System.out.print("Enter valid choice");
		}
	}
}
