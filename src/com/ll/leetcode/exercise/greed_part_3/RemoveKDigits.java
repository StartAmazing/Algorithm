package com.ll.leetcode.exercise.greed_part_3;

import java.util.Vector;

/**
 * 已知一个使用字符串表示的非负整数num,将num中的k个数字移除，求移除k个数字以后，
 * 可以获得的最小的可能新数字
 *
 * 输入： num = "1432219", k = 3
 * 在去掉3个数字以后得到很多很多的可能里，如1432,4322,2219,1219，1229...；
 * 其中去掉4,3,2之后得到数字1219最小(num不会以0开头，num长度小于10002)
 *
 *  LeetCode 402 Remove k digits
 *  It's Medium
 *
 */
public class RemoveKDigits {

    private static String removeKdigits(String num, int k){

        Vector<Integer> S = new Vector<>();  //使用Vector当做栈（因为Vector可以遍历）
        StringBuilder res = new StringBuilder();    //存储最终的结果字符串


        for(int i = 0 ; i < num.length(); i++){//从最高位循环扫描数字num
            int number = Integer.parseInt(num.charAt(i) + "");   //将字符型的num转化为整数使用
            while(S.size() != 0 && number < S.lastElement() && k > 0){
                S.removeElementAt(S.size() - 1);
                k --;
            }
//            if ( S.size() == 0 || number > S.lastElement()){  错误
            if ( S.size() != 0 || number != 0){ //size == 0 && num == 0 时不忘“栈”中添加数据
                S.add(number);
            }
        }


        System.out.println(S.toString());
        while (S.size() != 0 && k > 0){     //如果栈不为空，且仍然可以删除数字
            S.removeElementAt(S.size() - 1);
            k --;
        }

//        for(int i = 0; i < S.size(); i++){      //将栈中元素从头开始遍历，存储至result
//            res.append(S.get(i));
//        }
        S.forEach(a -> res.append(a.toString()));

        if("".equals(res.toString())){
            return "0";
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String num = "1432219";
        String res = removeKdigits(num,3);
        String num1 = "100200";
        System.out.println(res);
        System.out.println(removeKdigits(num1,1));
    }
}
