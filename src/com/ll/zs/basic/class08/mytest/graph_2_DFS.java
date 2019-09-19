package com.ll.zs.basic.class08.mytest;

import java.util.HashSet;
import java.util.Stack;

//深度优先遍历
public class graph_2_DFS {

    public static void dfs(Node node){
        if(node == null){
            return;
        }
        Stack<Node> stack = new Stack<>();
        HashSet<Node> set = new HashSet<>();
        set.add(node);
        stack.push(node);
        System.out.print(node.value + " ");
        while (!stack.isEmpty()){
            Node cur = stack.pop();
            for(Node a : cur.nexts) {
                if (!set.contains(a)) {
                    stack.push(cur);
                    stack.push(a);
                    System.out.print(a + " ");
                    set.add(a);
                    break;
                }
            }
        }
    }
}
