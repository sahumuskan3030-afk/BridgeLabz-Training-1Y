package com.gla.array.Level1;


    import java.util.Scanner;

    public class HandshakeProgram {

        // Method to calculate maximum handshakes
        public static int calculateHandshakes(int numberOfStudents) {
            return (numberOfStudents * (numberOfStudents - 1)) / 2;
        }

        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);

            // Taking input
            System.out.print("Enter number of students: ");
            int numberOfStudents = sc.nextInt();

            // Calling method
            int handshakes = calculateHandshakes(numberOfStudents);

            // Display result
            System.out.println("Maximum number of possible handshakes: " + handshakes);

            sc.close();
        }
    }

