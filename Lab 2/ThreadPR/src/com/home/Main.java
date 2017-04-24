package com.home;

import java.util.concurrent.CountDownLatch;

public class Main {

    public static void main(String[] args) {
        CountDownLatch timer1 = new CountDownLatch(3);
        CountDownLatch timer2 = new CountDownLatch(3);

        new MyThread("Thread 1", null, new CountDownLatch[]{timer1}).start();
        new MyThread("Thread 2", null, new CountDownLatch[]{timer1, timer2}).start();
        new MyThread("Thread 3", null, new CountDownLatch[]{timer1, timer2}).start();
        new MyThread("Thread 4", null, new CountDownLatch[]{timer2}).start();
        new MyThread("Thread 5", new CountDownLatch[]{timer1}, null).start();
        new MyThread("Thread 6", new CountDownLatch[]{timer2}, null).start();
    }
}

