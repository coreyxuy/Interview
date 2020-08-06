package com.itcorey.interview.utils;

import java.math.BigDecimal;

/**
 * @Auther: corey
 * @Date: 2020/7/28 11:05
 * @Description:
 */
public class FloatTest{
    public static void main(String[] args) {
        float a = 1.0f - 0.9f;

        float b = 0.9f - 0.8f;

        System.out.println("----"+a);
        System.out.println("----"+b);

        System.out.println(a == b);

        System.out.println("=======================================");

        BigDecimal aa = new BigDecimal("1.0");
        BigDecimal bb = new BigDecimal("0.9");
        BigDecimal cc = new BigDecimal("0.8");

        BigDecimal x = aa.subtract(bb); //+ 操作
        BigDecimal y = bb.subtract(cc);;
        System.out.println("x="+x+"   y="+y+"  "+x.equals(y));










    }
}

