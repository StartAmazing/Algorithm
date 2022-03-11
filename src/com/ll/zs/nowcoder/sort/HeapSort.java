package com.ll.zs.nowcoder.sort;

import java.util.Scanner;

public class HeapSort {
    public static void heapSort(int[] arr){
        if(arr == null || arr.length < 2)
            return;
        for(int i = 0; i < arr.length ; i++){
            heapInsert(arr, i);   // 生成大根堆
        }
        int heapSize = arr.length;
        swap(arr,0, --heapSize);        // 每次开始从堆顶和最后一个元素替换，此时堆空间减1
        while(heapSize > 0){
            heapify(arr, 0, heapSize);
            swap(arr, 0, --heapSize);
        }
    }

    public static void heapInsert(int[] arr, int index){
        while(arr[index] > arr[(index - 1 ) / 2]){  // (0 - 1) / 2 = 0
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    public static void heapify(int[] arr,int index, int heapSize){
        int left = index * 2 + 1;
        while(left < heapSize){ // right != heapSize right最多等于heapSize - 1
            int largest = (left + 1 < heapSize ) && arr[left + 1 ] > arr[left] ? left + 1 : left;
            largest = arr[largest] > arr[index] ? largest : index;
            if(largest == index){
                break;
            }
            swap(arr,largest,index);
            index = largest;
            left = index * 2 + 1;
        }
    }

    public static void swap(int[] arr,int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args){
        int[] arr = {4,1,3,6,22,25,12,3};
        heapSort(arr);
        System.out.print("arr={ ");
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + ", ");
        }
//        System.out.print("}");
//
//        System.out.println((0 - 1) / 2);

        System.out.println("=================");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(s);
        while (scanner.hasNext()) {
            String s1 = scanner.nextLine();
            System.out.println(s1);
        }
    }

}
