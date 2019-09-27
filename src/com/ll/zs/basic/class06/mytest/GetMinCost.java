package com.ll.zs.basic.class06.mytest;

import java.util.Comparator;
import java.util.PriorityQueue;

public class GetMinCost {

    private static class MyComparator implements Comparator<Integer>{

        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }
    }

    private static int getMinCostToKnifeGold(int[] arr){
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new MyComparator());
        for (int i :
                arr) {
            priorityQueue.add(i);
        }
        if(priorityQueue.size() == 0){
            return 0;
        }
        if(priorityQueue.size() == 1){
            return priorityQueue.poll();
        }

        while (priorityQueue.size() != 1){
            int m = priorityQueue.poll();
            int n = priorityQueue.poll();
            priorityQueue.add(m + n);
        }

        return priorityQueue.poll();
    }

    public static void main(String[] args) {
        int[] arr = {10,20,30};
        System.out.println(getMinCostToKnifeGold(arr));
        System.out.println(getMinCostToKnifeGold(new int[]{10}));
        System.out.println(getMinCostToKnifeGold(new int[]{}));
    }
}
