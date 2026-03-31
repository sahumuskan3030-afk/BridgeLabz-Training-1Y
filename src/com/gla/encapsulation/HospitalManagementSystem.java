package com.gla.encapsulation;

import java.util.*;

public class HospitalManagementSystem {

    // Interface
    interface MedicalRecord {
        void addRecord(String record);
        void viewRecords();
    }

    // Abstract Class
    static abstract class Patient {
        private int patientId;
        private String name;
        private int age;

        public Patient(int patientId, String name, int age) {
            this.patientId = patientId;
            this.name = name;
            this.age = age;
        }

        // Abstract method
        public abstract double calculateBill();

        // Concrete method
        public void getPatientDetails() {
            System.out.println("Patient ID: " + patientId);
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
        }

        // Encapsulation (Getters only)
        public int getPatientId() {
            return patientId;
        }

        public String getName() {
            return name;
        }
    }

    // InPatient Class
    static class InPatient extends Patient implements MedicalRecord {
        private int daysAdmitted;
        private double dailyCharge;
        private List<String> records = new ArrayList<>(); // Encapsulated

        public InPatient(int id, String name, int age, int days, double charge) {
            super(id, name, age);
            this.daysAdmitted = days;
            this.dailyCharge = charge;
        }

        @Override
        public double calculateBill() {
            return daysAdmitted * dailyCharge;
        }

        @Override
        public void addRecord(String record) {
            records.add(record);
        }

        @Override
        public void viewRecords() {
            System.out.println("Medical Records:");
            for (String r : records) {
                System.out.println("- " + r);
            }
        }
    }

    // OutPatient Class
    static class OutPatient extends Patient implements MedicalRecord {
        private double consultationFee;
        private List<String> records = new ArrayList<>();

        public OutPatient(int id, String name, int age, double fee) {
            super(id, name, age);
            this.consultationFee = fee;
        }

        @Override
        public double calculateBill() {
            return consultationFee;
        }

        @Override
        public void addRecord(String record) {
            records.add(record);
        }

        @Override
        public void viewRecords() {
            System.out.println("Medical Records:");
            for (String r : records) {
                System.out.println("- " + r);
            }
        }
    }

    // Polymorphism Method
    public static void processPatients(List<Patient> patients) {
        for (Patient p : patients) {
            p.getPatientDetails();

            double bill = p.calculateBill(); // Polymorphism
            System.out.println("Total Bill: " + bill);

            if (p instanceof MedicalRecord) {
                MedicalRecord mr = (MedicalRecord) p;
                mr.addRecord("General Checkup Completed");
                mr.viewRecords();
            }

            System.out.println("---------------------------");
        }
    }

    // Main Method
    public static void main(String[] args) {
        List<Patient> patients = new ArrayList<>();

        InPatient p1 = new InPatient(1, "Alice", 30, 5, 2000);
        OutPatient p2 = new OutPatient(2, "Bob", 25, 500);

        patients.add(p1);
        patients.add(p2);

        processPatients(patients);
    }
}
