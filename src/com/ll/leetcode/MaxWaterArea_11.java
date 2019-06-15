package com.ll.leetcode;

public class MaxWaterArea_11 {

    //暴力法
    public static int solution(int[] arr){
        int maxArea = 0;
        for(int i = 0; i < arr.length ; i++){
           for(int j  = i + 1 ; j < arr.length ; j++){
               maxArea = (j - i) * (Math.min(arr[i],arr[j])) > maxArea ?  (j - i) * (Math.min(arr[i],arr[j])) : maxArea;
           }
       }
       return maxArea;
    }

    //双指针法
    public static int solution2(int[] arr){
        int maxArea = 0;
        int i = 0;
        int j = arr.length - 1;
        while( i != j){
            maxArea = maxArea > (j - i) * Math.min(arr[j],arr[i]) ? maxArea : (j - i) * Math.min(arr[j],arr[i]);
            if(arr[i] > arr[j]){
                j -= 1;
            }else{
                i += 1;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] arr = {1,8,6,2,5,4,8,3,7} ;
        int solution = solution(arr);
        System.out.println(solution);
        solution = solution2(arr);
        System.out.println(solution);
    }

}
