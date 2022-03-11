package com.ll;

import java.util.Arrays;
import java.util.Random;

public class Test{
    public static int getNum(int[] arr, int target) {
        if (arr == null || arr.length < 1) {
            return -1;
        }

        int left = 0, right = arr.length - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                right = mid;
            } else if(arr[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }

        if (arr[left] == target) {
            return left;
        }
        if (arr[right] == target) {
            return right;
        }


        return -1;
    }

    public static int getNum2(int[] arr, int target) {
        if (arr == null || arr.length < 1) {
            return -1;
        }

        for (int i =0 ; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }

        return -1;
    }


    public static int[] arrFactory(int N) {
        Random random = new Random();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = random.nextInt(10);
        }

        Arrays.sort(arr);
        return arr;
    }


    public static void main(String[] args) {
        int[] data = new int[]{1, 3, 3, 3, 4, 5, 6, 6, 7};
        System.out.println(getNum(data, 6));

        for (int i = 0; i < 100; i++) {
            System.out.println(i);
            int[] ints = arrFactory(20 + i);
            int idx1 = getNum(ints, 7);
            int idx2 = getNum2(ints, 7);
            if(idx1 != idx2) {
                System.out.println("Fail!");
                break;
            }
        }
    }

}
