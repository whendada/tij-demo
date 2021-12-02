package com.whendada.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExceptionThread implements Runnable {

    @Override
    public void run() {
        throw new RuntimeException();
    }

    public static void main(String[] args) {
//        ExecutorService exec = Executors.newCachedThreadPool();
//        exec.execute(new ExceptionThread());

        //run中如果不捕获异常的话最终会抛到main方法里面，main方法就算使用try catch也无法捕获
        try {
            ExecutorService exec = Executors.newCachedThreadPool();
            exec.execute(new ExceptionThread());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
