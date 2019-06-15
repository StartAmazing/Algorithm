package com.ll.muke.graph.weightedGraph;

public interface WeightedGraph <Weight extends Number & Comparable>{
    /**
     * @return  返回顶点数量
     */
    public int V();

    /**
     * @return  返回边的数量
     */
    public int E();
    /**
     * 添加一条带权重的边
     */
    public void addEdge(Edge<Weight> e);

    /**
     * @param v 其中的一个顶点
     * @param w 另一个顶点
     * @return  判断v和w之间是否相连
     */
    public boolean hasEdge(int v, int w);
    /*
     * 简单绘制图
     */
    public void show();
    /**
     * @param v  以该顶点开始
     * @return  该顶点的所有邻边
     */
    public Iterable<Edge<Weight>> adj(int v);
}
