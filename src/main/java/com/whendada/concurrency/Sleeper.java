package com.whendada.concurrency;

public class Sleeper extends Thread {

    private int duration;

    public Sleeper(String name, int sleepTime) {
        super(name);
        duration = sleepTime;
        start();
    }

    @Override
    public void run() {
        try {
            sleep(duration);
        } catch (Exception e) {
            System.out.println(getName() + " was interrupted. " + "isInterrupted(): " + isInterrupted());
            e.printStackTrace();
        }
        System.out.println(getName() + " has awakened");
    }
}
