package com.ll.muke.graph.graph2;

//求无权图的连通分量
public class Components {

    private Graph G;    //图的引用
    private boolean[] visited; //记录dfs的过程中的结点是否被访问
    private int ccount; //记录连通分量的个数
    private int[] id; //每个节点所对应的连通分量标记

    //图的深度优先遍历
    private void dfs ( int v ){
        visited[v] = true;
        id[v] = ccount;
        for(int i : G.adj(v) ){
            if( !visited[i])
                dfs(i);
        }
    }

    //构造函数，求出无权图的连通分量
    public Components(Graph graph){

        //算法初始化
        G = graph;
        visited = new boolean[G.V()];
        id = new int[G.V()];
        ccount = 0;
        for(int i = 0; i < G.V(); i++){
            visited[i] = false;
            id[i] = -1;
        }

        //求图的连通分量
        for(int i = 0; i < G.V() ; i ++ ){
            if( !visited[i] ){
                dfs(i);
                ccount++;
            }
        }
    }
    //返回图中的连通分量的个数
    int count(){
        return ccount;
    }

    //查询点v到点w是否连通
    boolean isConnected(int v, int w){
        assert v>=0 && v < G.V();
        assert w>=0 && w < G.V();
        return id[v] == id [w];
    }

}
