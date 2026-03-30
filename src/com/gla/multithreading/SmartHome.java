package com.gla.multithreading;

import java.time.LocalTime;

class Device implements Runnable {
    private String deviceName;
    private int interval;

    public Device(String deviceName, int interval) {
        this.deviceName = deviceName;
        this.interval = interval;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 5; i++) {
                System.out.println(
                        "[" + LocalTime.now() + "] " +
                                deviceName + " | Thread: " +
                                Thread.currentThread().getName() +
                                " | Priority: " +
                                Thread.currentThread().getPriority() +
                                " | Cycle: " + i
                );

                Thread.sleep(interval * 1000); // interval in seconds
            }
        } catch (InterruptedException e) {
            System.out.println(deviceName + " interrupted.");
        }
    }
}

public class SmartHome {
    public static void main(String[] args) {

        // Create devices
        Device tempSensor = new Device("Temperature Sensor", 5);
        Device securityCamera = new Device("Security Camera", 3);
        Device lightController = new Device("Light Controller", 4);
        Device doorLock = new Device("Door Lock Monitor", 6);

        // Create threads
        Thread t1 = new Thread(tempSensor, "Temp-Thread");
        Thread t2 = new Thread(securityCamera, "Security-Thread");
        Thread t3 = new Thread(lightController, "Light-Thread");
        Thread t4 = new Thread(doorLock, "Door-Thread");

        // Set priorities
        t2.setPriority(10); // Security
        t1.setPriority(7);  // Temperature
        t3.setPriority(5);  // Light
        t4.setPriority(5);  // Door

        // Start all threads
        t1.start();
        t2.start();
        t3.start();
        t4.start();

        // Wait for all threads to finish
        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }

        System.out.println("\nAll devices completed execution. Smart Home shutting down.");
    }
}
