package com.ll.zs.nowcoder;

import java.util.LinkedList;
import java.util.Queue;

public class TwoQueue2Stack {

    private Queue<Integer> data;
    private Queue<Integer> help;

    public TwoQueue2Stack() {
        data = new LinkedList<Integer>();
        help = new LinkedList<Integer>();
    }

    public int peek() {
        if (data.isEmpty()) {
            throw new RuntimeException("no data!");
        }
        while (data.size() != 1) {
            help.add(data.poll());
        }
        int res = data.poll();
        help.add(res);
        return res;
    }


    public int pop() {
        if (data.isEmpty()) {
            throw new RuntimeException("no data!");
        }
        while(data.size() != 1){
            help.add(data.poll());
        }
        int res = data.poll();
        swapHelpAndData();
        return res;
    }


    public void push(int value) {
        data.add(value);
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    private void swapHelpAndData() {
        Queue<Integer> tmp;
        tmp = data;
        data = help;
        help = tmp;
    }


    public static void main(String[] args) {
        TwoQueue2Stack stack = new TwoQueue2Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
