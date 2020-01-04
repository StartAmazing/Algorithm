package com.ll.lintCode.utils;

import java.util.ArrayList;

public class UndirectedGraphNode {

    public int label;
    public ArrayList<UndirectedGraphNode> neighbors;

    public UndirectedGraphNode(int x){
        label = x;
        neighbors = new ArrayList<>();
    }

}
