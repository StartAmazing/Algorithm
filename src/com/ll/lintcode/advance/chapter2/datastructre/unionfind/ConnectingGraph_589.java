package com.ll.lintcode.advance.chapter2.datastructre.unionfind;

/**
 * 给一个图中的n个节点, 记为 1 到 n . 在开始的时候图中没有边。
 * 你需要完成下面两个方法:
 *
 * connect(a, b), 添加连接节点 a, b 的边.
 * query(a, b), 检验两个节点是否联通
 */
public class ConnectingGraph_589 {

    public int[] father = null;

    public ConnectingGraph_589(int n) {
        father = new int[n + 1];
        for (int i = 0; i < father.length; i++) {
            father[i] = i;
        }
    }

    public void connect(int a, int b) {
        int root_a = findFather(a);
        int root_b = findFather(b);
        if (root_a != root_b) {
            father[root_a] = root_b;
        }
    }

    public boolean isConnect(int a, int b) {
        return findFather(a) == findFather(b);
    }

    private int findFather(int x) {
        if (x == father[x]) {
            return x;
        }
        return father[x] = findFather(father[x]);
    }

}
