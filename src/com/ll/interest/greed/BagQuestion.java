package com.ll.interest.greed;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class BagQuestion {

    //先构造一个数据结构体表示每件宝物以及他们的属性
    public static class Three{
        double w;   //重量
        double v;   //总价值
        double p;   //每种宝物的性价比（v/w）
        public Three(double w, double v, double p){
            this.w = w;
            this.v = v;
            this.p = p;
        }

        @Override
        public String toString() {
            return "Three{" +
                    "w=" + w +
                    ", v=" + v +
                    ", p=" + p +
                    '}';
        }
    }

    public static class Bijiao implements Comparator<Three> {

        @Override
        public int compare(Three o1, Three o2) {
            if(o1.p - o2.p ==0 ) return 0;
            return (o1.p - o2.p) >  0  ? -1 : 1;
        }
    }

    private static double maxLoad(ArrayList<Three> list, int can){
        double value = 0;
        int weight = 0;
        //实现贪心算法
        for(int j = 0; j < list.size(); j++){
            if(weight + list.get(j).w <= can){
                weight += list.get(j).w;
                value += list.get(j).v;
            }else{

                if(can - weight > 0){
                    value += (can - weight) * list.get(j).p;
                }
                break;
            }
        }
        return value;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入古董的数量： ");
        int s = sc.nextInt();
        System.out.println("请输入每件宝物的重量，以空格隔开： ");
        double[] warr = new double[s];
        int i = 0;
        while(i != s){
            warr[i] = sc.nextDouble();
            i ++ ;
        }
        System.out.println("请输入每件宝物的价值，以空格隔开： ");
        double[] varr = new double[s];
        i = 0;
        while(i != s){
            varr[i] = sc.nextDouble();
            i++;
        }
        System.out.println("每件宝物的重量价值以及性价比为：");
        double[] parr = new double[s];
        for(int j = 0; j < varr.length; j++){
            parr[j] = varr[j]/warr[j];
        }
        for (double d : warr) {
            System.out.print(d + " ");
        }
        System.out.println();
        for (double d : varr) {
            System.out.print(d + " ");
        }
        System.out.println();
        for (double d : parr){
            System.out.print(d + " ");
        }
        System.out.println();

        //将数据转为对象并加入list列表中
        ArrayList<Three> list = new ArrayList<>();
        for(int j = 0; j < parr.length; j ++){
            list.add(new Three(warr[j], varr[j], parr[j]));
        }
        list.forEach(a-> System.out.println(a.toString()));
        System.out.println("==============================");

        //将列表里面的对象根据性价比排序（大到小）
        list.sort(new Bijiao());
        list.forEach(a-> System.out.println(a.toString()));

        System.out.println("请输入最大可运载的重量： ");
        int can = sc.nextInt();
        double value = maxLoad(list, can);
        System.out.println("最大可运载的宝物的价值为： " + value);
    }
}
