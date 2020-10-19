package com.ll.zs.nowcoder.basic.class07.mytest;

import java.util.HashMap;
import java.util.List;

public class UnionFind {

    public class Data{
        //whatever you want
    }
    public class UnionFindSet{
        //（k,v）表示，k的父节点是v
        public HashMap<Data,Data> fatherMap;
        public HashMap<Data,Integer> sizeMap;

        public UnionFindSet(){
            fatherMap = new HashMap<>();
            sizeMap = new HashMap<>();
        }

        public void makeSets(List<Data> nodes){
            fatherMap.clear();
            sizeMap.clear();
            nodes.forEach(n ->{
                fatherMap.put(n,n);
                sizeMap.put(n,1);
            });
        }

        private Data findRoot(Data d){
            Data father = fatherMap.get(d);
            if(father != d){
                father =  findRoot(father);
            }
            fatherMap.put(d, father);
            return father;
        }

        public void union(Data a, Data b){
            if(a == null || b == null){
                return;
            }
            Data aHead = findRoot(a);
            Data bHead = findRoot(b);
            if(aHead != bHead){
                int aSize = sizeMap.get(aHead);
                int bSize = sizeMap.get(bHead);
                if(aSize <= bSize){
                    fatherMap.put(aHead,bHead);
                    sizeMap.put(bHead,aSize+bSize);
                }else{
                    fatherMap.put(bHead,aHead);
                    sizeMap.put(aHead,aSize + bSize);
                }
            }
        }

    }
}
