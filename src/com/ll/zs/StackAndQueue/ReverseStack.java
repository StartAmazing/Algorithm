package com.ll.zs.StackAndQueue;

import java.util.Stack;

public class ReverseStack {

    public static void main(String[] args) {
        Stack<Integer> stack  = new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        reverse(stack);
        System.out.println(stack.size());
        for(int i = 0 ;i < stack.size() ; i++ ){
            System.out.println(stack.pop());
        }
    }
    public static int getAndRemoveLastElemnet(Stack<Integer> stack){
        int result = stack.pop();
        if(stack.isEmpty()){
            return result;
        }else{
            int last = getAndRemoveLastElemnet(stack);
            stack.push(result);
            return last;
        }
    }
    public static void reverse(Stack<Integer> stack){
        if(stack.isEmpty()){
            return;
        }
        int i = getAndRemoveLastElemnet(stack);
        reverse(stack);
        stack.push(i);
    }



}
