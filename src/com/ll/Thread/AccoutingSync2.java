package com.ll.Thread;

public class AccoutingSync2 implements Runnable{

    static AccoutingSync2 instace = new AccoutingSync2();
    static int i = 0;

    public synchronized void increase(){
        i++;
    }

    @Override
    public void run(){
        for (int j=0; j < 100000; j++){
            increase();
        }
    }

    public static void main(String[] args) throws InterruptedException{
        Thread t1 = new Thread(instace);
        Thread t2 = new Thread(instace);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }
}
