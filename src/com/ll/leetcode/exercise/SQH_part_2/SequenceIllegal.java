package com.ll.leetcode.exercise.SQH_part_2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//已知从1至n的数字序列，按顺序入栈，每个数字入栈后即可出栈，也可以在栈中停留
//等待后面的数字入栈出栈后，该数字再出栈，求该数字序列的出栈序列是否合法---O(n)
public class SequenceIllegal {
    /**
     * @param order 为检查序列（存储在队列中）
     * @param arr 为模拟线
     * @return
     */
    public static boolean cheack_is_valid_order(LinkedList<Integer> order,int[] arr){
        Stack<Integer> S = new Stack<>();
        int n = order.size();   //n为序列长度，将1-n按顺序入栈
        for(int i = 0; i < n; i++){
            S.push(arr[i]);
            while(!S.isEmpty() && S.peek() == order.peek()){
                S.pop();
                order.pop();
            }
        }
        if(!S.isEmpty()){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = {2,1,3,4,5};
        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.add(3);
        queue.add(2);
        queue.add(5);
        queue.add(4);
        queue.add(1);
        boolean b = cheack_is_valid_order(queue, arr);
        System.out.println(b);

        LinkedList<Integer> queue1 = new LinkedList<Integer>();
        queue1.add(3);
        queue1.add(1);
        queue1.add(2);
        queue1.add(5);
        queue1.add(4);
        b = cheack_is_valid_order(queue1,arr);
        System.out.println(b);
    }
}
