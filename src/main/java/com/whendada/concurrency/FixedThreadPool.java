package com.whendada.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPool {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            executorService.execute(new LiftOff());
        }
        // newFixedThreadPool只会创建有限个线程来执行任务，如果任务数量超过了线程数量，超出部分无法执行
//        for (int i = 0; i < 5; i++) {
//            executorService.execute(new LiftOff());
//        }
//        executorService.execute(new LiftOff());
        executorService.shutdown();
    }
}
