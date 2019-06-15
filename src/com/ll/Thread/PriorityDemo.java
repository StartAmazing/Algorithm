package com.ll.Thread;

public class PriorityDemo {
    public static class HightPriority extends Thread{

        static int count = 0;

        public void run(){
            while(true){
                synchronized (PriorityDemo.class){
                    count ++ ;
                    if(count > 1000000){
                        System.out.println("HightPriority is completed!");
                        break;
                    }
                }
            }
        }
    }
    public static class LowPrority extends Thread{
        static int count = 0;
        public void run(){
            while(true){
                synchronized (PriorityDemo.class){
                    count ++ ;
                    if(count > 1000000){
                        System.out.println("LowPriority is completed!");
                        break;
                    }
                }
            }
        }
    }

    /**
     * 并不是说高优先级的一定就每次都能竞争到资源
     * 还有许多其他因素有关，只是说竞争到资源的概率大
     * @param args
     */
    public static void main(String[] args){
        Thread high = new HightPriority();
        Thread low = new LowPrority();
        high.setPriority(Thread.MAX_PRIORITY);
        low.setPriority(Thread.MIN_PRIORITY);
        low.start();
        high.start();
    }

}
