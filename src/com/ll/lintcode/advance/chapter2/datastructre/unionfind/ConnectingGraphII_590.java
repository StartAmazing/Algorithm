package com.ll.lintcode.advance.chapter2.datastructre.unionfind;

/**
 * 描述
 * 给一个图中的 n 个节点, 记为 1 到 n .在开始的时候图中没有边.
 * 你需要完成下面两个方法：
 *
 * connect(a, b), 添加一条连接节点 a, b的边
 * query(a), 返回图中含 a 的联通区域内节点个数
 * 样例
 * 例1:
 *
 * 输入:
 * ConnectingGraph2(5)
 * query(1)
 * connect(1, 2)
 * query(1)
 * connect(2, 4)
 * query(1)
 * connect(1, 4)
 * query(1)
 *
 * 输出:
 * [1,2,3,3]
 *
 *
 * 例2:
 *
 * 输入:
 * ConnectingGraph2(6)
 * query(1)
 * query(2)
 * query(1)
 * query(5)
 * query(1)
 *
 *
 * 输出:
 * [1,1,1,1,1]
 */
public class ConnectingGraphII_590 {

    public int[] father = null;
    public int[] size = null;

    public ConnectingGraphII_590 (int x) {
        father = new int[x + 1];
        size = new int[x + 1];
        for (int i = 1; i < father.length; i ++ ) {
            father[i] = i;
            size[i] = 1;
        }
    }

    public void connect(int a, int b) {
        int root_a = findFather(a);
        int root_b = findFather(b);
        if (root_a != root_b) {
            father[root_a] = root_b;
            size[root_b] = size[root_a] + size[root_b];
        }
    }

    public int query(int x) {
        return size[findFather(x)];
    }

    private int findFather(int x) {
        if (x == father[x]) {
            return x;
        }

        return father[x] = findFather(father[x]);
    }

}
