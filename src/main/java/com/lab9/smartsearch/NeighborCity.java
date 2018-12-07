package com.lab9.smartsearch;

public class NeighborCity {
	private double distance;
	private String name;

	public NeighborCity(double distance, String name) {
		this.distance = distance;
		this.name = name;
	}

	public NeighborCity() {
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}