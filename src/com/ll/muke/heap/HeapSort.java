package com.ll.muke.heap;

import org.omg.CORBA.INTERNAL;

// 不使用一个额外的最大堆, 直接在原数组上进行原地的堆排序
public class HeapSort {

    private HeapSort(){}

    // 注意，此时我们的堆是从0开始索引的
    // 从(最后一个元素的索引-1)/2开始shiftDown操作
    // 最后一个元素的索引 = n-1
    public static void sort(Comparable[] arr){
        int n = arr.length;
        for(int i = (n - 2) / 2 ; i >= 0 ; i --){
            shiftdown2(arr, n, i);
        }
        for(int i = n - 1; i > 0; i --){
            swap(arr, i, 0);
            shiftdown2(arr, i, 0);
        }
    }

    // 优化的shiftDown过程, 使用赋值的方式取代不断的swap,
    // 该优化思想和我们之前对插入排序进行优化的思路是一致的
    private static void shiftdown2(Comparable[] arr, int n, int i){
        Comparable e = arr[i];
        while(2*i+1 < n ){
            int j = 2*i + 1;
            if( j+1 < n && arr[j+1].compareTo(arr[j]) >0)
                j += 1;
            if(e.compareTo(arr[j]) >= 0)
                break;
            arr[i] = arr[j];
            i = j;
        }
        arr[i] = e;

    }
    // 原始的shiftDown过程
    private static void shiftDown1(Comparable[] arr, int n, int i){
        while( (i * 2 + 1) < n ){
            int j = i * 2 + 1;
            if(j + 1 < n && arr[j].compareTo(arr[j + 1]) < 0)
                j = j + 1;
            if(arr[i].compareTo(arr[j]) >= 0)
                break;
            swap(arr , i, j );
            i = j;
        }
    }
    // 交换堆中索引为i和j的两个元素
    private static void swap(Object[] arr, int i, int j){
        Object o = arr[i];
        arr[i] = arr[j];
        arr[j] = o;
    }

    public static void main(String[] args) {
        int N = 1000;
        Integer[] arr = new Integer[1000];
        for(int i= 0 ; i < 1000; i++){
            arr[i] = (int) (Math.random() * 10000);
        }
        sort(arr);

        for(Integer i : arr){
            System.out.print(i + " ");
        }

    }

}
