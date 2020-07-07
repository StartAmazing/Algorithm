package com.ll.lintcode.advance.chapter2.datastructre.unionfind;

/**
 * 描述
 * 给一个图中的 n 个节点, 记为 1 到 n . 在开始的时候图中没有边.
 * 你需要完成下面两个方法:
 *
 * connect(a, b), 添加一条连接节点 a, b的边
 * query(), 返回图中联通区域个数
 * 您在真实的面试中是否遇到过这个题？
 * 样例
 * 例1:
 *
 * 输入:
 * ConnectingGraph3(5)
 * query()
 * connect(1, 2)
 * query()
 * connect(2, 4)
 * query()
 * connect(1, 4)
 * query()
 *
 * 输出:[5,4,3,3]
 *
 * 例2:
 *
 * 输入:
 * ConnectingGraph3(6)
 * query()
 * query()
 * query()
 * query()
 * query()
 *
 *
 * 输出:
 * [6,6,6,6,6]
 */
public class ConnectingGraphIII_591 {
    public int[] father = null;
    public int number = 0;

    public ConnectingGraphIII_591(int n) {
        father = new int[n + 1];
        for (int i = 1; i < father.length; i++) {
            father[i] = i;
        }

        number = n;
    }

    public void connect(int a, int b) {
        int root_a = findFather(a);
        int root_b = findFather(b);
        if (root_a != root_b) {
            father[root_a] = root_b;
            number--;
        }
    }

    /**
     * @return: An integer
     */
    public int query() {
        return number;
    }

    private int findFather(int x) {
        if (x == father[x]) {
            return x;
        }

        return father[x] = findFather(father[x]);
    }

}
