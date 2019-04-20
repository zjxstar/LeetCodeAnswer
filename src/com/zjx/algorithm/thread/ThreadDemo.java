package com.zjx.algorithm.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadDemo {

    private Lock lock = new ReentrantLock();

    public void method(Thread thread) {
//        lock.lock();
        if (lock.tryLock()) {
            try {
                System.out.println("线程名："+thread.getName() + "获得了锁");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                System.out.println("线程名："+thread.getName() + "释放了锁");
                lock.unlock();
            }
        }

    }

}
