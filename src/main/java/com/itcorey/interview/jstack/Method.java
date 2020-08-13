package com.itcorey.interview.jstack;

/**
 * @Auther: corey
 * @Date: 2020/8/5 17:02
 * @Description:
 */
public class Method {
    public static void main(String[] args) {
        Integer i1 = 100;
        Integer i2 = 100;
        Integer i3 = 200;
        Integer i4 = 200;

        System.out.println(i1 == i2);
        System.out.println(i3 == i4);
    }
}
