package com.whendada.concurrency;

import java.util.concurrent.TimeUnit;

public class Daemons {

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new Daemon());
        t.setDaemon(true);
        t.start();
        System.out.println("t.isDaemon() = " + t.isDaemon() + ", ");
        TimeUnit.SECONDS.sleep(1);
    }
}
