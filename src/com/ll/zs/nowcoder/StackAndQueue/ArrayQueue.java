package com.ll.zs.nowcoder.StackAndQueue;

public class ArrayQueue {
    private Integer[] arr;
    private int size;
    private int start;
    private int end;

    public ArrayQueue(int initSize){
        if(initSize < 0){
            throw new IllegalArgumentException("The init size cannot smaller than zero");
        }
        arr = new Integer[initSize];
        size = 0;
        start = end = 0;
    }
    public void push(Integer newNum){
        if(size == arr.length){
            throw new RuntimeException("The queue is still full");
        }
        size++;
        arr[end] = newNum;
        end = end == arr.length - 1? 0: end + 1;
    }
    public Integer peek(){
        if(size == 0){
            throw new RuntimeException("The queue is still empty");
        }
        return arr[start];
    }
    public Integer pop(){
        if(size == 0){
            throw new RuntimeException("The queue is still empty");
        }
        Integer tmp = arr[start];
        start = (start == arr.length-1) ? 0 : start + 1;
        size--;
        return tmp;
    }
    public static void main(String[] args){
        ArrayQueue arrayQueue = new ArrayQueue(3);
        arrayQueue.push(1);
        arrayQueue.push(2);
        arrayQueue.push(3);
        System.out.println(arrayQueue.size);    //3
        System.out.println(arrayQueue.peek());  //1
        System.out.println(arrayQueue.pop());   //1
        System.out.println(arrayQueue.pop());   //2
        System.out.println(arrayQueue.size);   //1
        arrayQueue.pop();
        arrayQueue.pop();
    }
}
