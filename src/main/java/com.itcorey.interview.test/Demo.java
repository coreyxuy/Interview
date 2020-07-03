package com.itcorey.interview.test;

/**
 * @Auther: corey
 * @Date: 2020/6/29 17:35
 * @Description:
 */
public class Demo {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        for (int i = 0 ; i<=5 ;i++){
            Thread t = new Thread(new MyThread());
            t.start();
        }
    }

    static class MyThread implements Runnable {
        @Override
        public void run() {
            System.out.println("=====" + Thread.currentThread().getName());
        }
    }
}
