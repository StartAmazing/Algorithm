package com.ll.muke.graph.weightedGraph;

import java.util.Vector;

public class DenseWeightedGraph <Weight extends Number & Comparable> implements WeightedGraph{

    private int n;  //定点数
    private int m;  //边数
    private boolean directed; //是否为有向图
    private Edge<Weight>[][] g;    //图的具体数据

    //构造函数
    public DenseWeightedGraph( int n, boolean directed){
        assert n >= 0;
        this.n = n;
        this.m = 0; //初始化的时候没有任何边
        this.directed = directed;
        //g初始化为n*n的布尔矩阵，每一个g[i][j]均为null,表示没有任何边
        //false为boolean型变量的默认值
        g = new Edge[n][n];
        for(int i = 0 ; i < n; i++)
            for(int j = 0 ; j < n; j++)
                g[i][j] = null;
    }

    //返回节点的个数
    @Override
    public int V() {
        return n;
    }

    //返回边的个数
    @Override
    public int E() {
        return m;
    }

    //向图中添加一个边
    @Override
    public void addEdge(Edge e) {
        //添加边的两个顶点的值必须在[0, n)之中
        assert e.v() >= 0 && e.v() < n;
        assert e.w() >= 0 && e.w() < n;

        //如果这两个结点有边存在，则直接返回
        if(hasEdge(e.v() , e.w()))
            return;
        //如果这两个点不存在边，则根据参数信息构造一条边
        //当两个顶点是同一个顶点时，这时候形成一条自环边
        g[e.v()][e.w()] = new Edge(e);
        //如果两个顶点是不同的，并且是一个无向图，那么添加一条边从和刚才添加边相反的一条边，权值相等
        if(e.v() != e.w() && !directed)
            //这里将第一个顶点和第二个顶点相互交换位置以便形成相反的一组顶点
            g[e.w()][e.v()] = new Edge(e.w(), e.v(), e.wt());
        m++;
    }

    //验证图中是否有从v到w的边
    @Override
    public boolean hasEdge(int v, int w) {
        assert v >= 0 && v < n;
        assert w >= 0 && w < n;
        return g[v][w] != null;
    }

    //显示图的信息，开始打印图中的数据以及边的信息
    @Override
    public void show() {
        for(int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j++) {
                if (g[i][j] != null)
                    System.out.print(g[i][j].wt() + "\t");
                else
                    System.out.print("NULL\t");
            }
            System.out.println();
        }
    }

    //返回图中一个顶点的所有邻边
    //由于java使用引用机制，返回一个Vector不会带来额外开销
    @Override
    public Iterable<Edge<Weight>> adj(int v) {
        assert v >= 0 && v < n;
        //这个向量上面存储的每一个值都是一个Edge对象
        Vector<Edge<Weight>> adjV = new Vector<Edge<Weight>>();
        for(int i = 0; i < n; i ++){
            if(g[v][i] != null){
                adjV.add( g[v][i] );
            }
        }
        return adjV;
    }
}
