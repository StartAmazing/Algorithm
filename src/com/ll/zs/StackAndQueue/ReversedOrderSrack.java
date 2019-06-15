package com.ll.zs.StackAndQueue;

import java.util.Stack;

/**
 * 实现栈的逆序，但是只能用递归函数来实现，不能使用其他数据结构
 */

public class ReversedOrderSrack {

    public static int getAndRemoveLastElement(Stack<Integer> stack){
        int result = stack.pop();
        if(stack.isEmpty()){
            return result;
        }
        else{
            int last = getAndRemoveLastElement(stack);
            stack.push(result);
            return last;
        }
    }

    public static void reverse(Stack<Integer> stack){
        if(stack.isEmpty()){
            return;
        }
        int i = getAndRemoveLastElement(stack);
        reverse(stack);
        stack.push(i);
    }
}
