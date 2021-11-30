package com.whendada.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadExecutor {

    public static void main(String[] args) {
        // newSingleThreadExecutor将会一直复用一个线程，相当于串行，只有一个任务执行完之后才会执行下一个任务。
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
            executorService.execute(new LiftOff());
        }
        executorService.shutdown();
    }
}
