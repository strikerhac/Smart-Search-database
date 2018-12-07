package com.lab9.smartsearch;

import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int choice;
		List list;
		int max;
		String cityname;
		double latitude;
		double longitude;
		Scanner input = new Scanner(System.in);
		DBhandler db = new DBhandler();

		System.out.println(
				"Menu{Search by cityname = 1 | Search by latitude = 2 | search by longitude = 3 | Search nearby locations = 4}");
		System.out.print("Your choice? ");
		choice = input.nextInt();

		switch (choice) {
		case 1:
			System.out.print("Enter city name = ");
			input.nextLine();
			cityname = input.nextLine();
			list = db.getbyname(cityname);
			System.out.println(list.size());
			break;

		case 2:
			System.out.print("Enter latitude = ");
			latitude = input.nextDouble();
			list = db.getbylat(latitude);
			System.out.println(list.size());
			break;

		case 3:
			System.out.print("Enter longitude = ");
			longitude = input.nextDouble();
			list = db.getbylong(longitude);
			System.out.println(list.size());
			break;

		case 4:
			System.out.print("Enter city name = ");
			input.nextLine();
			cityname = input.nextLine();
			System.out.print("Enter Max number of locations = ");
			max = input.nextInt();
			list = db.getnearbylocs(cityname, max);
			System.out.println(list.size());
			break;
		}
	}

}
