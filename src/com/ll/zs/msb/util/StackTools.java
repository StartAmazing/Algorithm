package com.ll.zs.msb.util;

import java.util.Stack;

public class StackTools {
    public static void printStack(Stack<Integer> aStack) {
        Stack<Integer> stack = new Stack<>();
        System.out.print("res: ");
        while (!aStack.isEmpty()) {
            int aEle = aStack.pop();
            System.out.print(aEle + ", ");
            stack.push(aEle);
        }

        while (!stack.isEmpty()) {
            aStack.push(stack.pop());
        }
    }
}
