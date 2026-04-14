package com.gla.collection.Task;
import java.util.*;

class Parcel implements Comparable<Parcel> {
    String deliveryId;
    String customerName;
    int priority; // lower value = higher priority
    String address;

    public Parcel(String deliveryId, String customerName, int priority, String address) {
        this.deliveryId = deliveryId;
        this.customerName = customerName;
        this.priority = priority;
        this.address = address;
    }

    @Override
    public int compareTo(Parcel other) {
        return Integer.compare(this.priority, other.priority);
    }

    @Override
    public String toString() {
        return "Parcel{id=" + deliveryId +
                ", customer=" + customerName +
                ", priority=" + priority +
                ", address=" + address + "}";
    }
}

public class CourierSystem {

    public static void main(String[] args) {

        // 1. Track unique delivery IDs
        Set<String> deliveryIds = new HashSet<>();

        // 2. High-priority queue
        PriorityQueue<Parcel> priorityQueue = new PriorityQueue<>();

        // 3. Normal queue
        Queue<Parcel> normalQueue = new LinkedList<>();

        // 4. Completed deliveries
        List<Parcel> completedDeliveries = new ArrayList<>();

        // -----------------------------
        // Add parcels
        // -----------------------------
        addParcel(deliveryIds, priorityQueue, normalQueue,
                new Parcel("D1", "Alice", 1, "Delhi")); // high priority

        addParcel(deliveryIds, priorityQueue, normalQueue,
                new Parcel("D2", "Bob", 3, "Mumbai"));

        addParcel(deliveryIds, priorityQueue, normalQueue,
                new Parcel("D3", "Charlie", 2, "Pune"));

        addParcel(deliveryIds, priorityQueue, normalQueue,
                new Parcel("D1", "Duplicate", 1, "Chennai")); // duplicate

        System.out.println("\n🚚 Processing Deliveries...\n");

        // -----------------------------
        // Process priority deliveries first
        // -----------------------------
        while (!priorityQueue.isEmpty()) {
            Parcel p = priorityQueue.poll();
            deliver(p, completedDeliveries);
        }

        // -----------------------------
        // Process normal deliveries
        // -----------------------------
        while (!normalQueue.isEmpty()) {
            Parcel p = normalQueue.poll();
            deliver(p, completedDeliveries);
        }

        // -----------------------------
        // Final Report
        // -----------------------------
        System.out.println("\n📦 Completed Deliveries:");
        for (Parcel p : completedDeliveries) {
            System.out.println(p);
        }
    }

    // Add parcel with duplicate check
    public static void addParcel(Set<String> ids,
                                 PriorityQueue<Parcel> priorityQueue,
                                 Queue<Parcel> normalQueue,
                                 Parcel parcel) {

        if (!ids.add(parcel.deliveryId)) {
            System.out.println("Duplicate delivery ID rejected: " + parcel.deliveryId);
            return;
        }

        if (parcel.priority <= 2) {
            priorityQueue.offer(parcel);
            System.out.println("Added to PRIORITY queue: " + parcel);
        } else {
            normalQueue.offer(parcel);
            System.out.println("Added to NORMAL queue: " + parcel);
        }
    }

    // Deliver parcel
    public static void deliver(Parcel parcel, List<Parcel> completed) {
        System.out.println("Delivering: " + parcel);
        completed.add(parcel);
        System.out.println("Delivered successfully.\n");
    }
}
