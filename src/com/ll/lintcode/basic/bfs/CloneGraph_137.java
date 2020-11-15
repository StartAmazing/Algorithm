package com.ll.lintcode.basic.bfs;

import com.ll.utils.UndirectedGraphNode;

import java.util.*;

public class CloneGraph_137 {

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node){
        if (node == null){
            return node;
        }
        //1. use bfs algorithm to traverse the graph and get all nodes.
        List<UndirectedGraphNode> nodes = getNodes(node);

        //2. copy nodes, store the old -> new mapping information in a hashMap
        HashMap<UndirectedGraphNode, UndirectedGraphNode> mapping = new HashMap<>();
        nodes.forEach(ele -> {
            mapping.put(ele, new UndirectedGraphNode(ele.label));
        });

        //3. copy neighbors(edges)
        nodes.forEach(ele -> {
            UndirectedGraphNode newNode = mapping.get(ele);
            ele.neighbors.forEach(item -> {
                //deep copy
                UndirectedGraphNode newNeighbor = mapping.get(item);
                newNode.neighbors.add(newNeighbor);
            });
        });

        return mapping.get(node);
    }

    //bfs
    private List<UndirectedGraphNode> getNodes(UndirectedGraphNode node){

        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        HashSet<UndirectedGraphNode> set = new HashSet<>();

        queue.add(node);
        set.add(node);

        while (!queue.isEmpty()){
            UndirectedGraphNode curNode = queue.poll();
            curNode.neighbors.forEach(ele -> {
                if(!set.contains(ele)){
                    set.add(ele);
                    queue.offer(ele);
                }
            });
        }
        return new ArrayList<UndirectedGraphNode>(set);
    }

}
