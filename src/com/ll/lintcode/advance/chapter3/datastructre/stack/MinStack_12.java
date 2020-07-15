package com.ll.lintcode.advance.chapter3.datastructre.stack;

import java.util.Stack;

public class MinStack_12 {

    public Stack<Integer> dataStack;
    public Stack<Integer> minStack;

    public MinStack_12() {
        minStack = new Stack<>();
        dataStack = new Stack<>();
    }

    /*
     * @param number: An integer
     * @return: nothing
     */
    public void push(int number) {
        dataStack.push(number);
        if (minStack.isEmpty() || minStack.peek() >= number) {
            minStack.push(number);
        } else {
            minStack.push(minStack.peek());
        }
    }

    /*
     * @return: An integer
     */
    public int pop() {
        minStack.pop();
        return dataStack.pop();
    }

    /*
     * @return: An integer
     */
    public int min() {
        return minStack.peek();
    }

}
