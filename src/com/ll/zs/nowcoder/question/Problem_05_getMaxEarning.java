package com.ll.zs.nowcoder.question;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * @author LL
 * @date 2019/8/9
 *
 * @input
 *              参数1，正整数组costs
 *              参数2，正数数组profits
 *              参数3，正数k
 *              参数4，正数m
 * @description
 *              costs[i]表示i号项目的花费
 *              profits[i]表示i号项目在扣除花费之后还能挣到的钱（利润）
 *              k表示不能并行，只能串行的最多做k个项目
 *              m表示你的初始资金
 * @require
 *              你每做完一个项目，马上获得收益，可以支持你去做下一个项目。
 *
 * @output
 *              你最后获得的最大钱数
 *
 * @solution
 *              小根堆/大根堆
 *
 *
 */
public class Problem_05_getMaxEarning {


    /**
     *
     *
     * @param
     *  pCost 项目启动资金
     *  pEarn 项目收益（最后实际有的金钱 =  原本的资金 + 收益）
     *  k  可以串行做的项目数
     *  m  初始资金
     *
     * @return  int 返回最大得到的金钱数量
     */
    private static int getMaxEarning(int[] pCost, int[] pEarn, int k, int m){

        if(pCost.length == 0 || pEarn.length == 0){
            return 0;
        }

        HashMap<Integer, Integer> pCostMap = new HashMap<>();
        HashMap<Integer, Integer> pEarnMap = new HashMap<>();
        int pCostLen = pCost.length;
        int pEarnLen = pEarn.length;
        for(int i = 0; i < pCostLen && i < pEarnLen; i ++){
            pCostMap.put(i,pCost[i]);
            pEarnMap.put(i,pEarn[i]);
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        int pNum = k;
        int initMoney = m;
        for (int i =0 ; i < pCost.length; i++) {
            minHeap.add(pCost[i]);
        }
        while (pNum > 0){

        }




        return 0;


    }


}
