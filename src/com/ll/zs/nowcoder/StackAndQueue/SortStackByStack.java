package com.ll.zs.nowcoder.StackAndQueue;

import java.util.Stack;

/**
 * 一个栈元素的类型为整形，现在想将栈从栈顶到底按从大到小的顺序排序，只许
 * 申请一个栈，除此之外可以申请新额外的变量，但不能申请额外的数据结构。
 */

public class SortStackByStack {

    public static void sortStack(Stack<Integer> stack){
        Stack<Integer> help = new Stack<>();
        while(!stack.isEmpty()){
            int cur = stack.pop();
            while (help.isEmpty() && cur > help.peek()){
                stack.push(help.pop());
            }
            help.push(cur);
        }
        while(!help.isEmpty()){
            stack.push(help.pop());
        }
    }
}
