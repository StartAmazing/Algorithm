package com.ll.zs.basic.class07.mytest;

import com.ll.zs.basic.class07.Code_02_Less_Money;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LessMoney {
    public static int lessMoney(int[] arr){
        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        for(int i = 0; i < arr.length; i++){
            pQ.add(arr[i]);
        }
        int sum = 0;
        int cur = 0;
        while (pQ.size() > 1){
            cur = pQ.poll() + pQ.poll();
            sum += cur;
            pQ.add(cur);
        }
        return sum;
    }

    public static class MinheapComaprator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }
    }

    public static class MaxheapComaprator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }

    public static void main(String[] args) {
        // solution
        int[] arr = { 6, 7, 8, 9 };
        System.out.println(lessMoney(arr));

        int[] arrForHeap = { 3, 5, 2, 7, 0, 1, 6, 4 };

        // min heap
        PriorityQueue<Integer> minQ1 = new PriorityQueue<>();
        for (int i = 0; i < arrForHeap.length; i++) {
            minQ1.add(arrForHeap[i]);
        }
        while (!minQ1.isEmpty()) {
            System.out.print(minQ1.poll() + " ");
        }
        System.out.println();

        // min heap use Comparator
        PriorityQueue<Integer> minQ2 = new PriorityQueue<>(new MinheapComaprator());
        for (int i = 0; i < arrForHeap.length; i++) {
            minQ2.add(arrForHeap[i]);
        }
        while (!minQ2.isEmpty()) {
            System.out.print(minQ2.poll() + " ");
        }
        System.out.println();

        // max heap use Comparator
        PriorityQueue<Integer> maxQ = new PriorityQueue<>(new MaxheapComaprator());
        for (int i = 0; i < arrForHeap.length; i++) {
            maxQ.add(arrForHeap[i]);
        }
        while (!maxQ.isEmpty()) {
            System.out.print(maxQ.poll() + " ");
        }

    }

}
