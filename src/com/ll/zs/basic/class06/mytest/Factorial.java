package com.ll.zs.basic.class06.mytest;

/**
 * 求n！
 */
public class Factorial {
    public static long getFactoril1(int n){
        if(n == 1 ){
            return 1;
        }
        return (long)n * getFactoril1(n - 1);
    }

    public static long getFactoril2(int n){
        long res = 1L;
        for(int i = 1; i < n; i ++){
            res *= i;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(getFactoril1(5));
        System.out.println(getFactoril2(5));
    }
}
