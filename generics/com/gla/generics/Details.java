package com.gla.generics;

import java.util.*;

// Base class
class Vehicle {
    String name;

    public Vehicle(String name) {
        this.name = name;
    }

    public void showDetails() {
        System.out.println("Vehicle: " + name);
    }
}

// Subclasses
class Truck extends Vehicle {
    public Truck(String name) {
        super(name);
    }

    @Override
    public void showDetails() {
        System.out.println("Truck: " + name);
    }
}

class Bike extends Vehicle {
    public Bike(String name) {
        super(name);
    }

    @Override
    public void showDetails() {
        System.out.println("Bike: " + name);
    }
}

// Generic Fleet Manager
class FleetManager<T extends Vehicle> {
    private List<T> fleet = new ArrayList<>();

    // Add vehicle
    public void addVehicle(T vehicle) {
        fleet.add(vehicle);
    }

    // Show fleet
    public void showFleet() {
        for (T vehicle : fleet) {
            vehicle.showDetails();
        }
    }
}

// Test class
public class Details {
    public static void main(String[] args) {

        // Truck fleet
        FleetManager<Truck> truckFleet = new FleetManager<>();
        truckFleet.addVehicle(new Truck("Tata Truck"));
        truckFleet.addVehicle(new Truck("Ashok Leyland Truck"));

        System.out.println("Truck Fleet:");
        truckFleet.showFleet();

        // Bike fleet
        FleetManager<Bike> bikeFleet = new FleetManager<>();
        bikeFleet.addVehicle(new Bike("Royal Enfield"));
        bikeFleet.addVehicle(new Bike("Yamaha R15"));

        System.out.println("\nBike Fleet:");
        bikeFleet.showFleet();

        // ❌ Not allowed
        // FleetManager<String> invalidFleet = new FleetManager<>(); // Compile-time error
    }
}
