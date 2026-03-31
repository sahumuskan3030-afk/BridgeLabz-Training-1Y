package com.gla.encapsulation;

import java.util.*;

public class VehicleRentalSystem {

    // Interface
    interface Insurable {
        double calculateInsurance(int days);
        String getInsuranceDetails();
    }

    // Abstract Class
    static abstract class Vehicle {
        private String vehicleNumber;
        private String type;
        protected double rentalRate;

        public Vehicle(String vehicleNumber, String type, double rentalRate) {
            this.vehicleNumber = vehicleNumber;
            this.type = type;
            this.rentalRate = rentalRate;
        }

        // Abstract method
        public abstract double calculateRentalCost(int days);

        // Encapsulation (Getters & Setters)
        public String getVehicleNumber() {
            return vehicleNumber;
        }

        public void setVehicleNumber(String vehicleNumber) {
            this.vehicleNumber = vehicleNumber;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }

    // Car Class
    static class Car extends Vehicle implements Insurable {
        private String insurancePolicyNumber; // Encapsulated

        public Car(String number, double rate, String policyNo) {
            super(number, "Car", rate);
            this.insurancePolicyNumber = policyNo;
        }

        @Override
        public double calculateRentalCost(int days) {
            return rentalRate * days;
        }

        @Override
        public double calculateInsurance(int days) {
            return 200 * days;
        }

        @Override
        public String getInsuranceDetails() {
            return "Car Insurance (Policy: " + insurancePolicyNumber + ")";
        }
    }

    // Bike Class
    static class Bike extends Vehicle implements Insurable {
        private String insurancePolicyNumber;

        public Bike(String number, double rate, String policyNo) {
            super(number, "Bike", rate);
            this.insurancePolicyNumber = policyNo;
        }

        @Override
        public double calculateRentalCost(int days) {
            return rentalRate * days;
        }

        @Override
        public double calculateInsurance(int days) {
            return 50 * days;
        }

        @Override
        public String getInsuranceDetails() {
            return "Bike Insurance (Policy: " + insurancePolicyNumber + ")";
        }
    }

    // Truck Class
    static class Truck extends Vehicle implements Insurable {
        private String insurancePolicyNumber;

        public Truck(String number, double rate, String policyNo) {
            super(number, "Truck", rate);
            this.insurancePolicyNumber = policyNo;
        }

        @Override
        public double calculateRentalCost(int days) {
            return rentalRate * days + 500; // extra charge
        }

        @Override
        public double calculateInsurance(int days) {
            return 300 * days;
        }

        @Override
        public String getInsuranceDetails() {
            return "Truck Insurance (Policy: " + insurancePolicyNumber + ")";
        }
    }

    // Polymorphism Demonstration
    public static void processVehicles(List<Vehicle> vehicles, int days) {
        for (Vehicle v : vehicles) {
            double rentalCost = v.calculateRentalCost(days);
            double insuranceCost = 0;

            System.out.println("Vehicle Type: " + v.getType());
            System.out.println("Vehicle Number: " + v.getVehicleNumber());

            if (v instanceof Insurable) {
                Insurable ins = (Insurable) v;
                insuranceCost = ins.calculateInsurance(days);
                System.out.println(ins.getInsuranceDetails());
            }

            System.out.println("Rental Cost for " + days + " days: " + rentalCost);
            System.out.println("Insurance Cost: " + insuranceCost);
            System.out.println("Total Cost: " + (rentalCost + insuranceCost));
            System.out.println("---------------------------");
        }
    }

    // Main Method
    public static void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList<>();

        vehicles.add(new Car("UP01AB1234", 1500, "CAR123"));
        vehicles.add(new Bike("UP02CD5678", 500, "BIKE456"));
        vehicles.add(new Truck("UP03EF9012", 3000, "TRUCK789"));

        processVehicles(vehicles, 3); // rent for 3 days
    }
}
