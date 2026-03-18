package com.gla.instance.level1;


    public class Circle {

        private double radius;

        // Default constructor
        public Circle() {
            this(1.0); // Calls the parameterized constructor with default value
        }

        // Parameterized constructor
        public Circle(double radius) {
            this.radius = radius;
        }

        // Getter method
        public double getRadius() {
            return radius;
        }

        // Setter method
        public void setRadius(double radius) {
            this.radius = radius;
        }

        // Method to calculate area
        public double getArea() {
            return Math.PI * radius * radius;
        }

        // Method to calculate circumference
        public double getCircumference() {
            return 2 * Math.PI * radius;
        }

        // Main method for testing
        public static void main(String[] args) {
            Circle defaultCircle = new Circle();
            Circle customCircle = new Circle(5.0);

            System.out.println("Default Circle Radius: " + defaultCircle.getRadius());
            System.out.println("Default Circle Area: " + defaultCircle.getArea());

            System.out.println("Custom Circle Radius: " + customCircle.getRadius());
            System.out.println("Custom Circle Area: " + customCircle.getArea());
        }
    }

