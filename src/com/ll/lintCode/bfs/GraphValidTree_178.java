package com.ll.lintCode.bfs;

import java.util.*;

public class GraphValidTree_178 {

    public boolean validTree(int n, int[][] edges){
        if(edges.length != n -1){
            return false;
        }

        HashMap<Integer, HashSet<Integer>> graph = initGraph(n, edges);

        //bfs
        Set<Integer> set = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        set.add(0);
        queue.offer(0);

        while (!queue.isEmpty()){
            Integer curInteger = queue.poll();
            for (Integer vertex : graph.get(curInteger)){
                if(set.contains(vertex)){
                    continue;
                }
                queue.offer(vertex);
                set.add(vertex);
            }
        }

        return set.size() == n;
    }

    private HashMap<Integer, HashSet<Integer>> initGraph(int n, int[][] edges){
        HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();

        for(int i = 0; i < n; i++){
            graph.put(i, new HashSet<>());
        }
//        for (int[] vertex : edges){
//            int u = vertex[0];
//            int v = vertex[1];
//            graph.get(u).add(v);
//            graph.get(v).add(u);
//        }
        for (int[] vertex : edges){
            graph.get(vertex[0]).add(vertex[1]);
            graph.get(vertex[1]).add(vertex[0]);
        }

        return graph;
    }

    public static void main(String[] args) {
        GraphValidTree_178 dto = new GraphValidTree_178();
        int[][] edges = {{0,1},{0,2},{0,3},{1,4}};
        dto.validTree(5, edges);
    }
}
