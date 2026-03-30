package com.gla.multithreading;

class ExamActivity extends Thread {
    private String activityName;
    private int startDelay; // in milliseconds
    private int cycles;

    public ExamActivity(String activityName, int startDelay, int cycles) {
        this.activityName = activityName;
        this.startDelay = startDelay;
        this.cycles = cycles;
    }

    @Override
    public void run() {
        try {
            System.out.println(activityName + " | State: " + Thread.currentThread().getState());

            // Initial delay before starting activity
            Thread.sleep(startDelay);

            for (int i = 1; i <= cycles; i++) {
                System.out.println(activityName +
                        " | Cycle: " + i +
                        " | State: " + Thread.currentThread().getState());

                Thread.sleep(2000); // simulate work
            }

            System.out.println(activityName + " completed.");

        } catch (InterruptedException e) {
            System.out.println(activityName + " interrupted.");
        }
    }
}

public class ExamHallManagement {
    public static void main(String[] args) {

        // Create threads
        ExamActivity entry = new ExamActivity("Student Entry Monitoring", 0, 5);
        ExamActivity questionPaper = new ExamActivity("Question Paper Distribution", 5000, 3);
        ExamActivity attendance = new ExamActivity("Attendance Marking", 10000, 3);
        ExamActivity collection = new ExamActivity("Answer Sheet Collection", 15000, 3);

        // Set thread priorities
        questionPaper.setPriority(10); // highest
        attendance.setPriority(8);
        collection.setPriority(7);
        entry.setPriority(5);

        // Display initial states (NEW)
        System.out.println("Initial Thread States:");
        System.out.println("Entry: " + entry.getState());
        System.out.println("Question Paper: " + questionPaper.getState());
        System.out.println("Attendance: " + attendance.getState());
        System.out.println("Collection: " + collection.getState());

        // Start threads
        entry.start();
        questionPaper.start();
        attendance.start();
        collection.start();

        // Monitor thread states
        try {
            while (entry.isAlive() || questionPaper.isAlive() ||
                    attendance.isAlive() || collection.isAlive()) {

                System.out.println("\n--- Thread States ---");
                System.out.println("Entry: " + entry.getState());
                System.out.println("Question Paper: " + questionPaper.getState());
                System.out.println("Attendance: " + attendance.getState());
                System.out.println("Collection: " + collection.getState());

                Thread.sleep(3000);
            }

            // Ensure completion
            entry.join();
            questionPaper.join();
            attendance.join();
            collection.join();

        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }

        System.out.println("\nAll exam hall activities completed successfully.");
    }
}
