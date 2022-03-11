package com.ll.zs.nowcoder.sort;

public class QuickSort {
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2)
            return;
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            swap(arr, left + (int) (Math.random() * (right - left + 1)), right);
            int[] p = partition(arr, left, right);
            quickSort(arr, left, p[0] - 1);
            quickSort(arr, p[1] + 1, right);
        }
    }

    private static int[] partition(int[] arr, int l, int r) {
        int less = l - 1;
        int more = r;
        while (l < more) {
            if (arr[l] < arr[r])
                swap(arr, ++less, l++);
            else if (arr[l] > arr[r])
                swap(arr, l, --more);
            else
                l++;
        }
        swap(arr, more, r);
        return new int[]{less + 1, more};
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {4, 1, 3, 6, 22, 25, 12, 3};
        quickSort(arr);
        System.out.print("arr={ ");
        for (int value : arr) {
            System.out.print(value + ", ");
        }
        System.out.print("}");

        System.out.println((int) 6.2);
    }
}
