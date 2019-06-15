package com.ll.muke.SegmentTree;

//融合器
public interface Merger <E>{

    E merge(E a, E b);
}
