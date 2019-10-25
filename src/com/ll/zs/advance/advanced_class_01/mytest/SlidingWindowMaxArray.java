package com.ll.zs.advance.advanced_class_01.mytest;

import com.ll.muke.map.LinkedList;

/**
 * 滑动窗口
 */
public class SlidingWindowMaxArray {

    private static int[] getMaxWindow(int[] arr, int w){
        if(arr == null || w < 1 || arr.length < w){
            return  null;
        }

        LinkedList<Integer> qmax = new LinkedList<>();
        int[] res = new int[arr.length - w + 1];
        int index = 0;
        for(int i = 0 ; i < arr.length; i++){
            while (!qmax.isEmpty() && arr[qmax.getLast()]< arr[i]){
                qmax.removeLast();
            }
            qmax.addLast(arr[i]);
            if(qmax.getFirst() == i - w ){
                qmax.removeFirst();
            }
            if(i >= w - 1){
                res[index ++] = arr[qmax.getFirst()];
            }
        }
        return  res;
    }

    private static void peekLast()
}
