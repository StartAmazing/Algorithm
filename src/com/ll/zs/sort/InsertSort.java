package com.ll.zs.sort;

public class InsertSort {

    public static void insertionSort(int[] arr){
        if(arr == null || arr.length < 2)
            return;
        for(int i = 1; i < arr.length; i++){
            for(int j = i -1 ; j >=  0 && arr[j] > arr[j+1]; j --){
                    swap(arr, j , j+1);
            }
        }
    }
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args){
        int[] arr = {4,1,3,6,22,25,12,3};
        insertionSort(arr);
        System.out.print("arr={ ");
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + ", ");
        }
        System.out.print("}");
    }



}
