package com.ll.alg4.chapter2;

import java.util.Arrays;

public class Sort {

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{11, 7, 33, 22, 102, 5, 5};
        print(arr);
        insertSort(arr);
        print(arr);
    }


    public static <T extends Comparable<T>> void selectSort(T[] arr) {
        for(int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[min].compareTo(arr[j]) > 0) {
                    min = j;
                }
            }

            swap(arr, i, min);
        }
    }

    public static <T extends Comparable<T>> void insertSort(T[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j  > 0; j--) {
                if(arr[j].compareTo(arr[j - 1]) < 0) {
                    swap(arr, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }

    public static <T extends Comparable<T>> void print(T[] arr) {
        System.out.println("arr = " + Arrays.deepToString(arr));
    }

    public static <T extends Comparable<T>> void swap(T[] arr, int x, int y) {
        T tmp = arr[x];
        arr[x] = arr[y];
        arr[y] = tmp;
    }
}
