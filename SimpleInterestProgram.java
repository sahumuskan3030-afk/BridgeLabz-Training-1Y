package com.gla.array.Level1;


    import java.util.Scanner;

    public class SimpleInterestProgram {

        // Method to calculate simple interest
        public static double calculateSimpleInterest(double principal, double rate, double time) {
            return (principal * rate * time) / 100;
        }

        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);

            // Taking user input
            System.out.print("Enter Principal: ");
            double principal = sc.nextDouble();

            System.out.print("Enter Rate of Interest: ");
            double rate = sc.nextDouble();

            System.out.print("Enter Time: ");
            double time = sc.nextDouble();

            // Calling method
            double simpleInterest = calculateSimpleInterest(principal, rate, time);

            // Display output
            System.out.println("The Simple Interest is " + simpleInterest +
                    " for Principal " + principal +
                    ", Rate of Interest " + rate +
                    " and Time " + time);

            sc.close();
        }
    }

