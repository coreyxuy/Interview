package com.itcorey.interview.jstack;

/**
 * @Auther: corey
 * @Date: 2020/8/5 17:02
 * @Description:
 */
public class Method {
    public static void main(String[] args) {
        String add = "null";
        if (add == null)
            throw new IllegalThreadStateException();
        System.out.println("112345678");
    }
}
