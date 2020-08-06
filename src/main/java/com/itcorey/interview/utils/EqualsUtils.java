package com.itcorey.interview.utils;

import java.util.Objects;

/**
 * @Auther: corey
 * @Date: 2020/7/28 09:23
 * @Description:
 */
public class EqualsUtils {
    public static void main(String[] args) {

        for (int x=0,y=0;(y!=0)&&(x<4);x++){
            System.out.println("1111111");
        }


        String str = null;
        if (Objects.equals(null,"qqqqq")){
            System.out.println("-----");
        }else {
            System.out.println("-----");
        }
    }
}
