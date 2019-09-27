package com.ll.zs.question;

import java.util.Comparator;
import java.util.PriorityQueue;

import org.omg.CORBA.INTERNAL;

/**
 * @author LL
 * @date 2019/8/8
 * @description
 *              有一个源源不断地吐出整数的数据流，假设你有足够的空间来保存吐出的数。
 *              请设计一个名叫MedianHolder的结构，medianHolder可以随时取得之前吐出
 *              所有数的中位数
 * @require
 *              1.如果medianHolder已经保存了吐出的N个数，那么任意时刻将一个新数加入
 *              到MedianHolder的过程，其时间复杂度是O（log N）；
 *              2. 取得已经吐出的第N个整数体的中位数的过程时间复杂度为O(1)
 *
 *
 */
public class Problem_02_MedianHolder {

    //大根堆
    private PriorityQueue<Integer> maxHeap;
    //小根堆
    private PriorityQueue<Integer> minHeap;

    private Problem_02_MedianHolder(){
        this.maxHeap = new PriorityQueue<>();
        this.minHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
    }

    private void addNumber(Integer newNum){
        if(this.maxHeap.size() == 0 && this.minHeap.size() == 0 ){
            this.maxHeap.add(newNum);
        }else if(this.maxHeap.size() == 0 || newNum > this.maxHeap.peek() ){
            this.maxHeap.add(newNum);
        }else{
            this.minHeap.add(newNum);
        }
        if(this.maxHeap.size() - this.minHeap.size() >= 2){
            this.minHeap.add(this.maxHeap.poll());
        }
        if(this.minHeap.size() - this.maxHeap.size() >= 2){
            this.maxHeap.add(this.minHeap.poll());
        }
    }

    public Integer getMedianNumber(){
        int mediaNumber = 0;
        if(this.maxHeap.size() == 0 && this.minHeap.size() == 0){
            return 0;
        }else if(this.maxHeap.size() == this.minHeap.size()){
            return (this.maxHeap.peek() + this.minHeap.peek()) / 2;
        }else{
            return this.maxHeap.size() > this.minHeap.size() ? this.maxHeap.peek() : this.minHeap.peek();
        }
    }

    public static void main(String[] args) {

        Problem_02_MedianHolder problem = new Problem_02_MedianHolder();

        problem.addNumber(11);
//        problem.addNumber(17);
//        problem.addNumber(13);
//        problem.addNumber(18);
//        problem.addNumber(9);
//        problem.addNumber(21);
//        problem.addNumber(28);

        System.out.println(problem.getMedianNumber());
    }




}
