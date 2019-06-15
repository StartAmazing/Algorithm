package com.ll.muke.graph.weightedGraph;

//在堆的有关操作中，需要比较堆中元素的大小，多以Item需要extends Comparable
public class MinHeap <Item extends Comparable>{

    protected Item[] data;
    protected int count;    //堆中元素个数
    protected int capacity;     //堆的最大容量

    //构造函数，构造一个空堆，可以容纳capacity个元素
    public MinHeap(int capacity){
        this.data = (Item[]) new Comparable[capacity + 1];
        this.count = 0;
        this.capacity = capacity;
    }

    //构造函数，通过一个给定数组创建一个最小堆
    //该构造堆的过程，时间复杂度为O(n）
    public MinHeap(Item[] arr){
        int n = arr.length;
        this.data = (Item[])new Comparable[n+1];
        this.capacity = n;

        for(int i = 0 ; i < n ; i++){
            this.data[i + 1] = arr[i];
        }

        count = n;

        for(int i = count / 2; i >= 1; i--){
            shiftDown(i);
        }
    }

    //返回堆中元素个数
    public int size(){
        return count;
    }

    //返回一个布尔值，表示堆中是否为空
    public boolean isEmpty(){
        return count == 0;
    }

    //向堆中插入一个新的元素Item
    public void insert(Item item){
        assert count + 1 <= capacity;
        data[count + 1] = item;
        count ++;
        shiftUp(count);
    }

    //从最小堆中取出堆顶元素，即堆中所存储的最小数据
    public Item extractMin(){
        assert  count > 0;
        Item ret = data[1];

        swap(data, 1, count);
        count --;
        shiftDown(1);
        return ret;
    }

    //获取最小堆中的堆顶元素
    public Item getMin(){
        assert count > 0;
        return data[1];
    }

    //交换堆中索引为i和j的两个元素
    private void swap(Item[] arr,int i, int j){
        Item e = arr[i];
        arr[i] = arr[j];
        arr[j] = e;
    }

    /**
     * 最小堆核心辅助函数shiftUp
     */
    private void shiftUp(int i){
        while( i > 1 && data[i / 2].compareTo(data[i]) > 0){
            swap(data, i, i/2);
            i /= 2;
        }
    }
    /**
     * 最小核心辅助函数shiftDown
     */
    private void shiftDown(int i){
        while(i*2 <= count){
            int j = i*2;
            if(j+1 <= count && data[j + 1].compareTo(data[j]) < 0){
                j ++;
            }
            if(data[i].compareTo(data[j]) <= 0){
                break;
            }
            swap(data, i , j);
            i = j;
        }
    }

    //测试minHeap
    public static void main(String[] args) {
        MinHeap<Integer> minHeap = new MinHeap<Integer>(100);
        int N = 100;//堆中元素的个数
        int M = 100; //堆中元素取值范围[0, M)
        for(int i = 0; i < N; i++)
            minHeap.insert(new Integer((int) (Math.random()*M)));
        Integer[] arr = new Integer[N];
        //将minHeap中的数据逐个使用extractMin取出来
        //将取出来的顺序应该是按照从小到大的顺序
        for(int i = 0; i < N; i++){
            arr[i] = minHeap.extractMin();
        }
        System.out.println();


        //确保arr数组中元素是从小到大排序
        for(int i= 0; i < N ;i ++) {
            System.out.print(arr[i] + " ");
        }
    }

}
