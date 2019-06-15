package com.ll.muke.heap;

public class HeapSort2 {

    private HeapSort2(){}

    // 对整个arr数组使用HeapSort2排序
    // HeapSort2, 借助我们的heapify过程创建堆
    // 此时, 创建堆的过程时间复杂度为O(n), 将所有元素依次从堆中取出来, 实践复杂度为O(nlogn)
    // 堆排序的总体时间复杂度依然是O(nlogn), 但是比HeapSort1性能更优, 因为创建堆的性能更优
    public static void sort(Comparable[] arr){
        int n = arr.length;
        MaxHeap<Comparable> maxHeap = new MaxHeap<Comparable>(arr);
        for(int i = 0 ; i < n; i ++ ){
            arr[i] = maxHeap.extractMax();
        }
    }

    public static void main(String[] args) {
        int N = 1000;
        Integer[] arr = new Integer[N];
        for(int i = 0 ; i < N ; i++){
            arr[i] = (int) (Math.random()*N*10);
        }
        sort(arr);
        for(Integer i : arr){
            System.out.print(i + " ");
        }
    }
}
