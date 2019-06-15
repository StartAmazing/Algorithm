package com.ll.leetcode.exercise.greed_part_3;

import java.util.Comparator;
import java.util.List;
import java.util.Vector;

/**
 *
 * 1、分糖果
 *
 * 已知一些孩子和一些糖果，每个孩子有需求因子g，每个糖果大小为s,
 * 当某个糖果大小s>=某个孩子的需求因子g时，代表该糖果可以满足该
 * 孩子；求使用这些糖果，最多可以满足多少个孩子？（注意，每个孩
 * 子最多只能用一个糖果满足）
 *
 * 例如，需求因子数组g=[5,10,2,9,15,9]
 *       糖果大小数组s=[6,1,20,3,8]
 *       最多可以满足3个孩子
 *
 *       leetCode 455
 *       It's easy
 *
 * 1、当某个孩子可以被多个糖果满足时，是否需要优先用某个糖果糖果满足这个孩子？
 * 2、当某个糖果可以满足多个孩子时，是否需要优先满足某个孩子？
 *
 * 规律：
 *  1、某个孩子如果不能满足某个孩子，则该糖果也一定不能满足需求因子更大的孩子
 *  2、某个孩子可以用更小的糖果满足，则没有必要用更大的糖果满足，因为可以保留
 *     更大的糖果满足需求因子更大的孩子（贪心）
 *  3、孩子的需求因子更小则更容易被满足，故优先从需求因子小的孩子尝试，可以得
 *     到正确的结果
 * 算法思路：
 *  1、对需求因子数组g与糖果大小数组s进行从小到大的排序
 *  2、按照从小到大的顺序使用各糖果尝试是否可以满足某个孩子，每个糖果只尝试一次；
 *     若尝试成功，则换下一个孩子尝试；知道发现没有更多的孩子或者没有更多的糖果，
 *     循环结束
 *
 *  也就是说尽量使用大的糖果去满足较大需求的孩子，用较小的糖果去满足较小需求的孩子
 *
 */


public class AssignCookies {
    private static int findContentChildren(Vector<Integer> g, Vector<Integer> s){

        g.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        s.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        int child = 0;  //代表已经满足了几个孩子
        int cookie = 0;     //尝试代表尝试了几个糖果
        while(child < g.size() && cookie < s.size()){       //当孩子或糖果同时均未尝试完时
            if(g.get(child) <= s.get(cookie)){      //当孩子的满足因子小于或等于糖果大小时
                child ++;   //该糖果满足了孩子，孩子指针child向后移动
            }
            cookie ++;  //无论成功或失败，每个糖果只尝试一次，cookie向后移动
        }
        return child;       //最终child值为满足的孩子个数
    }

    public static void main(String[] args) {
        Vector<Integer> children = new Vector<>();
        children.add(5);
        children.add(10);
        children.add(2);
        children.add(9);
        children.add(15);
        children.add(9);

        Vector<Integer> cookies = new Vector<>();
        cookies.add(6);
        cookies.add(1);
        cookies.add(20);
        cookies.add(3);
        cookies.add(8);

        int nums = findContentChildren(children, cookies);
        System.out.println("最多可以满足" + nums + "个孩子");

    }

}
