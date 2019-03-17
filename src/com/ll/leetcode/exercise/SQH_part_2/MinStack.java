package com.ll.leetcode.exercise.SQH_part_2;

import java.util.Stack;

//设计一个栈，支持一下操作，这些操作的算法复杂度都是常数级，O(1)
//leetocde 155 MinStack
public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> min;

    public MinStack(){
        this.stack = new Stack<>();
        this.min = new Stack<>();
    }
    public void push(int x){
        stack.push(x);
        if(min.isEmpty() || min.peek() > x){
            min.push(x);
        }
    }

    public int pop(){
        if(stack.isEmpty()){
            throw new RuntimeException("The Stack is already empty!");
        }
        if(min.peek() == stack.peek()){
            min.pop();
        }
        return stack.pop();
    }

    public int peek(){
        if(stack.isEmpty()){
            throw new RuntimeException("The Stack is already empty!");
        }
        return stack.pop();
    }

    public int getMin(){
        if(stack.isEmpty()){
            throw new RuntimeException("The Stack is already empty!");
        }
        return min.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(77);
        minStack.push(7);
        minStack.push(23);
        minStack.push(88);
        minStack.push(12);
        minStack.push(4);
        minStack.push(66);
        minStack.push(19);

        int min = minStack.getMin();
        System.out.println(min);

        minStack.pop();
        minStack.pop();
        minStack.pop();
        minStack.pop();
        minStack.pop();

        min = minStack.getMin();
        System.out.println(min);


    }


}
