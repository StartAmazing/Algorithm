package com.ll.leetcode.exercise.greed_part_3;

/**
 * 贪心法找钱
 *         有1元、5元、20元、100元、200元的钞票无穷多张。现在使用这些钞票支付X元，最少需要多少张？
 *         例如，X = 628
 *         最佳支付方法：
 *         3张200块的，1张20块的，1张5块的，3张一块的
 *         共需要3+1+1+3 = 8张
 */

public class BackMoney {
    public static void main(String[] args) {
        final int[] RMB = {200,100,20,10,5,1};  //钞票金额
        final int NUM = 6;  //6种面值
        int X = 628;
        int count = 0;
        for(int i = 0; i < NUM; i++){
            int use = X / RMB[i];
            count += use;
            X = X - RMB[i] * use;
            System.out.println("需要面额为"+ RMB[i] + "的钞票"+ use + "张");
            System.out.println("剩余需要支付金额为：" + X);
        }
        System.out.println("共需要支付钞票" + count + "张");
    }

}
