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

    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());

    }
}
