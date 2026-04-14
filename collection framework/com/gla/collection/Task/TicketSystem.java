package com.gla.collection.Task;

import java.util.*;
class Booking implements Comparable<Booking> {
    int bookingId;
    String userId;
    boolean isVIP;

    public Booking(int bookingId, String userId, boolean isVIP) {
        this.bookingId = bookingId;
        this.userId = userId;
        this.isVIP = isVIP;
    }

    @Override
    public int compareTo(Booking other) {
        // VIP users get higher priority
        if (this.isVIP && !other.isVIP) return -1;
        if (!this.isVIP && other.isVIP) return 1;
        return Integer.compare(this.bookingId, other.bookingId); // fallback
    }

    @Override
    public String toString() {
        return "Booking{id=" + bookingId + ", user=" + userId + ", VIP=" + isVIP + "}";
    }
}


public class TicketSystem {

    public static void main(String[] args) {

        // 1. Registered users
        Set<String> users = new HashSet<>();

        // 2. Booking queues
        Queue<Booking> normalQueue = new LinkedList<>();
        PriorityQueue<Booking> vipQueue = new PriorityQueue<>();

        // 3. Confirmed bookings
        List<Booking> confirmedBookings = new ArrayList<>();

        // Register users
        registerUser(users, "U1");
        registerUser(users, "U2");
        registerUser(users, "U1"); // duplicate

        // Add booking requests
        addBooking(users, normalQueue, vipQueue, new Booking(101, "U1", false));
        addBooking(users, normalQueue, vipQueue, new Booking(102, "U2", true));
        addBooking(users, normalQueue, vipQueue, new Booking(103, "U3", true)); // not registered

        System.out.println("\nProcessing Bookings...\n");

        // 3. Process VIP bookings first
        while (!vipQueue.isEmpty()) {
            Booking b = vipQueue.poll();
            System.out.println("Confirming VIP booking: " + b);
            confirmedBookings.add(b);
        }

        // Then process normal bookings
        while (!normalQueue.isEmpty()) {
            Booking b = normalQueue.poll();
            System.out.println("Confirming normal booking: " + b);
            confirmedBookings.add(b);
        }

        // 4. Display all confirmed bookings
        System.out.println("\nConfirmed Bookings:");
        for (Booking b : confirmedBookings) {
            System.out.println(b);
        }
    }

    // Register user
    public static void registerUser(Set<String> users, String userId) {
        if (users.add(userId)) {
            System.out.println("User registered: " + userId);
        } else {
            System.out.println("Duplicate user rejected: " + userId);
        }
    }

    // Add booking request
    public static void addBooking(Set<String> users,
                                  Queue<Booking> normalQueue,
                                  PriorityQueue<Booking> vipQueue,
                                  Booking booking) {

        if (!users.contains(booking.userId)) {
            System.out.println("User not registered: " + booking.userId);
            return;
        }

        if (booking.isVIP) {
            vipQueue.offer(booking);
            System.out.println("VIP booking added: " + booking);
        } else {
            normalQueue.offer(booking);
            System.out.println("Normal booking added: " + booking);
        }
    }
}