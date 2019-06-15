package com.ll.leetcode.exercise.greed_part_3;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 已知在一个平面上有一定数量的气球，平面可以看做一个坐标系，在平面的x轴的不同位置
 * 安排弓箭手向y轴方向射箭，弓箭可以向y轴走无穷远；给定气球的宽度xstart ≤x≤xend,
 * 问需要多少弓箭手可以将全部气球打爆？
 * <p>
 * 例如：四个气球：[[10,16]、[2,8]、[1,6]、[7,12]]，至少需要两个弓箭手
 * <p>
 * 贪心规律：
 * 1、对于某个气球：至少需要使用1支弓箭将它击穿；
 * 2、在这只气球将其击穿的同时，尽可能击穿其他更多的气球！（贪心！）
 * 算法思路：
 * 1、对各个气球进行排序，按照气球的左端点从小到大排序；
 * 2、遍历气球数组，同时维护一个射击区间，在满足可以将当前气球射穿的情况下，尽可能
 * 击穿更多的气球，每击穿一个新的气球，更新一个射击区间（保证射击区间可以将新气球也击穿）
 * 3、如果新的气球没办法被击穿了，则需要增加一名弓箭手，即维护一个新的射击区间（将该气球
 * 击穿），随后继续遍历气球数组
 * <p>
 * LeetCode 452  BrustBalloons
 * It's medium
 */
public class BrustBalloons {

    public static int findMinArrowShots(int[][] points) {
        if (points.length < 1) {
            return 0;
        }

//        sortArr(points);
        Arrays.sort(points, Comparator.comparingInt(o -> o[0]));
        int shoot_times = 1;
        int shoot_end = points[0][1];

        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > shoot_end) {
                shoot_times++;
                shoot_end = points[i][1];
            } else {
                shoot_end = points[i][1] < shoot_end ? points[i][1] : shoot_end;
            }
        }
        return shoot_times;
    }

//    private static void sortArr(int[][] points){
//        for(int i = 0; i < points.length; i++){
//            for(int j = i + 1; j < points.length; j ++){
//                if(points[i][0] > points[j][0]){
//                    int tmp1 = points[i][0];
//                    int tmp2 = points[i][1];
//                    points[i][0] = points[j][0];
//                    points[i][1] = points[j][1];
//                    points[j][0] = tmp1;
//                    points[j][1] = tmp2;
//                }
//            }
//        }
//    }

    public static void main(String[] args) {
        int[][] nums = {{9, 12}, {1, 10}, {4, 11}, {8, 12}, {3, 9}, {6, 9}, {6, 7}};
        System.out.println(findMinArrowShots(nums));


    }

}
