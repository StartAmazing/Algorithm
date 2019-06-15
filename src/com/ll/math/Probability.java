package com.ll.math;

public class Probability {
    //概率求π

    /**
     * @param n 随机点的数量
     */
    public static void getPi(int n){
        int i,sum = 0;
        System.out.println("输入点的数量：" + n);
        double x,y;

        for(i = 0 ;  i < n; i++ ){
            x = (double) Math.random();
            y = (double) Math.random();
            if((x*x + y*y) <=1 ){
                sum ++;
            }
        }
        System.out.println("PI = " + (double) 4 * sum / n);

    }

    public static void main(String[] args) {
        getPi(10000000);
    }

}
