package com.ll.zs.StackAndQueue;


import java.util.LinkedList;
import java.util.Queue;

public class TwoQueueStack {
    private Queue<Integer> data;
    private Queue<Integer> help;

    public TwoQueueStack(){
        data = new LinkedList<Integer>();
        help = new LinkedList<Integer>();
    }

    public void push(int pushInt){
        data.add(pushInt);
    }

    public void swap(){
        Queue<Integer> tmp = new LinkedList<Integer>();
        tmp = data;
        data = help;
        help = tmp;
    }

    public int peek(){
        if(data.isEmpty()){
            throw new RuntimeException("The stack is empty!");
        }
        while(data.size() != 1){
            help.add(data.poll());
        }
        int res = data.poll();
        help.add(res);
        swap();
        return res;
    }
    public int poll(){
        if(data.isEmpty()) {
            throw new RuntimeException("The stack is still empty");
        }
        while(data.size() != 1){
            help.add(data.poll());
        }
        int res = data.poll();
        swap();
        return res;
    }
}
