package com.ll.github.notes;

import java.util.Arrays;

public class Dp {

    //斐波那契数列
    private static int fibonacci(int i){
        if(i == 0 || i == 1){
            return i;
        }
        return fibonacci(i -1) + fibonacci( i - 2);
    }

    private static int fibonacci2(int i){
        int[] res = new int[i + 1];
        res[0] = 0;
        res[1] = 1;
        for(int j = 2 ; j <= i ; j ++){
            res[j] = res[j - 1] + res[j - 2];
        }
        return res[i];
    }

    private static int fibonacci3(int n){
        if(n <= 1){
            return n;
        }
        int[] res = new int[2];
        res[1] = 1;
        int fib = 0;
        for(int i = 2 ; i <= n; i ++){
            fib = res[0] + res[1];
            res[0] = res[1];
            res[1] = fib;
        }
        return fib;
    }

    //矩形覆盖问题
    //我们可以用 2*1 的小矩形横着或者竖着去覆盖更大的矩形。
    // 请问用 n 个 2*1 的小矩形无重叠地覆盖一个 2*n 的大矩形，总共有多少种方法？
    private static int totalCover(int n){
        if(n == 0 || n ==1){
            return  n;
        }
        if(n == 2){
            return 2;
        }
        return totalCover(n - 1) + totalCover(n - 2);
    }

    private static int totalCover2(int n){
        if(n <= 2){
            return  n;
        }
        int pre = 1;
        int pos = 2;
        int res = 0;
        for(int i = 3; i <= n; i++){
            res = pre + pos;
            pre = pos;
            pos = res;
        }
        return res;
    }

    //青蛙跳台阶问题
    //一只青蛙一次可以跳上 1 级台阶，也可以跳上 2 级。求该青蛙跳上一个 n 级的台阶总共有多少种跳法
    //同上


    //变态跳台阶问题
    //数学归纳法
    private static int jumpBtStep(int num){
        return (int)Math.pow(2,num - 1);
    }
    //变态跳台阶问题
    //动态规划
    private static int jumpBtStep2(int num){
        int[] dp = new int[num];
        Arrays.fill(dp,1);
        for(int i = 1; i < num; i ++){
            for(int j = 0; j < i; j ++){
                dp[i] += dp[j];
            }
        }
        return dp[num - 1];
    }
    //变态跳台阶问题
    //递归的
    private static int jumpBtStep3(int num){
        int[] dp = new int[num];
        if(num <= 1){
            return num;
        }
        int sum = 0;
        for(int i = 0 ; i < num ; i ++){
            sum += jumpBtStep3(i);
        }
        return sum;
    }


    public static void main(String[] args) {

        //斐波那契数列
        int fibonacci = fibonacci(6);
        System.out.println(fibonacci);
        int fibonacci2 = fibonacci2(6);
        System.out.println(fibonacci2);
        int fibonacci3 = fibonacci3(5);
        System.out.println(fibonacci3);

        //矩形覆盖问题
        int totalCover = totalCover(5);
        System.out.println(totalCover);
        int totalCover2 = totalCover2(5);
        System.out.println(totalCover2);
    }




}
