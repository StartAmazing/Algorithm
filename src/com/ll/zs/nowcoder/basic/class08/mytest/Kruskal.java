package com.ll.zs.nowcoder.basic.class08.mytest;

import java.util.*;

//最小生成树，建立在无向图基础上
//连通图中所有节点，保证得到的图中边的权重和最小
//k算法核心，从最小权重边开始考虑，假设初始时节点之间不存在边连接关系，并查集
//依次选小权重的边，判断是否有回路形成，有回路形成舍弃，否则取得该边
public class Kruskal {
    //Union-Find Set
    public static class UnionFind{
        private HashMap<Node,Node> fatherMap;
        private HashMap<Node,Integer> rankMap;

        public UnionFind(){
            this.fatherMap = new HashMap<Node,Node>();
            this.rankMap = new HashMap<Node,Integer>();
        }

        public void makeSet(Collection<Node> nodes){
            fatherMap.clear();
            rankMap.clear();
            nodes.forEach(node ->{
                fatherMap.put(node,node);
                rankMap.put(node,1);
            });
        }

        public Node findFather(Node node){
            Node father = fatherMap.get(node);
            if(father != node){
                father = findFather(father);
            }
            fatherMap.put(node,father);
            return father;
        }

        public boolean isSameSet(Node a, Node b){
            return findFather(a) == findFather(b);
        }

        public void union(Node a, Node b){
            if( a == null || b == null){
                return;
            }
            Node aFather = findFather(a);
            Node bFather = findFather(b);
            if(aFather != bFather){
               int aRank = rankMap.get(aFather);
               int bRank = rankMap.get(bFather);
               if(aRank < bRank){
                   fatherMap.put(aFather,bFather);
                   rankMap.put(bFather,aRank + bRank);
               }else {
                   fatherMap.put(bFather,aFather);
                   rankMap.put(aFather,aRank + bRank);
               }
            }
        }
    }

    public static class EdgeComparator implements Comparator<Edge>{

        @Override
        public int compare(Edge o1, Edge o2) {
            if(o1.weight < o2.weight){
                return -1;
            }else {
                return 1;
            }
        }
    }


    public static Set<Edge> kruskalMST(Graph graph){
        UnionFind unionFind = new UnionFind();
        unionFind.makeSet(graph.nodes.values());
        //小根堆
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new EdgeComparator());
        graph.edges.forEach(e -> {
            priorityQueue.add(e);
        });
        Set<Edge> result = new HashSet<>();
        while(!priorityQueue.isEmpty()){
            Edge edge = priorityQueue.poll();
            System.out.println(edge.from.value + "   " + edge.to.value + "   "  + unionFind.isSameSet(edge.from,edge.to));
            if(!unionFind.isSameSet(edge.from,edge.to)){
                result.add(edge);
                unionFind.union(edge.from,edge.to);
            }

        }
        return result;
    }
    public static void main(String[] args) {
        Integer[][] matrix = new Integer[][]{
                {1,1,2},
                {1,2,1},
                {1,2,3},
                {1,3,2},
                {2,1,3},
                {2,3,1},
                {4,3,4},
                {4,4,3},
                {3,2,4},
                {3,4,2},
                {2,1,4},
                {2,4,1}
        };
        Graph graph = GraphGenerator.createGraph(matrix);
        Set<Edge> edges = kruskalMST(graph);
        edges.forEach(a -> {
            System.out.println("edgeWeight: " + a.weight + ", edgeFrom: " + a.from.value + ", edgeTo: "+ a.to.value);
        });
    }


}
