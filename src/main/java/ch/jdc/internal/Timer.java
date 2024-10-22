package ch.jdc.internal;

public class Timer {
    private long startTime;
    private long endTime;

    private Timer() {}

    public static Timer of() {
        return new Timer();
    }

    public void start() {
        this.reset();
        startTime = System.nanoTime();
    }

    public void stop() {
        endTime = System.nanoTime();
    }

    public long getElapsedTimeInNano() {
        return endTime - startTime;
    }

    public long getElapsedTimeInMillis() {
        return (endTime - startTime) / 1_000_000;
    }

    public void reset() {
        startTime = 0;
        endTime = 0;
    }
}

