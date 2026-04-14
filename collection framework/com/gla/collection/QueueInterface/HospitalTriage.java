package com.gla.collection.QueueInterface;

import java.util.*;

// Patient class
class Patient {
    String name;
    int severity;

    public Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }

    @Override
    public String toString() {
        return name + "(" + severity + ")";
    }
}

public class HospitalTriage {

    public static void main(String[] args) {

        // Max-heap based on severity
        PriorityQueue<Patient> pq = new PriorityQueue<>(
                (a, b) -> b.severity - a.severity
        );

        // Add patients
        pq.add(new Patient("John", 3));
        pq.add(new Patient("Alice", 5));
        pq.add(new Patient("Bob", 2));

        System.out.println("Treatment Order:");

        while (!pq.isEmpty()) {
            System.out.println(pq.poll().name);
        }
    }
}