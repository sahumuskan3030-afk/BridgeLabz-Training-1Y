package com.gla.multithreading;

import java.util.*;

class Ticket extends Thread {
    private int ticketId;
    private String type;
    private int priority;
    private int queuePosition;
    private long waitTime;

    public Ticket(int ticketId, String type, int priority, int queuePosition) {
        this.ticketId = ticketId;
        this.type = type;
        this.priority = priority;
        this.queuePosition = queuePosition;
    }

    public int getPriorityLevel() {
        return priority;
    }

    public long getWaitTime() {
        return waitTime;
    }

    @Override
    public void run() {
        try {
            long start = System.currentTimeMillis();

            System.out.println("Ticket #" + ticketId +
                    " | Type: " + type +
                    " | Priority: " + priority +
                    " | Queue Position: " + queuePosition +
                    " | Agent: " + Thread.currentThread().getName() +
                    " → Processing STARTED");

            // Random processing time (1–5 sec)
            int processTime = new Random().nextInt(5) + 1;
            Thread.sleep(processTime * 1000);

            long end = System.currentTimeMillis();
            waitTime = (end - start) / 1000;

            System.out.println("Ticket #" + ticketId +
                    " | Agent: " + Thread.currentThread().getName() +
                    " → COMPLETED in " + waitTime + " sec\n");

        } catch (InterruptedException e) {
            System.out.println("Ticket #" + ticketId + " interrupted.");
        }
    }
}

public class TicketSystem {
    public static void main(String[] args) {

        // Ticket types
        String[] types = {
                "Critical Bug", "Feature Request",
                "General Query", "Feedback"
        };

        int[] priorities = {10, 4, 2, 1};

        List<Ticket> tickets = new ArrayList<>();

        // Create 10 tickets (mixed types)
        Random rand = new Random();
        for (int i = 1; i <= 10; i++) {
            int index = rand.nextInt(types.length);
            tickets.add(new Ticket(i, types[index], priorities[index], i));
        }

        // Sort tickets by priority (higher first)
        tickets.sort((t1, t2) -> t2.getPriorityLevel() - t1.getPriorityLevel());

        System.out.println("=== Ticket Processing Order (by Priority) ===");
        for (int i = 0; i < tickets.size(); i++) {
            System.out.println("Position " + (i + 1) +
                    " → Ticket #" + (i + 1));
        }

        long totalStart = System.currentTimeMillis();

        // Start threads
        for (int i = 0; i < tickets.size(); i++) {
            Ticket t = tickets.get(i);
            t.setName("Agent-" + (i + 1));
            t.setPriority(t.getPriorityLevel());
            t.start();
        }

        // Wait for all to finish
        for (Ticket t : tickets) {
            try {
                t.join();
            } catch (InterruptedException e) {
                System.out.println("Main interrupted.");
            }
        }

        long totalEnd = System.currentTimeMillis();

        // Statistics
        Map<Integer, List<Long>> stats = new HashMap<>();

        for (Ticket t : tickets) {
            stats.putIfAbsent(t.getPriorityLevel(), new ArrayList<>());
            stats.get(t.getPriorityLevel()).add(t.getWaitTime());
        }

        System.out.println("\n=== Statistics ===");
        for (int p : stats.keySet()) {
            List<Long> times = stats.get(p);
            double avg = times.stream().mapToLong(Long::longValue).average().orElse(0);
            System.out.println("Priority " + p +
                    " → Avg Processing Time: " + avg + " sec");
        }

        System.out.println("\nTotal Processing Time: " +
                (totalEnd - totalStart) / 1000.0 + " sec");
    }
}
