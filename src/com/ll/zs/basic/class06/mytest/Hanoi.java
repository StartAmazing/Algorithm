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

    public static void main(String[] args) {
        int n = 3;
        process(3,"左", "右","中");
    }
}
