package com.whendada.concurrency;

public class MoreBasicThread {

    public static void main(String[] args) throws InterruptedException {
        //通过这里验证了Thread实际上是main里面启动的另外的线程，这里与main线程是异步执行的
        // 并且在for循环里面，thread初始化完成之后执行也是异步的
        for(int i = 0; i < 5; i++) {
            Thread thread = new Thread(new LiftOff());
            thread.start();
        }
        Thread.sleep(1000);
        System.out.println("Waiting for LiftOff");
    }
}
