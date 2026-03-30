package com.gla.javainheritance;

// Interface
interface MedicalRecord {
    void addRecord(String record);
    void viewRecords();
}

// Abstract class
abstract class Patient {
    private int patientId;
    private String name;
    private int age;

    // Constructor
    public Patient(int patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    // Encapsulation: Getters
    public int getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // Abstract method
    public abstract double calculateBill();

    // Concrete method
    public void getPatientDetails() {
        System.out.println("Patient ID: " + patientId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

// InPatient class
class InPatient extends Patient implements MedicalRecord {
    private int daysAdmitted;
    private double dailyCharge;
    private String medicalHistory = ""; // encapsulated

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
        medicalHistory += record + "\n";
    }

    @Override
    public void viewRecords() {
        System.out.println("Medical History:\n" + medicalHistory);
    }
}

// OutPatient class
class OutPatient extends Patient implements MedicalRecord {
    private double consultationFee;
    private String medicalHistory = "";

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
        medicalHistory += record + "\n";
    }

    @Override
    public void viewRecords() {
        System.out.println("Medical History:\n" + medicalHistory);
    }
}

// Main class
public class Hospital {

    public static void processPatient(Patient p) {
        p.getPatientDetails();

        double bill = p.calculateBill();
        System.out.println("Total Bill: " + bill);

        if (p instanceof MedicalRecord) {
            MedicalRecord m = (MedicalRecord) p;
            m.viewRecords();
        }

        System.out.println("------------------------");
    }

    public static void main(String[] args) {

        Patient p1 = new InPatient(101, "Rahul", 30, 5, 2000);
        Patient p2 = new OutPatient(102, "Anita", 25, 500);

        // Add medical records
        ((MedicalRecord) p1).addRecord("Fever treatment");
        ((MedicalRecord) p1).addRecord("Blood test done");

        ((MedicalRecord) p2).addRecord("General checkup");

        Patient[] patients = {p1, p2};

        // Polymorphism
        for (Patient p : patients) {
            processPatient(p);
        }
    }
}
