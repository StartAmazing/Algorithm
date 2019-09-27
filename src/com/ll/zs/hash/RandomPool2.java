package com.ll.zs.hash;

import java.util.HashMap;

/**
 * @author LL
 * @date 2019/8/5
 * @description 第二次研究
 */
public class RandomPool2<K> {

    private HashMap<K, Integer> keyIndexMap;
    private HashMap<Integer, K> indexKeyMap;
    private int size;

    public RandomPool2(){
        this.keyIndexMap = new HashMap<>();
        this.indexKeyMap = new HashMap<>();
        this.size = 0;
    }

    public void addEle(K val){
        if(!this.keyIndexMap.containsKey(val)) {
            keyIndexMap.put(val, size);
            indexKeyMap.put(size++, val);
        }
    }

    public K getEle(int index){
        if(size == 0){
            return null;
        }
        return indexKeyMap.get(index);
    }

    public void deleteEle(K key){
        if(this.keyIndexMap.containsKey(key)){
            int deleteIndex = this.keyIndexMap.get(key);
            int lastIndex =  size --;
            K lastKey = this.indexKeyMap.get(lastIndex);
            this.keyIndexMap.put(lastKey,deleteIndex);
            this.indexKeyMap.put(deleteIndex,lastKey);
            this.keyIndexMap.remove(key);
            this.indexKeyMap.remove(lastIndex);
            size--;
        }
    }

    public K getRandom(){
        if(size == 0){
            return null;
        }
        int randomIndex = (int)(Math.random()*size);
        return this.indexKeyMap.get(randomIndex);
    }

    



}
