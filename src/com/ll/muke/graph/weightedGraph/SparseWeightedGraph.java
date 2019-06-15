package com.ll.muke.graph.weightedGraph;

import java.util.Vector;

public class SparseWeightedGraph<Weight extends Number & Comparable> implements WeightedGraph {

    private int n;  //记录这个图中的所有顶点数
    private int m;  //记录这个图中的所有边数
    private boolean directed; //是否为有向边
    //数组中的每一位都是一个向量，这个向量表示该位置所表示顶点的所有邻边
    private Vector<Edge<Weight>>[] g;

    public SparseWeightedGraph(int n, boolean directed){
        this.n = n; //初始化顶点的个数
        this.m = 0; //初始化边的条数，初始值为0
        this.directed = directed;   //是否为有向边
        //g的初始化为n个空的vector,表示每一个g[i]都为空，即没有任何边
        //强制转为元素为Edge的向量的数组
        g = (Vector<Edge<Weight>>[]) new Vector[n];
        for(int i = 0; i < n; i++){
            g[i] = new Vector<Edge<Weight>>();
        }
    }

    //返回结点个数
    @Override
    public int V() {
        return n;
    }

    //返回边的条数
    @Override
    public int E() {
        return m;
    }

    //向图中添加一条边，权值为e.wt();
    @Override
    public void addEdge(Edge e) {
        assert e.v() >= 0 && e.v() < n;
        assert e.w() >= 0 && e.w() < n;

        //注意，由于在邻接的情况，查找是否有重编需要遍历整个链表
        //我们的程序允许重边的出现
        g[e.v()].add(new Edge(e));
        if(e.v() != e.w() && !directed){
            g[e.w()].add(new Edge(e.w(), e.v(),e.wt()));
        }
        m++;
    }

    @Override
    public boolean hasEdge(int v, int w) {
        assert v >=0 && v < n;
        assert w >=0 && w < n;

        //从数组中第g[v]个元素开始进行遍历，看是否有值与w连通
        for(int i = 0; i < n; i++) {
            //other(v)给定v顶点看返回的顶点是否是w
            if (g[v].elementAt(i).other(v) == w)
                return true;
        }
        return false;
    }

    @Override
    public void show() {
        for(int i = 0; i < n ;i ++){
            System.out.print("vertex: " + i + ":\t");
            for(int j = 0; j < g[i].size(); j++){
                Edge e = g[i].elementAt(j);
                System.out.print("( to: " + e.other(i) + ", wt: " + e.wt() + ")\t");
            }
            System.out.println();
        }
    }

    //返回图中一个顶点的所有邻边
    //由于java使用的引用机制，返回一个Vector不会带来额外开支
    @Override
    public Iterable<Edge<Weight>> adj(int v) {
        assert v >= 0 && v < n;
        return g[v];
    }
}
