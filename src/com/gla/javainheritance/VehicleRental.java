package com.gla.javainheritance;

// Interface
interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}

// Abstract class
abstract class Vehicle {
    private String vehicleNumber;
    private String type;
    private double rentalRate;

    // Constructor
    public Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }

    // Encapsulation: Getters & Setters
    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getType() {
        return type;
    }

    public double getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(double rentalRate) {
        this.rentalRate = rentalRate;
    }

    // Abstract method
    public abstract double calculateRentalCost(int days);

    // Common method
    public void displayDetails() {
        System.out.println("Vehicle No: " + vehicleNumber);
        System.out.println("Type: " + type);
        System.out.println("Rate per day: " + rentalRate);
    }
}

// Car class
class Car extends Vehicle implements Insurable {
    private String insurancePolicyNumber; // encapsulated

    public Car(String number, double rate, String policyNo) {
        super(number, "Car", rate);
        this.insurancePolicyNumber = policyNo;
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    @Override
    public double calculateInsurance() {
        return getRentalRate() * 0.10; // 10% insurance
    }

    @Override
    public String getInsuranceDetails() {
        return "Car Insurance (10%) - Policy No: ****" +
                insurancePolicyNumber.substring(insurancePolicyNumber.length() - 4);
    }
}

// Bike class
class Bike extends Vehicle implements Insurable {
    private String insurancePolicyNumber;

    public Bike(String number, double rate, String policyNo) {
        super(number, "Bike", rate);
        this.insurancePolicyNumber = policyNo;
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    @Override
    public double calculateInsurance() {
        return getRentalRate() * 0.05; // 5% insurance
    }

    @Override
    public String getInsuranceDetails() {
        return "Bike Insurance (5%) - Policy No: ****" +
                insurancePolicyNumber.substring(insurancePolicyNumber.length() - 4);
    }
}

// Truck class
class Truck extends Vehicle implements Insurable {
    private String insurancePolicyNumber;

    public Truck(String number, double rate, String policyNo) {
        super(number, "Truck", rate);
        this.insurancePolicyNumber = policyNo;
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days * 1.2; // extra load factor
    }

    @Override
    public double calculateInsurance() {
        return getRentalRate() * 0.15; // 15% insurance
    }

    @Override
    public String getInsuranceDetails() {
        return "Truck Insurance (15%) - Policy No: ****" +
                insurancePolicyNumber.substring(insurancePolicyNumber.length() - 4);
    }
}

// Main class
public class VehicleRental
{

    public static void processVehicle(Vehicle v, int days) {
        v.displayDetails();

        double rent = v.calculateRentalCost(days);
        double insurance = 0;

        if (v instanceof Insurable) {
            Insurable i = (Insurable) v;
            insurance = i.calculateInsurance();
            System.out.println(i.getInsuranceDetails());
        }

        System.out.println("Rental Cost (" + days + " days): " + rent);
        System.out.println("Insurance Cost: " + insurance);
        System.out.println("Total Cost: " + (rent + insurance));
        System.out.println("------------------------");
    }

    public static void main(String[] args) {

        Vehicle v1 = new Car("UP32AB1234", 2000, "CAR12345678");
        Vehicle v2 = new Bike("UP32XY5678", 500, "BIKE87654321");
        Vehicle v3 = new Truck("UP32TR9999", 4000, "TRUCK11223344");

        Vehicle[] vehicles = {v1, v2, v3};

        int days = 3;

        // Polymorphism
        for (Vehicle v : vehicles) {
            processVehicle(v, days);
        }
    }
}
