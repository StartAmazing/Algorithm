package com.ll.zs.advance.mytest;

import com.ll.muke.map.LinkedList;

public class AllLessNumSubArray {

    //暴力方法（O(n^3 )）
    public static int getNum1(int[] arr, int num){

        int res = 0;
        for(int start = 0; start < arr.length; start ++){
            for(int end = start; end < arr.length; end ++){
                if(isValid(arr,start,end,num)){
                    res ++;
                }
            }
        }
        return res;
    }

    private static boolean isValid(int[]arr, int start,int end, int num){
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i = start; i < end; i++){
            max = Math.max(arr[i],max);
            min = Math.min(arr[i],min);
        }
        return max - min <= num;
    }


    //时间复杂度(O(N))
    public static int getNum(int[] arr, int num){
        if(arr == null || arr.length == 0){
            return 0;
        }
        LinkedList<Integer> qmax = new LinkedList<>();  //在最左边的始终是当前滑动窗口的最大值
        LinkedList<Integer> qmin = new LinkedList<>();  //在最左边的始终是当前滑动窗口的最小值
        int L = 0; //start
        int R = 0;  //end
        int res = 0;
        while (L < arr.length){
            while (R < arr.length){
                while (!qmin.isEmpty() && arr[qmin.getLast()] >= arr[R]){       //找出第一次出现不达标的R位置，然后break出去，计算这个位置下的所有子数组个数
                    qmin.removeLast();
                }
                qmin.addLast(R);
                while (!qmax.isEmpty() && arr[qmax.getLast()] <= arr[R]){
                    qmax.removeLast();
                }
                qmax.addLast(R);
                if(arr[qmax.getFirst()] - arr[qmin.getFirst()] > num){  //不达标的情况
                    break;
                }
                R++;
            }
            if(qmin.getFirst() == L){
                qmin.removeFirst();
            }
            if(qmax.getFirst() == L){
                qmax.removeFirst();
            }
            res += R - L;
            L++;
        }
        return res;
    }

}
