package com.ll.lintcode.advance.chapter2.datastructre.unionfind;

/**
 * 简单并查集模板
 */
public class UnionFind {
    private int[] father = null;
    public int find(int x) {
        if (father[x] == x) {
            return x;
        }
        father[x] = find(father[x]);
        return father[x];
    }

    public void union(int a, int b) {
        int root_a = find(a);
        int root_b = find(b);
        if (root_a != root_b) {
            father[root_a] = root_b;
        }
    }
}
