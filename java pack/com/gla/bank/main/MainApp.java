package com.gla.bank.main;



import com.gla.bank.util.InterestCalculator;

// Static import (as required)
import static java.lang.Math.*;

    public class MainApp {

        public static void main(String[] args) {

            double P = 10000;  // Principal
            double R = 5;      // Rate
            double T = 2;      // Time

            InterestCalculator calc = new InterestCalculator();

            // Simple Interest
            double si = calc.calculateSimpleInterest(P, R, T);

            // Compound Interest using static import pow()
            double ci = P * (pow((1 + R / 100), T)) - P;

            // Display results
            System.out.println("Principal: " + P);
            System.out.println("Rate: " + R);
            System.out.println("Time: " + T);

            System.out.println("\nSimple Interest: " + si);
            System.out.println("Compound Interest: " + ci);
        }
    }

