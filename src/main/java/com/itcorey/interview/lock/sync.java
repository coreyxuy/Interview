package com.itcorey.interview.lock;

/**
 * @Auther: corey
 * @Date: 2020/7/20 10:58
 * @Description: 测试死锁
 */
public class sync {

    public static void main(String[] args) {
        Object a = new Object();
        Object b = new Object();

        new Thread(() -> {
            synchronized (a) {
                System.out.println(Thread.currentThread().getName()+"我获取到了 a");
                try {
                    Thread.sleep(200000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "我想获取 b");
                synchronized (b){
                    System.out.println( "我获取到了b");
                }
            }
        }).start();


    }

}
