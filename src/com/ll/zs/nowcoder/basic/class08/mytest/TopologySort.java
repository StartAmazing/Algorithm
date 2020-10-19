package com.ll.zs.nowcoder.basic.class08.mytest;

import java.util.*;

/**
 * 图的拓扑排序
 * 有向且无环的
 */
public class TopologySort {

    public static List<Node> sortedTopology(Graph graph){
        HashMap<Node, Integer> inMap = new HashMap<>();
        Queue<Node> zeroInQueue = new LinkedList<>();
        //将所有的图中节点放入hashmap中，其中k是该节点，v是该节点的入度
        //将所有的图中节点中入度为0的节点放到 队列中
        graph.nodes.values().forEach(a -> {
            inMap.put(a, a.in);
            if(a.in == 0){
                zeroInQueue.add(a);
            }
        });
        //结果集合
        List<Node> result = new ArrayList<>();
        //每次相当于删除上一步入度为零对它next入度值得影响
        while(!zeroInQueue.isEmpty()){
            Node cur = zeroInQueue.poll();
            result.add(cur);
            cur.nexts.forEach(next -> {
                inMap.put(next,inMap.get(next) - 1);
                if(inMap.get(next) == 0){
                    zeroInQueue.add(next);
                }
            });
        }
        return result;
    }

    public static void main(String[] args) {
        Integer[][] matrix = new Integer[][]{
                {0,2,1},{0,3,1},{0,4,1},{0,3,2},{0,5,2},{0,5,4}};
        Graph graph = GraphGenerator.createGraph(matrix);
        List<Node> nodes = sortedTopology(graph);
        nodes.forEach(a -> {
            System.out.println(a.value);
        });


    }
}
