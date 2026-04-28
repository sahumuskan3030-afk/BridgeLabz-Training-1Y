package com.logisticsRouter;
abstract class Checkpoint {
    protected String checkpointId;
    protected String locationName;
    protected double distanceFromLast;
    protected int expectedDuration;
    protected int actualDuration;

    public Checkpoint(String id, String location, double distance, int expected, int actual) {
        this.checkpointId = id;
        this.locationName = location;
        this.distanceFromLast = distance;
        this.expectedDuration = expected;
        this.actualDuration = actual;
    }

    public boolean isDelayed() {
        return actualDuration > expectedDuration;
    }

    public abstract boolean isCritical();
    public abstract String getType();
    public abstract double calculatePenalty();

    public String getCheckpointId() {
        return checkpointId;
    }

    public double getDistance() {
        return distanceFromLast;
    }
}
