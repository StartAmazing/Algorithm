package com.ll.zs.HeapSort;

public class HeapSort3 {
    public static void heapSort(int[] arr){
        if(arr.length < 2 || arr == null) {
            return;
        }
        for (int i=0;i<arr.length;i++) {
            heapInsert(arr,i);
        }
        int heapSize = arr.length;
        swap(arr,0, --heapSize);
        while(heapSize > 0){
            heapify(arr,0,heapSize);
            swap(arr,0,--heapSize);
        }
    }
    //建立大根堆
    public static void heapInsert(int[] arr,int index){
        while(arr[index] > arr[(index-1)/2]){
            swap(arr,index,(index-1) / 2);
            index = (index - 1) / 2;
        }
    }
    //堆排序操作
    public static void heapify(int[] arr,int index,int heapSize){
        int left = index*2 + 1;
        while(left < heapSize){
            int largest = (left+1<heapSize && arr[left+1] > arr[left]) ? left+1:left;
            largest = arr[largest] > arr[index] ? largest : index;
            if(largest == index){
                break;
            }
            swap(arr, index, largest);
            index = largest;
            left = index * 2 + 1;
        }
    }
    //数组两个元素交换操作
    public static void swap(int[] arr,int i,int j){
        int item = arr[i];
        arr[i] = arr[j];
        arr[j] = item;
    }

    public static void main(String[] args) {
        int arr[] = {1,5,3,2,4,6,8,9,6};
        heapSort(arr);
        for (int i = 0; i <arr.length; i++){
            System.out.print("arr["+i+"]=" + arr[i]);
            if(i != arr.length){
                System.out.print("->");
            }
        }
    }

}
