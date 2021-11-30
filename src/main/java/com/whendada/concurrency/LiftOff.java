package com.whendada.concurrency;

public class LiftOff implements Runnable{

    protected int countDown = 10;
    private static int taskCount = 0;
    private final int id = taskCount++;

    public LiftOff() {}

    public String status() {
        return "#" + id + "(" + (countDown > 0 ? countDown : "LiftOff!") + "),";
    }


    @Override
    public void run() {
        while (countDown-- > 0) {
            System.out.println(status());
            if (countDown == 2) {
                // yield 只是切换一下，并不是终止
                Thread.yield();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        // 验证 Thread.yield(), 这样操作是错的，不是并发执行，还是串行;
        LiftOff liftOff_1 = new LiftOff();
        liftOff_1.run();
        LiftOff liftOff_2 = new LiftOff();
        liftOff_2.run();
    }
}
