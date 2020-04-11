package com.ll.lintcode.basic.utils;

import java.util.ArrayList;

public class DirectedGraphNode {
    public int label;
    public ArrayList<DirectedGraphNode> neighbors;
    public DirectedGraphNode(int x){
        this.label = x;
        this.neighbors = new ArrayList<>();
    }

}
