package com.ll.nine_chapter.advance.b_data_structure;

public class UniFind {

    public int[] father;

    public UniFind(int cap) {
        father = new int[cap];
        for (int i = 0; i < father.length; i++) {
            father[i] = i;
        }
    }

    public int find(int x) {
       if (father[x] == x) {
           return x;
       }

       return father[x] = find(father[x]);
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            father[rootY] = rootX;
        }
    }

    public boolean isCommon(int x, int y) {
        return find(x) == find(y);
    }
}

class Questions {

}
