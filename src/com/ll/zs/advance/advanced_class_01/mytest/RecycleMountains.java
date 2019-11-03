package com.ll.zs.advance.advanced_class_01.mytest;

import java.util.Stack;

/**
 * 网易/JD面试
 * 数组环形山峰，
 * 给出一个数组，想象将其首尾相连组成一个环形结构
 * 规定任意两个元素键，如果相邻则称之为相互可见
 * 如果不相邻则如果他们之间不存在大于这两个数之间
 * 最小值的数（顺时针和逆时针），那么也称之为相互可见
 * ，问数组中一共存在多少组数相互可见？
 *
 */
public class RecycleMountains {

    //用来作为单调栈中存放的元素结构
    public static class Pair{
        public int value;;
        public int times;
        public Pair(int value){
            this.value = value;
            this.times = 1;
        }
    }

    public static long communications(int[] arr){
        if(arr == null || arr.length < 2){
            return 0;
        }
        int size = arr.length;
        int maxIndex = 0;
        for(int i = 0 ; i < size ; i ++){       //找到数组中的最大值
            maxIndex = arr[maxIndex] > arr[i] ? maxIndex : i;
        }
        int value = arr[maxIndex];  //最大值
        int index = nextIndex(size, maxIndex);  //环形的数组中，最后一个数的下一个数，这里是最大值得下一个数
        long res = 0L;
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(value));        //最大值，也就是开始遍历的位置
        while (index != maxIndex){      //如果回到最大值的时候，遍历结束
            value = arr[index];
            while (!stack.isEmpty() && stack.peek().value < value){
                int times = stack.pop().times;
//                res += getInsternalSum(times) + times;
//                res += stack.isEmpty() ? 0 : times;       //最大值打底，这里栈不可能为空
                res += getInsternalSum(times) + 2 * times; //C(2,times) + 2 * times
            }
            if(!stack.isEmpty() && stack.peek().value == value){
                stack.peek().times ++;
            }else {
                stack.push(new Pair(value));
            }
            index = nextIndex(size,index);
        }

        //最后的结算
        while (!stack.isEmpty()){
            int times = stack.pop().times;
            res += getInsternalSum(times);
            if(!stack.isEmpty()){
                res += times;
                if(stack.size() > 1){
                    res += times;       //不是倒数第二
                }else {
                    res += stack.peek().times > 1 ? times : 0;  //倒数第二，如果栈底元素lastTimes为1，加0，如果大于1，加curTimes
                }
            }
        }
        return res;
    }

    private static int nextIndex(int size, int i){
        return i < (size - 1 ) ? (i + 1) : 0;
    }

    private static long getInsternalSum(int n){
        return n == 1L ? 0L : (long) n * (long)(n - 1);
    }


}
