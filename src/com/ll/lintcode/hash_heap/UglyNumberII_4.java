package com.ll.lintcode.hash_heap;

import com.ll.leetcode.ListNode;

import java.util.*;

public class UglyNumberII_4 {

    //version 1
    public int nthUglyNumber1(int n){
        List<Integer> uglys = new ArrayList<>();
        uglys.add(1);

        int p2 = 0, p3 =0, p5 = 0;
        for (int i = 1; i < n; i ++){
            int lastNumber = uglys.get(i - 1);
            while (uglys.get(p2) * 2 <= lastNumber) p2 ++;
            while (uglys.get(p3) * 3 <= lastNumber) p3 ++;
            while (uglys.get(p5) * 5 <= lastNumber) p5 ++;

            uglys.add(Math.min(Math.min(uglys.get(p2) * 2, uglys.get(p3) * 3), uglys.get(p5) * 5));
        }

        return uglys.get(n - 1);
    }

    public int nthUglyNumber(int n){
        Long[] primes = new Long[3];
        primes[0] = Long.valueOf(2);
        primes[1] = Long.valueOf(3);
        primes[2] = Long.valueOf(5);

        Queue<Long> pq = new PriorityQueue<>();
        Set<Long> set = new HashSet<>();
        for (int i = 0; i < 3; i ++){
            pq.add(primes[i]);
            set.add(primes[i]);
        }
        Long number = Long.valueOf(1);
        for (int i = 1; i < n; i++){
            number = pq.poll();
            for (int j = 0; j < 3; j ++){
                if (!set.contains(primes[i] * number)){
                    pq.add(primes[i] * number);
                    set.add(primes[i] * number);
                }
            }
        }

        return number.intValue();
    }
}
