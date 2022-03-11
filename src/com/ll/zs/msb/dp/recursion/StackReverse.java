package com.ll.zs.msb.dp.recursion;

import com.ll.zs.msb.util.StackTools;

import java.util.Stack;

/**
 * 给你一个栈，不申请额外的数据结构
 * 只能使用递归函数
 */
public class StackReverse<T> {
    public void stackReverse(Stack<T> aStack) {
        if (aStack.isEmpty()) {
            return;
        }
        T res = getBottomElementFromStack(aStack);
        stackReverse(aStack);
        aStack.push(res);
    }
    public T getBottomElementFromStack(Stack<T> stack) {
        if (stack.isEmpty()) {
            return null;
        }
        T res = stack.pop();
        if (stack.isEmpty()) {
            return res;
        } else {
            T last = getBottomElementFromStack(stack);
            stack.push(res);
            return last;
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        StackReverse<Integer> dto = new StackReverse<>();
        StackTools.printStack(stack);
        System.out.println();
        dto.stackReverse(stack);
        StackTools.printStack(stack);
    }
}
