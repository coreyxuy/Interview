package com.itcorey.interview.thread;

import javax.xml.stream.XMLOutputFactory;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Auther: corey
 * @Date: 2020/10/23 16:35
 * @Description: CountDownLatch 测试
 * CountDownLatch 适用于在多个线程的场景需要等待所有子线程全部执行完毕后再来操作
 */
public class CountDownLatchTest {
    private static int num = 3;
    private static CountDownLatch countDownLatch = new CountDownLatch(num);
    private static ExecutorService executorService = Executors.newFixedThreadPool(num);

    public static void main(String[] args) throws InterruptedException {
        executorService.submit(() -> {
            System.out.println("A 在写作业。。。");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                countDownLatch.countDown();
                System.out.println("A 写完作业了。。。。");
            }
        });
        executorService.submit(() -> {
            System.out.println("B 在上厕所。。。");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                countDownLatch.countDown();
                System.out.println("B 上完厕所了。。。");
            }
        });
        executorService.submit(() -> {
            System.out.println("C 在打王者。。。");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                countDownLatch.countDown();
                System.out.println("C 打完 游戏了。。。");
            }
        });

        System.out.println("等待所有人从厕所回来开会...");
        countDownLatch.await();
        System.out.println("所有人都好了，开始开会...");
        executorService.shutdown();
    }


}
