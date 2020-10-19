package com.ll.zs.nowcoder.StackAndQueue.getMinStack;

import java.util.Stack;

/**
 * 设计一个有getMin()的栈来获取栈中元素的最小值（2）
 */

public class StackForGetmin2 {
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public StackForGetmin2(){
        this.stackData = new Stack<>();
        this.stackMin = new Stack<>();
    }
    public static void main(String[] args){
        StackForGetmin2 testStack = new StackForGetmin2();
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
        }else {
            this.stackMin.push(this.stackMin.peek());
        }
        this.stackData.push(newNum);
    }
    public int pop(){
        if(this.stackData.isEmpty()){
            throw new RuntimeException("the stack is already empty");
        }
        this.stackMin.pop();
        return stackData.pop();
    }
    public int getMin(){
        if(this.stackMin.isEmpty()){
            throw new RuntimeException("the stack is already empty");
        }
        return this.stackMin.peek();
    }


}
