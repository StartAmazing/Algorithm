package com.ll.zs.java;

public class Test7 {
    private int data;
    int result = 0;
    public void m(){
        result += 2;
        data += 2;
        System.out.println(result + " " + data);
    }
}

class ThreadExample extends Thread{

    private Test7 mv;

    public ThreadExample(Test7 mv){
        this.mv = mv;
    }
    @Override
    public void run() {
        synchronized (mv){
            mv.m();
        }
    }
}

class ThreadTest{
    public static void main(String[] args) {
        Test7 mv = new Test7();
        Thread t1 = new ThreadExample(mv);
        Thread t2 = new ThreadExample(mv);
        Thread t3 = new ThreadExample(mv);
        t1.start();
        t2.start();
        t3.start();
    }


}