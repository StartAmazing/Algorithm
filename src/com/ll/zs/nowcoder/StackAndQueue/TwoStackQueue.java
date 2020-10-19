package com.ll.zs.nowcoder.StackAndQueue;

import java.util.Stack;

public class TwoStackQueue {
    private Stack<Integer> stackPush;
    private Stack<Integer> stackPop;

    public TwoStackQueue(){
        this.stackPush = new Stack<Integer>();
        this.stackPop = new Stack<Integer>();
    }

    public static void main(String[] args){
        TwoStackQueue twoStackQueue = new TwoStackQueue();
        twoStackQueue.add(3);
        twoStackQueue.add(2);
        twoStackQueue.add(1);
        System.out.println(twoStackQueue.stackPush.size());//3
        System.out.println(twoStackQueue.stackPop.size());//0
        System.out.println(twoStackQueue.poll());//3
        System.out.println(twoStackQueue.stackPush.size());//0
        System.out.println(twoStackQueue.stackPop.size());//2
        System.out.println(twoStackQueue.peek());//2
        System.out.println(twoStackQueue.stackPush.size());//0
        System.out.println(twoStackQueue.stackPop.size());//2
    }

    public void add(int newNum){
        stackPush.push(newNum);
    }

    public int poll(){
        if(this.stackPush.isEmpty() && this.stackPop.isEmpty()){
            throw new RuntimeException("The queue is already empty!");
        }else if (this.stackPop.isEmpty()){
            while(!this.stackPush.isEmpty()) {
                this.stackPop.push(this.stackPush.pop());
            }
        }
        return this.stackPop.pop();
    }

    public int peek(){
        if(this.stackPush.isEmpty() && this.stackPop.isEmpty()){
            throw new RuntimeException("The queue is already empty");
        }else if(this.stackPop.empty()){
            while(!this.stackPush.isEmpty()){
                this.stackPop.push(this.stackPush.pop());
            }
        }
        return this.stackPop.peek();
    }

}
