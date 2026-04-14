package com.gla.collection.Task;
import java.util.Objects;
import java.util.*;
class RideRequest implements Comparable<RideRequest> {
    int requestId;
    String passengerName;
    int priority; // lower value = higher priority (e.g., emergency or closer distance)

    public RideRequest(int requestId, String passengerName, int priority) {
        this.requestId = requestId;
        this.passengerName = passengerName;
        this.priority = priority;
    }

    @Override
    public int compareTo(RideRequest other) {
        return Integer.compare(this.priority, other.priority);
    }

    @Override
    public String toString() {
        return "Request{id=" + requestId + ", passenger=" + passengerName + ", priority=" + priority + "}";
    }
}


class Driver {
    int driverId;
    String name;

    public Driver(int driverId, String name) {
        this.driverId = driverId;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Driver)) return false;
        Driver d = (Driver) o;
        return driverId == d.driverId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(driverId);
    }

    @Override
    public String toString() {
        return "Driver{id=" + driverId + ", name=" + name + "}";
    }
}
class Ride {
    RideRequest request;
    Driver driver;

    public Ride(RideRequest request, Driver driver) {
        this.request = request;
        this.driver = driver;
    }

    @Override
    public String toString() {
        return "Ride{" + request + ", driver=" + driver + "}";
    }
}


public class RideSharingSystem {

    public static void main(String[] args) {

        // 1. Incoming ride requests
        Queue<RideRequest> requestQueue = new LinkedList<>();
        PriorityQueue<RideRequest> priorityQueue = new PriorityQueue<>();

        requestQueue.offer(new RideRequest(1, "Alice", 3));
        requestQueue.offer(new RideRequest(2, "Bob", 1));   // high priority
        requestQueue.offer(new RideRequest(3, "Charlie", 2));

        // Move to priority queue
        priorityQueue.addAll(requestQueue);

        // 2. Available drivers
        Set<Driver> availableDrivers = new HashSet<>();
        availableDrivers.add(new Driver(101, "John"));
        availableDrivers.add(new Driver(102, "Mike"));
        availableDrivers.add(new Driver(101, "Duplicate John")); // ignored

        // 3. Completed rides
        List<Ride> completedRides = new ArrayList<>();

        System.out.println("Dispatching rides...\n");

        // 4. Assign rides based on priority
        Iterator<Driver> driverIterator = availableDrivers.iterator();

        while (!priorityQueue.isEmpty() && driverIterator.hasNext()) {

            RideRequest request = priorityQueue.poll(); // highest priority first
            Driver driver = driverIterator.next();

            System.out.println("Assigning " + driver + " to " + request);

            Ride ride = new Ride(request, driver);

            // Simulate ride completion
            System.out.println("Ride completed.\n");
            completedRides.add(ride);
        }

        // Display completed rides
        System.out.println("Completed Rides:");
        for (Ride ride : completedRides) {
            System.out.println(ride);
        }
    }
}
