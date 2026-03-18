package com.gla.instance.level1;


    public class HotelBooking {

        private String guestName;
        private String roomType;
        private int nights;

        // Default constructor
        public HotelBooking() {
            this.guestName = "Guest";
            this.roomType = "Standard";
            this.nights = 1;
        }

        // Parameterized constructor
        public HotelBooking(String guestName, String roomType, int nights) {
            this.guestName = guestName;
            this.roomType = roomType;
            this.nights = nights;
        }

        // Copy constructor
        public HotelBooking(HotelBooking other) {
            this.guestName = other.guestName;
            this.roomType = other.roomType;
            this.nights = other.nights;
        }

        // Display booking details
        public void displayBooking() {
            System.out.println("Guest Name: " + guestName);
            System.out.println("Room Type: " + roomType);
            System.out.println("Nights: " + nights);
            System.out.println("---------------------------");
        }

        // Main method for testing
        public static void main(String[] args) {

            // Using default constructor
            HotelBooking booking1 = new HotelBooking();

            // Using parameterized constructor
            HotelBooking booking2 = new HotelBooking("John Doe", "Deluxe", 3);

            // Using copy constructor
            HotelBooking booking3 = new HotelBooking(booking2);

            System.out.println("Default Booking:");
            booking1.displayBooking();

            System.out.println("Parameterized Booking:");
            booking2.displayBooking();

            System.out.println("Copied Booking:");
            booking3.displayBooking();
        }
    }

