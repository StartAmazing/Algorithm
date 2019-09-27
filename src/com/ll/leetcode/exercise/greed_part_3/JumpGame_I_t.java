package com.ll.leetcode.exercise.greed_part_3;

import java.util.Vector;

public class JumpGame_I_t {

    private static boolean isJumpOver(Vector<Integer> vector){

        Vector<Integer> index = new Vector<>();
        for(int i = 0 ; i < vector.size(); i++){
            index.add(vector.get(i) + i);
        }
//        index.forEach(a -> System.out.println(a));
        int jump = 0;
        int end = vector.size();
        int max_index = 0;
        while(jump < end && jump <= max_index){
            if( max_index  < index.get(jump)){
                max_index = index.get(jump);
            }
            jump ++ ;
        }
        return max_index >= end - 1;
    }

    public static void main(String[] args) {
        Vector<Integer> vector = new Vector<>();
        vector.add(3);
        vector.add(1);
        vector.add(1);
        vector.add(0);
        vector.add(4);
        System.out.println(isJumpOver(vector));
    }

}
