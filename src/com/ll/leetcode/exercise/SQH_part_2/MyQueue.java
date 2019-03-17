package com.ll.leetcode.exercise.SQH_part_2;

import java.util.Stack;

//使用栈实现队列，支持基本的队列操作，这个队列的内部存储数据的结构为栈
//站的方法包括push、pop、peek、size、empty等标准的栈方法
public class MyQueue {

    private Stack<Integer> stack;
    public MyQueue(){
        this.stack = new Stack<>();
    }

    public void add(int x){
        stack.push(x);
    }

    public int remove(){
        if(stack.isEmpty()){
            throw new RuntimeException("The stack is already empty!");
        }
        Stack<Integer> temp = new Stack<>();
        while(stack.size() != 1){
            temp.push(stack.pop());
        }
        int res = stack.pop();
        while(!temp.isEmpty()){
            stack.push(temp.pop());
        }
        return res;
    }
    public int peek(){
        if(stack.isEmpty()){
            throw new RuntimeException("The stack is already empty!");
        }
        Stack<Integer> temp = new Stack<>();
        while(stack.size() != 1){
            temp.push(stack.pop());
        }
        int res = stack.peek();
        while(!temp.isEmpty()){
            stack.push(temp.pop());
        }
        return res;
    }
    public boolean isEmpty(){
        return stack.isEmpty();
    }
    public int size(){
        return stack.size();
    }
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();

        System.out.println(queue.size());
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.add(6);

        System.out.println(queue.size());

        queue.add(7);
        System.out.println(queue.size());

        queue.remove();
        int r = queue.remove();
        System.out.println(r);
        System.out.println(queue.size());

        r = queue.peek();
        System.out.println(r);
        System.out.println(queue.size());

        System.out.println(queue.isEmpty());


    }

}

class MyQueue2{
    private Stack<Integer> mainStack;
    private Stack<Integer> helpStack;

    public MyQueue2(){
        this.mainStack = new Stack<>();
        this.helpStack = new Stack<>();
    }

    public void add(int x){
        mainStack.push(x);
    }

    public int remove(){
        while(mainStack.size()!=1){
            helpStack.push(mainStack.pop());
        }
        int res = mainStack.pop();
        swap();
        return res;
    }

    public int peek(){
        if(mainStack.isEmpty())
        {
            throw new RuntimeException("The queue is already empty!");
        }
        if(mainStack.isEmpty())
        {
            throw new RuntimeException("The queue is already empty!");
        }
        while(mainStack.size()!=1){
            helpStack.push(mainStack.pop());
        }
        int res = mainStack.peek();
        swap();
        return res;
    }

    public boolean isEmpty(){
        return mainStack.isEmpty();
    }

    public void swap(){
        Stack<Integer> tmp = mainStack;
        mainStack = helpStack;
        helpStack = tmp;
    }
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();

        System.out.println(queue.size());
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.add(6);

        System.out.println(queue.size());

        queue.add(7);
        System.out.println(queue.size());

        queue.remove();
        int r = queue.remove();
        System.out.println(r);
        System.out.println(queue.size());

        r = queue.peek();
        System.out.println(r);
        System.out.println(queue.size());

        System.out.println(queue.isEmpty());


    }
}



