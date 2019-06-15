package com.ll.Thread;

public class AccoutingSyncBad implements Runnable {

    static int i = 0;
    public synchronized void increase(){
        i++;
    }

    @Override
    public void run(){
        for(int j = 0; j< 100000; j++){
            increase();
        }
    }

    public static void main(String[] args) throws InterruptedException{

        Thread t1 = new Thread(new AccoutingSyncBad());
        Thread t2 = new Thread(new AccoutingSyncBad());

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }
}
