package com.gla.encapsulation;

import java.util.*;

public class RideHailingApp {

    // Interface
    interface GPS {
        String getCurrentLocation();
        void updateLocation(String location);
    }

    // Abstract Class
    static abstract class Vehicle {
        private String vehicleId;
        private String driverName;
        protected double ratePerKm;

        public Vehicle(String vehicleId, String driverName, double ratePerKm) {
            this.vehicleId = vehicleId;
            this.driverName = driverName;
            this.ratePerKm = ratePerKm;
        }

        // Abstract method
        public abstract double calculateFare(double distance);

        // Concrete method
        public void getVehicleDetails() {
            System.out.println("Vehicle ID: " + vehicleId);
            System.out.println("Driver Name: " + driverName);
            System.out.println("Rate per Km: " + ratePerKm);
        }

        // Encapsulation (Getters)
        public String getVehicleId() {
            return vehicleId;
        }

        public String getDriverName() {
            return driverName;
        }
    }

    // Car Class
    static class Car extends Vehicle implements GPS {
        private String location;

        public Car(String id, String driver, double rate) {
            super(id, driver, rate);
            this.location = "Unknown";
        }

        @Override
        public double calculateFare(double distance) {
            return distance * ratePerKm + 50; // base fare
        }

        @Override
        public String getCurrentLocation() {
            return location;
        }

        @Override
        public void updateLocation(String location) {
            this.location = location;
        }
    }

    // Bike Class
    static class Bike extends Vehicle implements GPS {
        private String location;

        public Bike(String id, String driver, double rate) {
            super(id, driver, rate);
            this.location = "Unknown";
        }

        @Override
        public double calculateFare(double distance) {
            return distance * ratePerKm; // cheaper
        }

        @Override
        public String getCurrentLocation() {
            return location;
        }

        @Override
        public void updateLocation(String location) {
            this.location = location;
        }
    }

    // Auto Class
    static class Auto extends Vehicle implements GPS {
        private String location;

        public Auto(String id, String driver, double rate) {
            super(id, driver, rate);
            this.location = "Unknown";
        }

        @Override
        public double calculateFare(double distance) {
            return distance * ratePerKm + 20; // small base fare
        }

        @Override
        public String getCurrentLocation() {
            return location;
        }

        @Override
        public void updateLocation(String location) {
            this.location = location;
        }
    }

    // Polymorphism Method
    public static void processRides(List<Vehicle> vehicles, double distance) {
        for (Vehicle v : vehicles) {
            v.getVehicleDetails();

            double fare = v.calculateFare(distance); // Polymorphism
            System.out.println("Distance: " + distance + " km");
            System.out.println("Fare: " + fare);

            if (v instanceof GPS) {
                GPS gps = (GPS) v;
                gps.updateLocation("City Center");
                System.out.println("Current Location: " + gps.getCurrentLocation());
            }

            System.out.println("---------------------------");
        }
    }

    // Main Method
    public static void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList<>();

        vehicles.add(new Car("C101", "Alice", 15));
        vehicles.add(new Bike("B202", "Bob", 8));
        vehicles.add(new Auto("A303", "Charlie", 10));

        processRides(vehicles, 10); // distance = 10 km
    }
}
