package com.ll.zs.nowcoder.basic.class08.mytest;

import java.util.HashMap;
import java.util.HashSet;

public class Graph {
    //点的编号对应实际的node
    public HashMap<Integer,Node> nodes;
    public HashSet<Edge> edges;
    public Graph(){
        nodes = new HashMap<>();
        edges = new HashSet<>();
    }
}
