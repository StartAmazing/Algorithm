package com.ll.leetcode;

import java.util.ArrayList;
import java.util.TreeMap;

public class IntersectionOfTwoArraysII_350 {

    public int[] solution(int[] nums1, int[] nums2){

        TreeMap<Integer, Integer> map  = new TreeMap<Integer,Integer>();
        for(int num : nums1){
            if(!map.containsKey(num)){
                map.put(num,1);
            }else{
                map.put(num, map.get(num)+1);
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        for(int num : nums2){
            if(map.containsKey(num)){
                list.add(num);
                map.put(num,map.get(num) - 1);
                if(map.get(num) == 0){
                    map.remove(num);
                }
            }
        }
        int[] res = new int[list.size()];
        for(int i = 0 ; i < res.length ; i++){
            res[i] = list.get(i);
        }
        return  res;
    }

}
