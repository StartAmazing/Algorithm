package com.ll.muke.heap;

public class HeapSort1 {

    //我们的算法类不允许产生任何实例
    private HeapSort1() {}

    //对整个arr数组使用HeapSort1排序
    //HeapSort1，将所有的元素依次添加到堆中，再将所有元素从堆中依次取出来，即完成了排序
    //无论是创建堆的过程，还是从堆中依次取出元素的过程，时间复杂度均为O(nlog n)
    // 整个堆排序的整体时间复杂度为（nlong n）
    public static void sort(Comparable[] arr){
        int n = arr.length;
        MaxHeap<Comparable> maxHeap = new MaxHeap<Comparable>(n);
        for(int i = 0 ; i < n ; i ++){
            maxHeap.insert(arr[i]);
        }
        for(int i = 0; i < n ; i ++){
            arr[i] = maxHeap.extractMax();
        }
    }

    public static void main(String[] args) {
        int N = 1000;
        Integer[] arr = new Integer[N];
        for(int i = 0 ; i < 1000 ; i++){
            arr[i] = (int)(Math.random()*10000);
        }

        sort(arr);
        for(Integer i : arr){
            System.out.print(i + " ");
        }
    }
}
