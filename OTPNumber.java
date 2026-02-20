package com.gla.methods.Level3;


import java.util.Random;

public class OTPNumber {

    // Method to generate a 6-digit OTP
    public static int generateOTP() {
        // Math.random() generates 0.0 <= value < 1.0
        // Multiply by 900000 and add 100000 to ensure 100000 to 999999
        int otp = (int)(Math.random() * 900000) + 100000;
        return otp;
    }

    // Method to check if all OTPs in the array are unique
    public static boolean areOTPsUnique(int[] otps) {
        for (int i = 0; i < otps.length; i++) {
            for (int j = i + 1; j < otps.length; j++) {
                if (otps[i] == otps[j]) {
                    return false; // Duplicate found
                }
            }
        }
        return true; // All OTPs are unique
    }

    public static void main(String[] args) {
        int[] otpArray = new int[10];

        // Generate 10 OTPs
        for (int i = 0; i < otpArray.length; i++) {
            otpArray[i] = generateOTP();
        }

        // Display OTPs
        System.out.println("Generated OTPs:");
        for (int otp : otpArray) {
            System.out.println(otp);
        }

        // Check uniqueness
        if (areOTPsUnique(otpArray)) {
            System.out.println("\nAll OTPs are unique.");
        } else {
            System.out.println("\nSome OTPs are not unique. Regenerate required.");
        }
    }
}



