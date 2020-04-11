package com.ll.lintcode.basic.hash_heap;

import java.util.*;

/**
 * 实现一个数据结构，提供下面两个接口
 * 1.add(number) 添加一个元素
 * 2.topk() 返回前K大的数
 *
 * 样例
 * 样例1
 *
 * 输入:
 * s = new Solution(3);
 * s.add(3)
 * s.add(10)
 * s.topk()
 * s.add(1000)
 * s.add(-99)
 * s.topk()
 * s.add(4)
 * s.topk()
 * s.add(100)
 * s.topk()
 *
 * 输出:
 * [10, 3]
 * [1000, 10, 3]
 * [1000, 10, 4]
 * [1000, 100, 10]
 *
 * 解释:
 * s = new Solution(3);
 * >> 生成了一个新的数据结构, 并且 k = 3.
 * s.add(3)
 * s.add(10)
 * s.topk()
 * >> 返回 [10, 3]
 * s.add(1000)
 * s.add(-99)
 * s.topk()
 * >> 返回 [1000, 10, 3]
 * s.add(4)
 * s.topk()
 * >> 返回 [1000, 10, 4]
 * s.add(100)
 * s.topk()
 * >> 返回 [1000, 100, 10]
 * 样例2
 *
 * 输入:
 * s = new Solution(1);
 * s.add(3)
 * s.add(10)
 * s.topk()
 * s.topk()
 *
 * 输出:
 * [10]
 * [10]
 *
 * 解释:
 * s = new Solution(1);
 * >> 生成了一个新的数据结构, 并且 k = 1.
 * s.add(3)
 * s.add(10)
 * s.topk()
 * >> 返回 [10]
 * s.topk()
 * >> 返回 [10]
 */
public class TopKLargestElements_545  {

    int k;
    PriorityQueue<Integer> pq;
    public TopKLargestElements_545(int k) {
        pq = new PriorityQueue<>((o1, o2) -> o1 - o2 < 0 ? 1 : -1);
        this.k = k;
    }
    public void add(int num) {
        pq.offer(num);
    }
    public List<Integer> topk() {

        List<Integer> res = new ArrayList<>();

        for(int i = 0; i < k && !pq.isEmpty() ; i++){
            res.add(pq.poll());
        }

        for (Integer re : res) {
            pq.offer(re);
        }

        return res;
    }
}

//version 2
class PerferVersion{

    int k;
    Queue<Integer> pq;
    public PerferVersion(int k){
        pq = new PriorityQueue<>();
        this.k = k;
    }

    public void add(int num) {
        if(pq.size() < k) {
            pq.offer(num);
        }else{
            if (pq.peek() < num){
                pq.poll();
                pq.offer(num);
            }
        }
    }
    public List<Integer> topk() {
        List<Integer> res = new ArrayList<>();
        Iterator<Integer> iterator = pq.iterator();
        while (iterator.hasNext()){
            res.add(iterator.next());
        }
        Collections.sort(res, Collections.reverseOrder());
        return res;
    }
}