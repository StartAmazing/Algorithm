package com.ll.zs.nowcoder.basic.class06.mytest;

import java.util.Comparator;
import java.util.PriorityQueue;

public class IPO {
    public static class Node{
        int cost;
        int profit;

        public Node(int cost,int profit){
            this.cost = cost;
            this.profit = profit;
        }
    }
    public static class MinCostComparator implements Comparator<Node>{

        @Override
        public int compare(Node o1, Node o2) {
            return o1.cost - o2.cost;
        }
    }

    public static  class MaxProfitComparator implements Comparator<Node>{

        @Override
        public int compare(Node o1, Node o2) {
            return o2.profit - o1.profit;
        }
    }

    public static int getMaxProfit(int[] acost, int[] aprofit, int times, int startMoney){
        if(acost.length != aprofit.length || acost.length == 0){
            throw new RuntimeException("输入参数不合法！");
        }
        PriorityQueue<Node> cpq = new PriorityQueue<>(new MinCostComparator());
        PriorityQueue<Node> ppq = new PriorityQueue<>(new MaxProfitComparator());
        for(int i = 0; i < acost.length; i++ ){
            cpq.add(new Node(acost[i],aprofit[i]));
        }
        int resMoney = startMoney;
        while(times != 0){
            while(!cpq.isEmpty() && resMoney >= cpq.peek().cost){
                ppq.add(cpq.poll());
            }
            if(!ppq.isEmpty()) {
                resMoney += ppq.poll().profit;
            }
            times --;
        }
        return resMoney;
    }

    public static void main(String[] args) {
        int[] cost = new int[]{4,22,14,14,12};
        int[] profit = new int[]{3,6,4,2,8};
        int maxProfit = getMaxProfit(cost, profit, 3, 5);
        System.out.println(maxProfit);

    }
}
