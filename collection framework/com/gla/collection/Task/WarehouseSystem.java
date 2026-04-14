package com.gla.collection.Task;
import java.util.*;
class Package {
    String packageId;
    String customerName;
    String address;

    public Package(String packageId, String customerName, String address) {
        this.packageId = packageId;
        this.customerName = customerName;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Package{id=" + packageId + ", customer=" + customerName + ", address=" + address + "}";
    }
}


public class WarehouseSystem {

    public static void main(String[] args) {

        // 1. Unique package IDs
        Set<String> packageIds = new HashSet<>();

        // 2. Pending deliveries
        Queue<Package> deliveryQueue = new LinkedList<>();

        // 3. Delivered packages
        List<Package> deliveredList = new ArrayList<>();

        // 4. Returned/cancelled packages
        Stack<Package> returnedStack = new Stack<>();

        // Add packages
        addPackage(packageIds, deliveryQueue, new Package("P1", "Alice", "Delhi"));
        addPackage(packageIds, deliveryQueue, new Package("P2", "Bob", "Mumbai"));
        addPackage(packageIds, deliveryQueue, new Package("P1", "Duplicate", "Chennai")); // duplicate

        System.out.println("\nProcessing Deliveries...\n");

        Random random = new Random();

        // Process deliveries
        while (!deliveryQueue.isEmpty()) {
            Package pkg = deliveryQueue.poll();
            System.out.println("Delivering: " + pkg);

            // Simulate delivery success/failure
            if (random.nextBoolean()) {
                System.out.println("Delivered successfully.");
                deliveredList.add(pkg);
            } else {
                System.out.println("Delivery failed. Marked as returned.");
                returnedStack.push(pkg);
            }
        }

        // Summary
        System.out.println("\nDelivered Packages:");
        for (Package p : deliveredList) {
            System.out.println(p);
        }

        System.out.println("\nReturned Packages:");
        while (!returnedStack.isEmpty()) {
            System.out.println(returnedStack.pop());
        }
    }

    // Add package with duplicate check
    public static void addPackage(Set<String> ids, Queue<Package> queue, Package pkg) {
        if (ids.add(pkg.packageId)) {
            queue.offer(pkg);
            System.out.println("Added: " + pkg);
        } else {
            System.out.println("Duplicate package rejected: " + pkg.packageId);
        }
    }
}
