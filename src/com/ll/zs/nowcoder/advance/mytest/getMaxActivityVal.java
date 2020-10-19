package com.ll.zs.nowcoder.advance.mytest;

import java.util.ArrayList;
import java.util.List;

/**
 * 一个公司的上下关系是一棵多叉树，你作为组织者已经摸清了大家的心情，一个员工的直接
 * 上级如果到场，这个员工肯定不会来，每个员工都有一个活跃度的值，决定谁来你会给这个
 * 员工发邀请函，怎么才会让这个舞会的气氛最活跃？返回最大的活跃值。
 *
 * 举例：
 *  给定一个矩阵来表述这种关系
 *
 *  matrix = [
 *     1, 6
 *     1, 5
 *     1, 4
 *  ]
 *
 *  这个矩阵的含义是： matrix[0] = [1,6],表示0这个员工的直接上级为1，0这个员工的活跃度为6
 *                     matrix[1] = [1,5],表示1这个员工的直接上级为1（他自己是这个公司的最大boss）,活跃度为5
 *                     matrix[2] = [1,4],表示2这个员工的直接上级为1, 2这个员工的活跃度为4
 *  为了让晚会的活跃度自大，应该让1不来，0和2来，最后返回活跃度为10
 */
public class getMaxActivityVal {

    public static class Node{
        public int val;
        public List<Node> nexts;
        public Node(int val){
            this.val = val;
            nexts = new ArrayList<>();
        }
    }

    public static class ReturnType{
        public int lai_huo;
        public int bu_lai_huo;

        public ReturnType(int lai_huo, int bu_lai_huo){
            this.lai_huo = lai_huo;
            this.bu_lai_huo = bu_lai_huo;
        }
    }

    public static int getMaxHuo(Node head){
        if(head == null){
            return 0;
        }
        return Math.max(process(head).lai_huo, process(head).bu_lai_huo);
    }

    public static ReturnType process(Node head){
        int lai_huo = head.val;
        int bu_lai_huo = 0;
        for(int i = 0; i < head.nexts.size(); i ++){
            Node next = head.nexts.get(i);
            ReturnType nextData = process(next);
            //当前节点来的话，那么活跃度就是他的直接子节点后代不能来
            lai_huo += nextData.bu_lai_huo;
            //当前节点不来的话，那么他的子节点可来可不来，选择其中最大 的
            bu_lai_huo += Math.max(nextData.lai_huo, nextData.bu_lai_huo);
        }

        return new ReturnType(lai_huo, bu_lai_huo);

    }



}
