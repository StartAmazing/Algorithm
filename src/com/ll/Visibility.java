package com.ll;

// java可见性测试
public class Visibility {
    private static boolean endFlag = false;
//    public volatile static boolean endFlag = false;
//    private static Integer count = 0;
    private volatile static Integer count = 0;
    public static void doSomething() {
        System.out.println(Thread.currentThread().getName() + ": the end flag is false.");
        while (!endFlag) {
            System.out.println("running");
        }
        System.out.println(Thread.currentThread().getName() + ": the end flag is true.");
    }

    public static void changeFlag() {
        System.out.println(Thread.currentThread().getName() + ": try to change the flag to true.");
        endFlag = true;
        System.out.println(Thread.currentThread().getName() + ": change flage success.");
    }

    public static void main(String[] args) throws Exception {
        new Thread(Visibility::doSomething, "doSomethingThread").start();
        Thread.sleep(1000);
        new Thread(Visibility::changeFlag, "changeThread").start();
    }
}
