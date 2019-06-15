package com.ll.Thread;

public class DaemonDemo {
    public static class DaemonT extends Thread{
        public void run(){
            while(true){
                System.out.println("I am alive!");
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }
    public static void main(String[] args) throws InterruptedException{
        Thread t = new DaemonT();

        //将这个线程设置为守护线程
        // 设置守护线程时必须设置在执行start()执行之前设置他的状态
        //如果在start()方法时候调用此方法则会抛出异常
        t.setDaemon(true);
        t.start();

//        Thread.sleep(2000);
    }
}
