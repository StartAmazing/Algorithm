package com.ll.lintCode.bfs;

import com.ll.lintCode.utils.DirectedGraphNode;

import java.util.*;

public class TopologicalSorting_127 {

    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph){
        ArrayList<DirectedGraphNode> order = new ArrayList<>();
        if(graph == null){
            return order;
        }

        //1. count indegree
        Map<DirectedGraphNode,Integer> indegree = getIndegree(graph);

        //2. topological sorting - bfs
        ArrayList<DirectedGraphNode> startNodes = getStartNodes(indegree, graph);

        //3. bfs
        order = bfs(indegree, startNodes);

        if(order.size() == graph.size()){
            return order;
        }

        return null;
    }

    private Map<DirectedGraphNode, Integer> getIndegree(ArrayList<DirectedGraphNode> graph){
        Map<DirectedGraphNode, Integer> map = new HashMap<>();
        for (DirectedGraphNode node : graph){
            map.put(node,0);
        }
        for (DirectedGraphNode node : graph){
            node.neighbors.forEach(neighbor -> {
                if(map.containsKey(neighbor)){
                    Integer tmpInteger = map.get(neighbor);
                    tmpInteger ++;
                    map.put(neighbor,tmpInteger);
                }
            });
        }
        return map;
    }

    private ArrayList<DirectedGraphNode> getStartNodes(Map<DirectedGraphNode,Integer> indegree,
                                                  ArrayList<DirectedGraphNode> graph){
        ArrayList<DirectedGraphNode> resList = new ArrayList<>();
        graph.forEach(ele -> {
            if (indegree.get(ele) == 0){
                resList.add(ele);
            }
        });
        return resList;
    }

    private ArrayList<DirectedGraphNode> bfs(Map<DirectedGraphNode,Integer> indegree,
                                             ArrayList<DirectedGraphNode> startNodes){
        ArrayList<DirectedGraphNode> order = new ArrayList<>();
        Queue<DirectedGraphNode> queue = new LinkedList<>();

        for(DirectedGraphNode node : startNodes){
            order.add(node);
            queue.offer(node);
        }

        //here need't use a set to judge if the element double counting, because a indgree here!
        //just judge if the indegree is zero.
        while (!queue.isEmpty()){   //O(V)
            DirectedGraphNode node = queue.poll();
            for (DirectedGraphNode neighbor : node.neighbors){      //O(V)
                //node -> neighbor
                indegree.put(neighbor, indegree.get(neighbor) - 1);
                if(indegree.get(neighbor) == 0){
                    queue.offer(neighbor);
                    order.add(neighbor);
                }
            }
        }
        return order;
    }

}
