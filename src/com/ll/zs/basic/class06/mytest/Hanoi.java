package com.ll.zs.basic.class06.mytest;

public class Hanoi {

    public static void process(int N, String from, String to,String help){
        if(N == 1){
            System.out.println("Move 1 " + from + " to " + to);
        }else{
            process(N - 1, from, help, to);
            System.out.println("Move " + N + " to " + to);
            process(N - 1, help, to, from);
        }
    }

    public static void process2(int N, String from, String to, String mid){
        if(N == 1){
            System.out.println("Move " + N + " from " + from + " to " + to);
        }else{
            process2(N -1, from, mid, to);
            System.out.println("move " + N + " from " + from + " to " + to);
            process2(N - 1, mid, to, from);
        }

    }

    public static void main(String[] args) {
        int n = 3;
        process(3,"左", "右","中");
        System.out.println("=========================");
        process2(n,"A","C","B");
    }
}
