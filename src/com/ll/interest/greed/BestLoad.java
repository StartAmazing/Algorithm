package com.ll.interest.greed;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BestLoad {
    private static int MaxLoad(int[] arr, int can){
        double weight = 0;
        int ans = 0;
        for(Integer i :arr){
            if(weight+i > can){
                break;
            }
            ans ++;
            weight += i;
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入古董的数量： ");
        int s = Integer.parseInt(sc.next());
        System.out.println("请输入每件古董的重量，以逗号隔开： ");

        String weight = sc.next();
        String[] split = weight.split(",");     //古董重量数组

        int[] arr = new int[split.length];
//        ArrayList<Integer> alist = new ArrayList<>();
        for(int i = 0; i < split.length; i++){
            arr[i] = Integer.parseInt(split[i]);
//            alist.add(arr[i]);
        }
        System.out.println();
        Arrays.sort(arr);
//        alist.sort(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                if(o1 > o2){
//                    return -1;
//                }else{
//                    return 1;
//                }
//            }
//        });
        for (Integer i: arr) {
            System.out.print(i + " ");
        }
        System.out.println();
//        for(int i = 0; i< arr.length; i++){
//            System.out.print(arr[i] + ",");
//        }
        System.out.println("请输入最大载重为： ");
        int can = sc.nextInt();
        int res = MaxLoad(arr, can);
        System.out.println("最大能够载的古董数量为： " + res);
    }

}
