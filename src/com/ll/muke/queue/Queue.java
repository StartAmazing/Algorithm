package com.ll.muke.queue;

public interface Queue <E>{

    int getSize();
    boolean isEmpty();
    void enqueue(E e);
    E dequeue();
    E getFront();

}
