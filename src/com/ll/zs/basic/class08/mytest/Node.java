package com.ll.zs.basic.class08.mytest;

import java.util.ArrayList;

public class Node {
    //编号
    public int value;
    public int in;
    public int out;

    //从本身出发有多少点
    public ArrayList<Node> nexts;
    //从自身出发的边的集合
    public ArrayList<Edge> edges;

    public Node(int value){
        this.value = value;
        in = 0;
        out = 0;
        nexts = new ArrayList<>();
        edges = new ArrayList<>();
    }


}
