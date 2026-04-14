package com.gla.collection.Task;
import java.util.*;
import java.util.Objects;

class Patient {
    int patientId;
    String name;
    String illness;

    public Patient(int patientId, String name, String illness) {
        this.patientId = patientId;
        this.name = name;
        this.illness = illness;
    }

    // For uniqueness in Set
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Patient)) return false;
        Patient p = (Patient) o;
        return patientId == p.patientId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(patientId);
    }

    @Override
    public String toString() {
        return "Patient{id=" + patientId + ", name=" + name + ", illness=" + illness + "}";
    }
}


public class HospitalSystem {

    public static void main(String[] args) {

        // 1. Admitted patients
        Set<Patient> admittedPatients = new HashSet<>();

        // 2. Waiting queue
        Queue<Patient> treatmentQueue = new LinkedList<>();

        // 3. Discharged stack
        Stack<Patient> dischargedStack = new Stack<>();

        // 4. Patient history
        List<Patient> patientHistory = new ArrayList<>();

        // Admit patients
        admitPatient(admittedPatients, treatmentQueue, patientHistory,
                new Patient(1, "Alice", "Fever"));
        admitPatient(admittedPatients, treatmentQueue, patientHistory,
                new Patient(2, "Bob", "Injury"));
        admitPatient(admittedPatients, treatmentQueue, patientHistory,
                new Patient(1, "Duplicate Alice", "Cold")); // duplicate

        System.out.println("\nTreating Patients...\n");

        // Treat patients
        while (!treatmentQueue.isEmpty()) {
            Patient p = treatmentQueue.poll();
            System.out.println("Treating: " + p);

            // After treatment → discharge
            dischargePatient(admittedPatients, dischargedStack, p);
        }

        // Re-admit last discharged patient
        System.out.println("\nRe-admitting last discharged patient...");
        if (!dischargedStack.isEmpty()) {
            Patient p = dischargedStack.pop();
            admitPatient(admittedPatients, treatmentQueue, patientHistory, p);
        }

        // Final status
        System.out.println("\nCurrently Admitted Patients:");
        for (Patient p : admittedPatients) {
            System.out.println(p);
        }

        System.out.println("\nPatient History:");
        for (Patient p : patientHistory) {
            System.out.println(p);
        }
    }

    // Admit patient
    public static void admitPatient(Set<Patient> admitted,
                                    Queue<Patient> queue,
                                    List<Patient> history,
                                    Patient p) {

        if (admitted.add(p)) {
            queue.offer(p);
            history.add(p);
            System.out.println("Admitted: " + p);
        } else {
            System.out.println("Duplicate patient not admitted: " + p);
        }
    }

    // Discharge patient
    public static void dischargePatient(Set<Patient> admitted,
                                        Stack<Patient> stack,
                                        Patient p) {

        admitted.remove(p);
        stack.push(p);
        System.out.println("Discharged: " + p);
    }
}
