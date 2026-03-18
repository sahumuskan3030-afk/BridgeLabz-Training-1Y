package com.gla.instance.level1;


    public class CarRental {

        private String customerName;
        private String carModel;
        private int rentalDays;
        private double costPerDay;

        // Default constructor
        public CarRental() {
            this.customerName = "Customer";
            this.carModel = "Standard";
            this.rentalDays = 1;
            this.costPerDay = 50.0; // default price per day
        }

        // Parameterized constructor
        public CarRental(String customerName, String carModel, int rentalDays, double costPerDay) {
            this.customerName = customerName;
            this.carModel = carModel;
            this.rentalDays = rentalDays;
            this.costPerDay = costPerDay;
        }

        // Method to calculate total cost
        public double calculateTotalCost() {
            return rentalDays * costPerDay;
        }

        // Display rental details
        public void displayRentalDetails() {
            System.out.println("Customer Name: " + customerName);
            System.out.println("Car Model: " + carModel);
            System.out.println("Rental Days: " + rentalDays);
            System.out.println("Cost Per Day: $" + costPerDay);
            System.out.println("Total Cost: $" + calculateTotalCost());
            System.out.println("----------------------------");
        }

        // Main method for testing
        public static void main(String[] args) {

            // Using default constructor
            CarRental rental1 = new CarRental();

            // Using parameterized constructor
            CarRental rental2 = new CarRental("Alice Smith", "Toyota Camry", 5, 70.0);

            System.out.println("Default Rental:");
            rental1.displayRentalDetails();

            System.out.println("Custom Rental:");
            rental2.displayRentalDetails();
        }
    }

