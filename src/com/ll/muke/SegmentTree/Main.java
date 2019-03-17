package com.ll.muke.SegmentTree;

public class Main {

    public static void main(String[] args){

        Integer[] nums = {-2, 0, 3, -5, 2, -1};
//        SegmentTree<Integer> segmentTree = new SegmentTree<>(nums,
//                new Merger<Integer>() {
//
//            //实际需要的业务逻辑
//            @Override
//            public Integer merge(Integer a, Integer b) {
//                return a + b;
//            }
//        });
        //lambda表达式
        SegmentTree<Integer> segmentTree = new SegmentTree<>(nums, (a, b) -> a + b);
        //System.out.println(segmentTree);
        System.out.println(segmentTree.query(3,5));
        System.out.println(segmentTree.query(0,5));
        System.out.println(segmentTree.query(2,4));
    }

}
