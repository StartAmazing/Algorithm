package com.ll.zs.nowcoder.basic.class08.mytest;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

//宽度优先遍历
public class Graph_1_BFS {

    public static void bfs(Node node){
        if (node == null){
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        //set用来判断该node节点是否之前被遍历过
        HashSet<Node> set = new HashSet<>();
        queue.add(node);
        set.add(node);
        while (!queue.isEmpty()){
            Node cur = queue.poll();
            System.out.println(cur.value + " ");
            cur.nexts.forEach(a ->{
                if (!set.contains(a)) {
                    set.add(a);
                    queue.add(a);
                }
            });
        }
    }


}
