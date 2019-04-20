package com.zjx.algorithm.thread;

import java.util.LinkedHashMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadProblem {

    private int n = 1;
    private final Object lock = new Object();

    /**
     * 两个线程交替打印奇偶数
     * 使用synchronized加对象锁
     */
    public void printNumByTwoThread() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (n <= 100) {
                    synchronized (lock) {

                        System.out.println(Thread.currentThread().getName() + " : " + n);
                        n++;
                        lock.notifyAll();
                        try {
                            if (n <= 100) {
                                lock.wait();
                            }
                        } catch (Exception e) {

                        }

                    }
                }
            }
        }, "t1").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (n <= 100) {
                    synchronized (lock) {

                        System.out.println(Thread.currentThread().getName() + " : " + n);
                        n++;

                        lock.notifyAll();
                        try {
                            if (n <= 100) {
                                lock.wait();
                            }
                        } catch (Exception e) {

                        }
                    }

                }

            }
        }, "t2").start();
    }


    ReentrantLock reentrantLock = new ReentrantLock();
    Condition c1 = reentrantLock.newCondition();
    Condition c2 = reentrantLock.newCondition();
    Condition c3 = reentrantLock.newCondition();
    int count = 1;

    /**
     * 使用可重入锁
     */
    public void printCount() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (count <= 100) {
                    reentrantLock.lock();
                    try {
                        System.out.println(Thread.currentThread().getName() + " : " + count++);
                        c1.await();
                        c2.signal();
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        reentrantLock.unlock();
                    }

                }
            }
        }, "t1");

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (count <= 100) {
                    reentrantLock.lock();
                    try {
                        System.out.println(Thread.currentThread().getName() + " : " + count++);
//                        c1.signal();
//                        c2.await();
                        c2.await();
                        c3.signal();
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        reentrantLock.unlock();
                    }

                }
            }
        }, "t2");

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (count <= 100) {
                    reentrantLock.lock();
                    try {
                        System.out.println(Thread.currentThread().getName() + " : " + count++);
                        c1.signal();
                        c3.await();
                    } catch (Exception e) {

                    } finally {
                        reentrantLock.unlock();
                    }
                }
            }
        }, "t3");

        t1.start();
        while (count == 1) {
        }
        t2.start();
        try {
            Thread.sleep(100);
        } catch (Exception e) {
            e.printStackTrace();
        }

        t3.start();

    }
}
