package com.ll.muke.graph.graph2;

//测试寻路算法（深度优先遍历）
public class Main4 {

    public static void main(String[] args) {

        String filename = "C:\\Users\\Administrator\\Workspaces\\IDEA\\Algorithm\\src\\com\\ll\\muke\\graph\\graph2\\testG.txt";
        SparseGraph g = new SparseGraph(7, false);
        ReadGraph readGraph = new ReadGraph(g, filename);
        g.show();
        System.out.println();

        Path path = new Path(g,0);
        System.out.println("Path from 0 to 6 : ");
        path.showPath(6);
    }
}
