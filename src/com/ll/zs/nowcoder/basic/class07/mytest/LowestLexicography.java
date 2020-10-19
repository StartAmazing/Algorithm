package com.ll.zs.nowcoder.basic.class07.mytest;

import java.util.Arrays;
import java.util.Comparator;

//给出一个String类型的数组，要求将数组中的所有字符串拼接起来
//要求最后得到的字符串按字典序排列最小
public class LowestLexicography {
    public static class MyComparator implements Comparator<String>{
        //证明：该排序策略具有传递性，也就是排序策略的正确性
        /** 有ab、ba,bc、cb，其中 ab <= ba , bc <= cb
         * 证明 ac <= ca
         * ab <= ba -->  a * m(b) + b <= b * m(a) + a  -两边同时减b再乘c-> a * c * m(b) <= b * m(a) * c + a * c - b * c
         * bc <= cb -->  b * m(c) + c <= c * m(b) + b  -两边同时减b再乘a-> a * b * m(c) + a * c - b * a <= a * c * m(b)
         * 得到： a * b * m(c) + a * c - b * a <= b * m(a) * c + a * c - b * c
         * 得到： a * m(c) - a <= m(a) * c  -  c
         * 得到： a * m(c) + c <= c * m(a) + a
         * 即： ac <= ca
         */
        @Override
        public int compare(String o1, String o2) {
            return (o1 + o2).compareTo(o2 + o1);
        }
    }

    /**
     * 需要证明在根据以上排序策略排序过后的字符串数组中，
     * 如果再调换任意两个字符串的位置，最后拼接得到的序列
     * 都不是按照最小字典顺序排列的字符串
     * 假设字符串当前序列（也就是此种比较策略下得到的最小字典序）为：
     * .....a m1 m2 m3 .... mk b....
     * 那么根据比较器中的证明，有： .....a m1 m2 m3 .... mk b.... <= .....m1 a m2 m3 .... mk b....
     * 那么最后有： .....a m1 m2 m3 .... mk b.... <= .....m1 m2 m3 .... mk b a....
     * 那么最后有： .....a m1 m2 m3 .... mk b.... <= .....b m1 m2 m3 .... mk a....
     *
     *
     */
    public static String lowestString(String[] strs){
        if(strs == null || strs.length == 0){
            return "";
        }
        Arrays.sort(strs,new MyComparator());
        String res = "";
        for (int i = 0; i < strs.length; i++){
            res += strs[i];
        }
        return res;
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"b","ba"};
        System.out.println(lowestString(strs));
    }
}
