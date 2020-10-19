package com.ll.zs.nowcoder.sort;

public class BubbleSort {
    public static void bubbleSort(int[] arr){
        if(arr == null || arr.length < 2)
            return;
        for(int i = arr.length -1 ; i >= 0; i--){
            for(int j = 0; j < i; j++){
                if(arr[j] > arr[j+1]){
                    swap(arr, j, j+1);
                }
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
        bubbleSort(arr);
        System.out.print("arr={ ");
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + ", ");
        }
        System.out.print("}");
    }
}
