package com.ll.lintcode.basic.hash_heap;

/**
 * 给出一个整数数组，堆化操作就是把它变成一个最小堆数组。
 *
 * 对于堆数组A，A[0]是堆的根，并对于每个A[i]，A [i * 2 + 1]是A[i]的左儿子并且A[i * 2 + 2]是A[i]的右儿子。
 *
 * 样例
 * 样例 1
 *
 * 输入 : [3,2,1,4,5]
 * 输出 : [1,2,3,4,5]
 * 解释 : 返回任何一个合法的堆数组
 * 挑战
 * O(n)的时间复杂度完成堆化
 *
 * 说明
 * 什么是堆？ 什么是堆化？ 如果有很多种堆化的结果？
 *
 * 堆是一种数据结构，它通常有三种方法：push， pop 和 top。其中，“push”添加新的元素进入堆，“pop”删除堆中最小/最大元素，“top”返回堆中最小/最大元素。
 * 把一个无序整数数组变成一个堆数组。如果是最小堆，每个元素A[i]，我们将得到A[i * 2 + 1] >= A[i]和A[i * 2 + 2] >= A[i]
 * 返回其中任何一个。
 *
 */
public class Heapify_130 {

    /*
     * @param A: Given an integer array
     * @return: nothing
     */
    public void heapify(int[] A) {
        if (A == null || A.length < 2) return;
        for (int i = 0; i < A.length ; i++){
            heapInsert(A, i);
        }
    }

    private void heapInsert(int[] A, int index){
        while(A[index] < A[(index - 1) / 2]){
            swap(A, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    private void swap(int[] A, int x, int y){
        int tmp = A[x];
        A[x] = A[y];
        A[y] = tmp;
    }

    public static void main(String[] args) {
        int[] A = new int[]{3,2,1,4,5};
        Heapify_130 dto = new Heapify_130();
        dto.heapify(A);
        for (int i : A){
            System.out.print(i + " ");
        }
    }
}
