package com.whendada.concurrency;

public class BasicThread {

    public static void main(String[] args) {
        // 在Thread构造器里面传入一个Runnable对象（多态实现），调用Thread.start()方法初始化，然后会调用
        // Runnable.run()启动任务
        Thread t = new Thread(new LiftOff());
        t.start();
        System.out.println("Waiting for LiftOff");
    }
}
