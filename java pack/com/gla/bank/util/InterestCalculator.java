package com.gla.bank.util;



    public class InterestCalculator {

        // Simple Interest
        public double calculateSimpleInterest(double P, double R, double T) {
            return (P * R * T) / 100;
        }

        // Compound Interest
        public double calculateCompoundInterest(double P, double R, double T) {
            // pow() will be used in main via static import
            return P * (Math.pow((1 + R / 100), T)) - P;
        }
    }

