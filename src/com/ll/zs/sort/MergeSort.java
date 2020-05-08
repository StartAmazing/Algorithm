package com.ll.zs.sort;

public class MergeSort {
    public static void mergeSort(int[] arr){
        if(arr == null || arr.length < 2)
            return;
        sortProcess(arr, 0, arr.length - 1);
    }
    public static void sortProcess(int[] arr, int left, int right){
        if(left == right)
            return;
        int mid = left + ((right - left) >> 1); // 右移一位 除二操作
        sortProcess(arr, left, mid);
        sortProcess(arr,mid + 1, right);
        merge(arr, left, mid, right);
    }

    public static void merge(int[] arr, int left, int mid, int right){
        int[] help = new int[right - left + 1];
        int i = 0;
        int p1 = left;
        int p2 = mid + 1;
        while(p1 <= mid && p2 <=right){
            help[i++] = arr[p1] > arr[p2] ? arr[p2++] : arr[p1++];
        }
        while(p1 <= mid){ //言外之意就是p2 == right
            help[i++] = arr[p1++];
        }
        while(p2 <= right){  //言外之意就是p1 == mid
            help[i++] = arr[p2++];
        }
        for(i = 0; i < help.length; i++){
            arr[left + i]  = help[i];
        }
    }
    public static void main(String[] args){
        int[] arr = {4,1,3,6,22,25,12,3};
        mergeSort(arr);
        System.out.print("arr={ ");
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + ", ");
        }
        System.out.print("}");
    }
}
