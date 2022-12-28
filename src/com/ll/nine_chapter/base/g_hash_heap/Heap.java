package com.ll.nine_chapter.base.g_hash_heap;

import com.ll.utils.NotPassed;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class Heap {

    /**
     * @link https://www.lintcode.com/problem/517/
     * @param num: An integer
     * @return: true if num is an ugly number or false
     */
    public boolean isUgly(int num) {
        if (num == 1 || num == 2 || num == 3 || num == 5) {
            return true;
        }

        if (num <= 0) {
            return false;
        }

        while(num != 2 && num != 3 && num != 5) {
            if(num % 2 == 0) {
                num = num / 2;
            } else if(num % 3 == 0) {
                num = num / 3;
            } else if(num % 5 == 0) {
                num = num / 5;
            } else {
                break;
            }
        }

        return num == 2 || num == 3 || num == 5;
    }


    /**
     * @link https://www.lintcode.com/problem/4/
     * @param n: An integer
     * @return: return a  integer as description.
     */
    @NotPassed
    public static long nthUglyNumber(int n) {
        Queue<Long> pq = new PriorityQueue<>((o1, o2) -> (int) (o1 - o2));
        Set<Long> set = new HashSet<>();
        int nth = 1;
        int[] generator = new int[]{2, 3, 5};
        set.add(1L);
        pq.offer(1L);
        while(nth < n) {
            long cur = pq.poll();
            for (int i = 0; i < generator.length; i++) {
                long num = cur * generator[i];
                if (!set.contains(num)) {
                    set.add(num);
                    pq.offer(num);
                }
            }
            nth += 1;
        }

        return pq.poll();
    }

    public static void main(String[] args) {
        long nth = nthUglyNumber(1660);
        System.out.println(nth);
    }

}
