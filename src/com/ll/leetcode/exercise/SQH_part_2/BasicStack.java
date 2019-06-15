package com.ll.leetcode.exercise.SQH_part_2;

import java.util.Stack;

public class BasicStack {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        if(s.isEmpty()){
            System.out.println("s is empty!");
        }
        s.push(5);
        s.push(6);
        s.push(10);

        System.out.println("s.top = " + s.peek());
        s.pop();
        s.pop();
        System.out.println("s.top = " + s.peek());
        System.out.println("s.size = " + s.size());
    }
}
