package com.itcorey.interview.jstack;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @Auther: corey
 * @Date: 2020/8/5 15:01
 * @Description:死锁线程的定位
 */
public class JstackLockTest {

    private static Executor executor = Executors.newFixedThreadPool(5);

    private static final Object lockA = new Object();

    private static final Object lockB = new Object();

    public static void main(String[] args) {
        MyRunnableImplOne th1 = new MyRunnableImplOne();
        MyRunnableImplTwo th2 = new MyRunnableImplTwo();

        executor.execute(th1);
        executor.execute(th2);
    }

    static class MyRunnableImplOne implements Runnable {

        @Override
        public void run() {
            synchronized (lockA) {
                System.out.println(Thread.currentThread().getName() + "获得了锁LockA");
                //循环
                int i = 10;
                while (i > 10) {
                    i--;
                }
                synchronized (lockB) {
                    System.out.println(Thread.currentThread().getName() + "获得了锁B");
                }
            }
        }
    }

    static class MyRunnableImplTwo implements Runnable {
        @Override
        public void run() {
            synchronized (lockB) {
                System.out.println(Thread.currentThread().getName()+"获得了锁lockB");
                int i = 10;
                while (i > 10) {
                    i--;
                }
                synchronized (lockA) {
                    System.out.println(Thread.currentThread().getName()+"获得了锁lockA");
                }
            }
        }
    }
}
