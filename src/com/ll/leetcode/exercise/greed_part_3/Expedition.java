package com.ll.leetcode.exercise.greed_part_3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 最优加油方法：
 *      已知一条公路上，有一个起点和一个终点，这之间有n个加油站；已知从这n个加油站
 *      到终点的距离d与各个加油站可以加油的量l，起点位置至终点的距离L与起始时刻油箱
 *      中汽油量P，假设使用1个单位的汽油即走一个单位的距离，油箱没有上限，最少加几
 *      次油，可以从起点开至终点？（如果无法到达终点，返回-1）
 *
 * 思考：汽车经过n个加油站，对于这n个加油站，应该在哪个加油站停下来加油，最终既能到
 *      达终点，又使得加油次数最少？
 *      若按顺序遍历加油站，则面临：
 *          如果在某个加油站停下来加油，可能是没有必要的，有可能不进行这次加油也能到达终点；
 *          如果在某个加油站不停下来加油，可能由于汽油不够而无法到达终点或者说后面要更多次
 *          的加油才能到达终点
 *      poj 2431 Expedition
 *      It's Hard
 *
 * 何时加油最合适?
 * 油用光的时候加油最合适！
 * 在哪个加油站加油最合适?
 * 在油量最多的加油站加油最合适
 *
 * 算法思路：
 *      1、设置一个最大堆，用来存储经过加油站的汽油量
 *      2、按照从起点至终点的方向，遍历各个加油站之间的距离
 *      3、每次需要走两个加油站之间的距离d,如果发现气球不够走距离d的时候，
 *          从最大堆中取出一个油量添加，直到可以足够走距离d
 *      4、如果把最大堆的汽油都添加仍然不够行进距离d，则无法到达终点。
 *      5、当前油量P减少d
 *      6、将当前加油站油量添至最大堆
 *
 *
 * @Author liuliang
 * @Date   2019/5/16 0016 17:38
 */
public class Expedition {

    /**
     * @param L 起点到终点的距离
     * @param P 起点处的汽油量
     * @param stop  [加油站至终点的距离][加油站汽油量]  n行2列
     * @return 加油的次数
     */
    public static int get_mininum_stop(int L, int P,int[][] stop){

        PriorityQueue<Integer> Q = new PriorityQueue<>(11, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {

                return o2 - o1;
            }
        });
        int result = 0;

        Arrays.sort(stop,Comparator.comparingInt(o -> -o[0]));
        System.out.println(stop[0][0]);
        for (int[] aStop : stop) {
            int dis = L - aStop[0];   //耗油量
            while (!Q.isEmpty() && P - dis < 0) {
                P += Q.peek();
                Q.poll();
                result++;
            }
            if (!Q.isEmpty() && P < dis) {
                return -1;
            }
            P = P - dis;
            L = aStop[0];
            Q.add(aStop[1]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] stop = {{15,2},{11,5},{10,3},{4,4},{0,0}};
        System.out.println(get_mininum_stop(25,16,stop));
    }

}

