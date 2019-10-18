package com.ll.zs.basic.class06.mytest;

/**
 * 给出一个数组arr，和一个正数aim,如果可以选择arr中的任意数字，
 * 能不能累加到aim,返回true或false
 *          arr和aim全部是正数？？？
 *          arr中和aim中可正可负？？？
 */
public class ArrSumLikeNum {

    /**
     * 从某个数字开始，后面的数字随意选择，
     * @param arr 给出的数组
     * @param i 数组角标
     * @param sum   记录和
     * @param aim   目标值
     * @return
     */
    private static boolean isSum(int[] arr, int i, int sum,int aim){
        if(i == arr.length){
            return sum == aim;
        }
        return isSum(arr,i+1,sum,aim) || isSum(arr, i+1,sum+arr[i],aim);
    }

    public static void main(String[] args) {
        int[] arr = {9,3,2,6,7};
        int aim = 4;
        System.out.println(isSum(arr,0,0,aim));
    }

}
