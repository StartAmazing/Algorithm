package com.ll.zs.nowcoder.question;

import java.util.PriorityQueue;

/**
 * @author LL
 * @date 2019/8/9
 * @description
 *              一块金条切成两半，是需要花费和长度数值一样的铜板的。比如长度为20的金条
 *              ，不管切成长度多大的两半，都需要花费20个铜板，一群人想整分整块金条，怎
 *              么分最省铜板？(贪心算法) (huffman编码问题)
 * @example
 *              给定数组【10,20,30】,代表一共3个人，整块金条的长度为10+20+30=60.金条要
 *              分成10,20,30三个部分。
 *              如果，先把长度60的金条分成10和50，花费60.
 *              再把长度为50的金条分成20和30，花费50，
 *              一共花费110个铜板。
 *
 *              先把长度为60的金条分成30和30,花费60
 *              再把长度为30的金条分为10和20，花费30
 *              一共花费90个铜板
 * @require
 *              输入一个数组，返回分割的最小代价
 * @tips
 *              小根堆
 *
 */
public class Problem_04_GoldIncision {


    private static int getMinCost(int[] arr){

        if(arr.length < 2){
            return 0;
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i :
                arr) {
            minHeap.add(i);
        }

        int allCost = 0;

        while (minHeap.size() > 1){
            Integer num1 = minHeap.poll();
            Integer num2 = minHeap.poll();
            allCost += (num1 + num2);
            minHeap.add(num1 + num2);

        }
        return allCost;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{10,20,30};
        System.out.println(getMinCost(arr));
    }
}
