package com.ll.leetcode;

/**
 * Created by LL on 2019/9/27.
 */
public class RemoveElementOfArray_27 {

    private static int removeElementOfArray(int[] arr, int target){
        int i = 0;
        int j = arr.length - 1;
        for(; i <= j ;){
            if(arr[i] == target){
                arr[i] = arr[j];
                j --;
            }else {
                i++;
            }
        }
        return j + 1;
    }

    public static void main(String[] args) {
        int arr[] = new int[]{1};
        System.out.println(removeElementOfArray(arr,1));
    }

}
