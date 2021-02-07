package com.ll.muke.map;


/**
 * map接口定义
 */
public interface Map <K, V>{

    /* 添加一个元素 */
    void add(K key, V value);

    /* 删除一个元素 */
    V remove(K key);

    /* 判断是否已包含这个key */
    boolean contains(K key);

    /* 为已有的key设置新值 */
    void set(K key, V newValue);

    /* 获取当前元素个数 */
    int getSize();

    /* 判断是否为空map */
    boolean isEmpty();

    public V get(K key);

}
