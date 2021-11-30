package com.whendada.concurrency;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.concurrent.*;

public class TaskWithResult implements Callable<String> {
    private int id;

    public TaskWithResult(int id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        return "result of TaskWithResult " + id;
    }

    // 使用Callable在任务完成后可以返回一个结果，任务的执行在call()里面，
    // 利用newCachedThreadPool.submit()调用后，将返回Future，Future是什么？
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        List<Future<String>> results = Lists.newArrayList();
        for (int i = 0; i < 10; i++) {
            results.add(exec.submit(new TaskWithResult(i)));
        }
        for (Future<String> future : results) {
            try {
                System.out.println(future.get());
            } catch (ExecutionException | InterruptedException e) {
                e.printStackTrace();
                return;
            } finally {
                exec.shutdown();
            }
        }
    }

}
