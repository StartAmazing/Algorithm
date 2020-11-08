package com.ll;

import java.util.Scanner;

public class Test {
    public static String reverseStr(String str){
        if(str == null || str.length() == 0){
            return str;
        }

        String[] strs = str.split(" ");
        StringBuilder sb = new StringBuilder();
        int len = strs.length;
        for(int i = 0; i < len; i++){
            char[] chars = strs[i].toCharArray();
            int left = 0;
            int right = chars.length - 1;
            while (left < right){
                swapChar(chars, left ++, right --);
            }

            for(int j = 0; j < chars.length; j ++){
                sb.append(chars[j]);
            }
            if(i != len - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    private static void swapChar(char[] chars, int l, int r){
        char tmp = chars[l];
        chars[l] = chars[r];
        chars[r] = tmp;
    }

    // Memory Referencing Bug Example
    static class Memory_Struct {
        public int[] a = new int[2];
        public double d;
    }

    private static double fun(int i) {
        Memory_Struct s = new Memory_Struct();
        s.d = 3.14;
        s.a[i] = 1073741824; // Possibly out of bounds
        return s.d;
    }

    public static void main(String[] args) {

        // Integer overflow example
        System.out.println(40000 * 40000);
        System.out.println(50000 * 50000);
        System.out.println(300 * 400);
        System.out.println(300 * 400 * 500);
        System.out.println(300 * 400 * 500 * 600);

        // big number sum bug
        System.out.println((1e20 + (- 1e20)) + 3.14);
        System.out.println(1e20 + ((- 1e20) + 3.14));

        // Memory Referencing Bug Example
        System.out.println(fun(0));
        System.out.println(fun(1));
//        System.out.println(fun(2));

    }
}
