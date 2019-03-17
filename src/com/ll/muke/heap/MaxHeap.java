package com.ll.muke.heap;

public class MaxHeap<Item extends Comparable> {

    protected Item[] data;
    protected int count;  //用来记录堆中已经放入了多少个元素，和data.length没有关系
    protected int capacity;   //记录堆的容量

    //构造函数，构造一个空堆，可以容纳capacity个元素
    public MaxHeap(int capacity){
        this.data =(Item[]) new Comparable[capacity + 1];
        count = 0;
        this.capacity = capacity;
    }
    //构造函数，通过一个给定数组创建一个最大堆
    //该构造堆的过程，时间复杂度为O(n)
    public MaxHeap(Item[] arr){
        int n = arr.length;
        //为data数组开辟n+1个元素空间
        data = (Item[]) new Comparable[n+1];
        capacity = n;

        for(int i = 0; i < n; i++){
            //data数组从1开始索引堆重元素
            data[i + 1] = arr[i];
        }
        count = n;
        for(int i = count / 2 ; i >= 1 ; i--)
            shiftDown(i);
    }

    //返回堆中的元素个数
    public int size(){
        return count;
    }

    //判断堆是否为空
    public boolean isEmpty(){
        return count == 0;
    }

    //向最大堆中插入一个新的元素 item
    public void insert(Item item){
        assert count + 1 <= capacity;
        //从1开始索引
        data[count + 1] = item;
        count ++;
        shiftUp(count);
    }

    //从最大堆中取出堆顶元素，即堆中所存储的最大数据
    public Item extractMax(){
        assert count > 0;
        Item ret = data[1];
        swap(data, 1, count);
        count --;
         shiftDown(1);

         return ret;
    }

    //获取最大堆中的堆顶元素
    public Item getMax(){
        assert (count > 0);
        return data[1];
    }

    /**
     * 最大堆核心辅助函数
     * @param i 表示元素要执行操作的索引位置
     */
    private void shiftDown(int i){

        while(2*i <= count){
            int j = 2 * i;
            //data[j]是data[2*i]和data[2*i + 1]中的最大值
            if(j + 1 <= count && data[j].compareTo(data[j + 1]) < 0){
                j ++;
            }

            if(data[i].compareTo(data[j]) >= 0)
                break;
            swap(data, i, j);
            i = j;
        }
    }

    /**
     * 最大堆核心辅助函数
     * @param k 新插入的节点的索引
     */
    private void shiftUp(int k){
        //当k > 1,也就是k还没到达数的顶部且索引k 处的元素值比它的父节点的元素值大的时候
        while( k > 1 && data[k / 2].compareTo( data[k]) < 0 ){
            swap(data, k / 2 , k);
            k /= 2;
        }
    }

    //交换堆中索引为i和j的两个元素
    private void swap(Item[] arr, int x, int y){
        Item temp  = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    //测试MaxHeap
    public static void main(String[] args){
        MaxHeap<Integer> maxHeap = new MaxHeap<>(100);
        int N = 100; //堆中元素个数
        int M = 100; //堆中元素取值范围[0, M)
        for(int i = 0; i < N; i++) {
            maxHeap.insert(new Integer((int) (Math.random() * M)));
        }
        System.out.println(maxHeap.size());

        Integer[] arr = new Integer[maxHeap.size()];
        for (int i = 0; i < N; i++){
            arr[i] = maxHeap.extractMax();
        }
        System.out.println();

        for(Integer i : arr){
            System.out.print(i + " ");
        }


    }

}
