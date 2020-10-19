package com.ll.zs.nowcoder.StackAndQueue;

//有一个整形数组arr和一个大小为w的窗口从数组的最左边移到数组的最右边，窗口每次向右边滑一个位置


import java.util.LinkedList;

/**
 * 例如，数组为[4,3,5,4,3,3,6,7],窗口大小为3的时候：
 * [4,3,5],4,3,3,6,7        窗口中最大值为5
 * 4,[3,5,4],3,3,6,7        窗口中最大值为5
 * 4,3,[5,4,3],3,6,7        窗口中最大值为5
 * 4,3,5,[4,3,3],6,7        窗口中最大值为4
 * 4,3,5,4,[3,3,6],7        窗口中最大值为6
 * 4,3,5,4,3,[3,6,7]        窗口中最大值为7
 * 如果数组长度为n,窗口大小为n，窗口大小为w,则一共产生n-w+1
 * 实现一个函数。
 *     输入：整形数组arr,窗口大小w,
 *     输出：一个长度大小为n-w+1的数组res,res[i]表示每一种状态下的最大值
 * 例如本例子中输出结果应该为[5,5,5,4,6,7]
 * 时间复杂度要求为O(N)---使用双端队列
 */
public class GetMaxWindow {
    public static int[] getMaxWindowArray(int[] arr, int w){
        if(arr == null || w <= 0 || arr.length < w){
            return null;
        }
        LinkedList<Integer> qmax = new LinkedList<Integer>();
        int[] res = new int[arr.length - w + 1];
        int index = 0;
        for(int i = 0; i < arr.length; i++){
            while(!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i]){
                qmax.pollLast();
            }
            qmax.addLast(i);
            if(qmax.peekFirst() == i - w){  //如果过期  注意i是从0开始的，而 w 固定
                qmax.pollFirst();
            }
            if(i >= w - 1){
                res[index++] = arr[qmax.peekFirst()];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr={4,3,5,4,3,3,6,7};
        int[] res = getMaxWindowArray(arr, 3);
        int len = 0;
        System.out.print("[");
        for (int v:
             res) {
            System.out.print(v + "");
            len ++;
            if(len!=res.length){
                System.out.print(" ,");
            }
        }
        System.out.print("]");
    }
}
