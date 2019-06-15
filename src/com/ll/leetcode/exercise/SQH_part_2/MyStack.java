package com.ll.leetcode.exercise.SQH_part_2;

import java.util.LinkedList;
import java.util.Queue;

//设计一个栈，支持基本的栈操作，这个栈的内部存储数据结构为队列，队列的方法只能包括push、peek、pop、size、empty等标准的队列方法
//LeetCode 225 ImplementStackUsingQueues
public class MyStack {
    public Queue<Integer> data;
    public Queue<Integer> help;

    public MyStack(){
        data = new LinkedList<>();
        help = new LinkedList<>();
    }

    public void push(int x){
        data.add(x);
    }

    public void swap(){
        Queue<Integer> tmp = new LinkedList<>();
        tmp = data;
        data = help;
        help = tmp;
    }

    public int pop(){
        if(data.isEmpty()){
            throw new RuntimeException("Your Stack is Empty");
        }
        while(data.size() != 1){
            help.add(data.poll());
        }
        int res = data.poll();
        swap();
        return res;
    }

    public int peek(){
        if(data.isEmpty()){
            throw new RuntimeException("Your Stack is Empty");
        }
        while(data.size() != 1){
            help.add(data.poll());
        }
        int res = data.peek();
        help.add(data.poll());
        swap();
        return res;
    }

    public boolean isEmpty(){
        return data.isEmpty();
    }

    public static void main(String[] args) {
        MyStack ms = new MyStack();
        System.out.println(ms.isEmpty());
        ms.push(1);
        ms.push(2);
        ms.push(3);

        System.out.println(ms.pop());
        System.out.println(ms.pop());

        ms.push(10);
        ms.push(13);
        ms.push(15);

        System.out.println(ms.peek());

        ms.pop();

        System.out.println(ms.peek());
    }
}

class Mystack2{
    public Queue<Integer> data;
    public Mystack2(){
        data = new LinkedList<>();
    }
    public int pop(){
        if(data.isEmpty()){
            throw new RuntimeException("Your Stack is Empty");
        }
        return data.poll();
    }
    public int peek(){
        if(data.isEmpty()){
            throw new RuntimeException("Your Stack is Empty");
        }
        return data.peek();
    }
    public boolean isEmpty(){
        return data.isEmpty();
    }
    public void push(int x){
        Queue<Integer> tmp = new LinkedList<>();
        tmp.add(x);     //对新元素先加入到临时链表中
        while(!data.isEmpty()){
            tmp.add(data.poll());
        }
        while(!tmp.isEmpty()){
            data.add(tmp.poll());
        }
    }

    public static void main(String[] args) {
        MyStack ms = new MyStack();
        System.out.println(ms.isEmpty());
        ms.push(1);
        ms.push(2);
        ms.push(3);

        System.out.println(ms.pop());
        System.out.println(ms.pop());

        ms.push(10);
        ms.push(13);
        ms.push(15);

        System.out.println(ms.peek());

        ms.pop();

        System.out.println(ms.peek());
    }
}