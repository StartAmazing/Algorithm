package com.ll.zs.nowcoder.basic.class08.mytest;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

//最小生成树算法
//同Kruskal算法不同，Prime算法主要是以点为核心进行考虑，
//开始时从图中任意选择一个点作为起始点，拿到该节点对应的
//所有边，从中选择出最小权重的一条边，判断连接到改变的节
// 点是否已连接过，已连接过就跳过重新找一个节点，否则将新
// 节点连接到的所有边加入边集合
public class Prim {
    public static class EdgeComparator implements Comparator<Edge>{

        @Override
        public int compare(Edge o1, Edge o2) {
            return o1.weight - o2.weight;
        }
    }

    public static Set<Edge> primMST(Graph graph){
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new EdgeComparator());
        //存放遍历过的节点
        HashSet<Node> set = new HashSet<>();
        Set<Edge> result = new HashSet<>();

        //遍历图中所有的节点，nodes是一个HashMap，
        // 通过他的values()方法取得所有的Node数据结构
        //注意，最外层for循环也适用于所谓的多个连通图情况
        //去掉外层for循环只适用于一个题图中只有一个连通图的情况
        graph.nodes.values().forEach(node -> {
            if(!set.contains(node)){
                set.add(node);
                priorityQueue.addAll(node.edges);
                while (!priorityQueue.isEmpty()){
                    Edge edge = priorityQueue.poll();
                    Node toNode = edge.to;
                    if(!set.contains(toNode)){
                        result.add(edge);
                        set.add(toNode);
                        priorityQueue.addAll(toNode.edges);
                    }
                }
            }
        });
        return result;
    }

    public static void main(String[] args) {
            Integer[][] matrix = new Integer[][]{
                    {1, 1, 2},
                    {1, 2, 1},
                    {1, 2, 3},
                    {1, 3, 2},
                    {2, 1, 3},
                    {2, 3, 1},
                    {4, 3, 4},
                    {4, 4, 3},
                    {3, 2, 4},
                    {3, 4, 2},
                    {2, 1, 4},
                    {2, 4, 1}
            };
            Graph graph = GraphGenerator.createGraph(matrix);
            Set<Edge> edges = primMST(graph);
            edges.forEach(a -> {
                System.out.println("edgeWeight: " + a.weight + ", edgeFrom: " + a.from.value + ", edgeTo: " + a.to.value);
            });
        }
}
