package com.ll.zs.nowcoder.advance.mytest;

import com.ll.muke.map.LinkedList;

/**
 * 滑动窗口中每次滑动的最大值组成的最大子数组
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
            while (!qmax.isEmpty() && arr[qmax.getLast()]< arr[i]){     //如果新增的数比原来窗口中最右边的数还要大的时候
                qmax.removeLast();
            }
            qmax.addLast(i);   //往队列中存入索引值
            if(qmax.getFirst() == i - w ){      //当前索引i到达的位置与第一个qmax最左边的位置之差为窗口大小的时候，进行缩减
                qmax.removeFirst();
            }
            if(i >= w - 1){     //窗口是否形成，不管是否进行了缩减，自从第一次窗口中含有w个数的时候，往结果集中放入结果
                res[index ++] = arr[qmax.getFirst()];
            }
        }
        return  res;
    }

}
