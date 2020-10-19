package com.ll.zs.nowcoder.StackAndQueue;

public class ArrayStack {
    private int[] arr;
    private Integer index;

    public ArrayStack(int initSize){
        if(initSize < 0){
            throw new IllegalArgumentException("illegal initSize,please check it >= 0");
        }
        arr = new int[initSize];
        index = 0;
    }

    public void push(int newNum){
        if(this.index == this.arr.length){
            throw new RuntimeException("The Stack is already full");
        }
        this.arr[index++] = newNum;
    }
    public Integer peek(){
        if(this.index == 0){
            throw new RuntimeException("The stack is still empty");
        }
        int tmp = this.index - 1;
        return this.arr[tmp];
    }
    public Integer pop(){
        if(this.index == 0){
            throw new RuntimeException("The stack is still empty");
        }
        return this.arr[--this.index];
    }

    public static void main(String[] args){
        ArrayStack arrayStack = new ArrayStack(3);
        arrayStack.push(1);
        arrayStack.push(2);
        arrayStack.push(3);
        System.out.println(arrayStack.index);
        System.out.println(arrayStack.peek());
        System.out.println(arrayStack.peek());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.peek());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
    }
}
