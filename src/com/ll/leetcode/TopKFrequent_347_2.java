package com.ll.leetcode;

import java.util.*;

public class TopKFrequent_347_2 {

    private class Freq{
        public int e, freq;
        public Freq(int e, int freq){
            this.e = e;
            this.freq = freq;
        }
    }

    public List<Integer> solution(int[] nums, int k){
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for(int num : nums){
            if(map.containsKey(num))
                map.put(num, map.get(num) + 1);
            else
                map.put(num, 1);
        }
        PriorityQueue<Freq> pq = new PriorityQueue<>(new Comparator<Freq>(){
            @Override
            public int compare(Freq a,Freq b){
                return a.freq - b.freq;
            }
        });
        for(int key: map.keySet()){
            if(pq.size() < k){
                pq.add(new Freq(key,map.get(key)));
            }else if(map.get(key) > pq.peek().freq){
                pq.poll();
                pq.add(new Freq(key, map.get(key)));
            }
        }
        LinkedList<Integer> res = new LinkedList<>();
        while(!pq.isEmpty()){
            res.add(pq.poll().e);
        }
        return res;
    }
}
