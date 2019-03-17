package com.ll.leetcode;

public class Main {

    public static double getSum(double basic, double radio,int year){
        double sum = 0;
        for(int i = 0; i < year; i ++){
            sum += basic;
            basic = basic + basic*radio;
        }

        return sum;
    }

    public static double getSalary(double basic, double radio, int year){
        double salary = basic;
        for(int i = 0; i < year; i++){
            salary += salary * radio;
        }

        return salary;
    }

    public static void main(String[] args) {
        double total = getSum(7200.0, 0.1, 11);
        System.out.println("11年总共交的钱： " + total);
        double all = total + 12000;
        System.out.println("加上补4年总共的亲： " + all);
        double monthes = all / (2500);
        System.out.println("多少个月能够领回来（每个月以2500算）： " + monthes);

        double salary = getSalary(1600,0.065,11);
        System.out.println("十一年之后的工资(元/月)： " + salary );

        monthes = all/salary;
        System.out.println(monthes + "个月能领回来。");

    }


}
