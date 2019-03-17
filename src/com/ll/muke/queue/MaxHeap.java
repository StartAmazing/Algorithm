package com.ll.muke.queue;

public class MaxHeap <E extends Comparable<E>> {

    private Array<E> data;
    public MaxHeap(int capacity){
        data = new Array<>(capacity);
    }

    public MaxHeap(){
        data = new Array<>();
    }

    public MaxHeap(E[] arr){
        data = new Array<>(arr);

        for(int i = parent(arr.length-1) ; i >= 0 ; i--){
            siftDown(i);
        }
    }



    //返回堆中的元素个数
    public int size(){
        return data.getSize();
    }

    //返回一个布尔值，表示堆中元素是否为空
    public boolean isEmpty(){
        return data.isEmpty();
    }

    //返回在这个完全二叉的数组表示中，一个索引所表示元素的父节点的索引值
    private int parent(int index){
        if(index == 0){
            throw new IllegalArgumentException("index-0 doesn't has parents");
        }
        return ( index - 1 ) /2;
    }

    //返回在这个完全二叉的数组表示中，一个索引所表示元素的左孩子的索引值
    private int leftChild(int index){
        return index * 2 + 1;
    }

    //返回在这个完全二叉的数组表示中，一个索引所表示元素的右孩子的索引值
    private int rightChild(int index){
        return index * 2 + 2;
    }

    //向堆中添加元素
    public void add(E e){
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    //传入要进行上浮元素索引值
    private void siftUp(int k){

        //k > 0 并且他的父亲元素小于它
        while( k > 0 && data.get(parent( k )).compareTo(data.get(k)) < 0){
            data.swap(k, parent(k));
            k = parent(k);
        }
    }

    //查看堆中最大元素
    public E findMax(){
        if(data.getSize() == 0){
            throw new IllegalArgumentException("Can not findMax in an empty Heap!");
        }
        return data.get(0);
    }

    //取出堆中最大元素
    public E extractMax(){

        E ret = findMax();

        data.swap(0, data.getSize() -1);
        data.removeLast();
        siftDown(0);

        return ret;
    }

    //传入下沉元素索引值
    private void siftDown(int k){

        while( leftChild(k) < data.getSize()){

            int j = leftChild(k);
            if( j + 1 < data.getSize() &&
                    data.get(j + 1).compareTo(data.get(j)) > 0) {
                //data[j] 是leftChild和rightChild中的最大值
//                j = rightChild(k);
                j++;
            }
            if(data.get(k).compareTo(data.get(j)) >= 0){
                break;
            }
            data.swap(k, j);
            k = j;
        }
    }

    //取出堆中的最大元素，并且替换成元素e
    public E replace(E e){
        E ret = findMax();
        data.set(0, e);
        siftDown(0);
        return ret;
    }
}
