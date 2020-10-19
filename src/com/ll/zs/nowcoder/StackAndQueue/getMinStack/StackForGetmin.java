package com.ll.zs.nowcoder.StackAndQueue.getMinStack;

import java.util.Stack;

/**
 * 设计一个有getMin()的栈来获取栈中元素的最小值（1）
 */
public class StackForGetmin {

    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;
    public StackForGetmin(){
        this.stackData = new Stack<Integer>();
        this.stackMin = new Stack<Integer>();
    }

    public static void main(String[] args) {
        StackForGetmin testStack = new StackForGetmin();
        testStack.push(3);
        testStack.push(4);
        testStack.push(5);
        testStack.push(1);
        testStack.push(2);
        testStack.push(1);
        System.out.println(testStack.getMin());
        testStack.pop();
        testStack.pop();
        testStack.pop();
        System.out.println(testStack.getMin());
    }
    public void push(int newNum){
        if(this.stackMin.isEmpty()){
            this.stackMin.push(newNum);
        }else if(this.stackMin.peek() > newNum){
            this.stackMin.push(newNum);
        }
        this.stackData.push(newNum);
    }
    public int pop(){
        if(this.stackData.isEmpty()){
            throw new RuntimeException("the dataStack is already empty");
        }
        if(this.stackData.peek() == this.stackMin.peek()){
            this.stackMin.pop();
        }
        return this.stackData.pop();
    }
    public int getMin(){
        if(this.stackMin.isEmpty()){
            throw new RuntimeException("the minStack is already empty");
        }
        return this.stackMin.peek();
    }
}
