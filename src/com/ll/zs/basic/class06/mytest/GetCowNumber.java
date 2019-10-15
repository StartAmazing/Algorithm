package com.ll.zs.basic.class06.mytest;

/**
 * 母牛每年生一只母牛，新生的母牛成长三年后也能每年生一只母牛，假设不会死
 * 。求N年后，母牛的数量。
 */
public class GetCowNumber {

    private static int getCowNumber(int year){
        if(year == 1 || year ==2 || year == 3 || year == 4 ){
            return year;
        }
        return getCowNumber(year - 1) + getCowNumber(year - 3);
    }

    public static void main(String[] args) {
        System.out.println(getCowNumber(6));
    }
}
