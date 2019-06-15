package com.ll.leetcode.exercise.SQH_part_2;

import java.util.LinkedList;
import java.util.Queue;

public class BasicQueue {
    public static void main(String[] args) {
        LinkedList<Integer> q = new LinkedList<>();
        if(q.isEmpty()){
            System.out.println("q is empty!");
        }
        q.add(5);
        q.add(6);
        q.add(10);
        System.out.println("q.front = " + q.getFirst());
        q.remove();
        q.remove();
        System.out.println("q.front = " + q.getFirst());
        q.add(1);
        System.out.println("q.back = " + q.getLast());
        System.out.println("q.size = " + q.size());
    }
}
