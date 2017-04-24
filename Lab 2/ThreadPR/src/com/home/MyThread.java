package com.home;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class MyThread extends Thread {
    private List<CountDownLatch> nextThreads = Collections.emptyList();
    private List<CountDownLatch> prevThreads = Collections.emptyList();

    @Override
    public void run() {

        if(prevThreads != null) {
            try {
                for(CountDownLatch latch : prevThreads)
                    latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(Thread.currentThread().getName() + " has started executing.");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + " has finished executing.");
        if (nextThreads != null) {
            for(CountDownLatch latch : nextThreads)
                latch.countDown();
        }
    }

    MyThread(String name, CountDownLatch[] prev, CountDownLatch[] next) {
        super.setName(name);
        if(prev != null) prevThreads = Arrays.asList(prev);
        if(next != null) nextThreads = Arrays.asList(next);
    }
}
