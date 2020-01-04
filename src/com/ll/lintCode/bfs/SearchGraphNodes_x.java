package com.ll.lintCode.bfs;

import com.ll.lintCode.utils.UndirectedGraphNode;

import java.util.*;

public class SearchGraphNodes_x {

    public UndirectedGraphNode searchNode(List<UndirectedGraphNode> graph,
                                          Map<UndirectedGraphNode,Integer> values,
                                          UndirectedGraphNode node,
                                          int target){
        //bsf sequence you get the first satisfied your target is the nearest node you want
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        if(graph == null || node == null){
            return null;
        }
        HashSet<UndirectedGraphNode> set = new HashSet<>();
        //part bfs
        queue.add(node);
        set.add(node);

        while (!queue.isEmpty()){
            UndirectedGraphNode curNode = queue.poll();
            if(values.get(curNode) == target){
                return curNode;
            }
            curNode.neighbors.forEach(neighbor -> {
                if (!set.contains(neighbor)){
                    set.add(neighbor);
                    queue.add(neighbor);
                }
            });
        }

        return null;
    }

    public static void main(String[] args) {
        UndirectedGraphNode node2 = new UndirectedGraphNode(2);
        UndirectedGraphNode node1 = new UndirectedGraphNode(1);
        UndirectedGraphNode node3 = new UndirectedGraphNode(3);
        UndirectedGraphNode node4 = new UndirectedGraphNode(4);
        UndirectedGraphNode node5 = new UndirectedGraphNode(5);
        node1.neighbors.add(node2);
        node1.neighbors.add(node3);
        node1.neighbors.add(node4);
        node4.neighbors.add(node5);
        node5.neighbors.add(node4);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node3.neighbors.add(node1);

        List<UndirectedGraphNode> graph = new ArrayList<>();
        graph.add(node1);
        graph.add(node2);
        graph.add(node3);
        graph.add(node4);
        graph.add(node5);

        HashMap<UndirectedGraphNode, Integer> values = new HashMap<>();
        values.put(node1,3);
        values.put(node2,4);
        values.put(node3,10);
        values.put(node4,50);
        values.put(node5,50);

        SearchGraphNodes_x dto = new SearchGraphNodes_x();
        UndirectedGraphNode aim = dto.searchNode(graph, values, node1, 50);
        System.out.println(aim.label);


    }

}
