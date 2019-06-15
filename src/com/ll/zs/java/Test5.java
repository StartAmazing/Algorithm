package com.ll.zs.java;

public class Test5 {
    public static int i = 0;
    public static int getValue(){
//        int i = 1;
        try{
            return i;
        }finally {
            i++;
        }
    }

    public static void main(String[] args) {
        System.out.println("return value of: " + getValue());
        System.out.println(i);
    }
}
