package com.ll.lintcode.sort;

/**
 * 在数组中找到第k大的元素
 */
public class KthLargestElement_5 {

    public int KthLargestElement(int[] arr, int k){
        if(arr == null){
            return -1;
        }
        return quickSelect(arr, 0, arr.length - 1, k);
    }

    private int quickSelect(int[] arr, int startIdx, int endIdx, int k){
        if (startIdx == endIdx){
            return arr[startIdx];
        }

        int i = startIdx, j = endIdx;
        int pivot = arr[(i + j) / 2];
        while (i <= j){
            while (i <= j && arr[i] > pivot){
                i ++;
            }
            while (i <= j && arr[j] < pivot){
                j --;
            }
            if(i <= j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        if (startIdx + k - 1 <= j){
            return quickSelect(arr, startIdx, j, k);
        }
        if(startIdx + k - 1 >= i){
            return quickSelect(arr, i, endIdx, k - (i - startIdx));
        }
        return arr[j + 1];
    }

}
