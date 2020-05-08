package com.ll.zs.sort;

public class SelectSort {
    public static void selectionSort(int[] arr){
        if(arr == null || arr.length < 2)
            return;
        for(int i = 0; i < arr.length; i++){
            int minIndex = i;
            for(int j = i + 1; j < arr.length; j++){
                minIndex = arr[j] > arr[minIndex] ? minIndex : j;
            }
            swap(arr, minIndex, i);
        }
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public static void main(String[] args){
        int[] arr = {4,1,3,6,22,25,12,3};
        selectionSort(arr);
        System.out.print("arr={ ");
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + ", ");
        }
        System.out.print("}");
    }
}
