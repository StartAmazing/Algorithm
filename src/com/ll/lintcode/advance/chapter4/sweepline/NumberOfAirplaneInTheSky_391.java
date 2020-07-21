package com.ll.lintcode.advance.chapter4.sweepline;

import java.util.*;

/**
 * 给出飞机的起飞和降落时间的列表，用序列 interval 表示. 请计算出天上同时最多有多少架飞机？
 * <p>
 * 如果多架飞机降落和起飞在同一时刻，我们认为降落有优先权。
 * <p>
 * 您在真实的面试中是否遇到过这个题？
 * 样例
 * 样例 1:
 * <p>
 * 输入: [(1, 10), (2, 3), (5, 8), (4, 7)]
 * 输出: 3
 * 解释:
 * 第一架飞机在1时刻起飞, 10时刻降落.
 * 第二架飞机在2时刻起飞, 3时刻降落.
 * 第三架飞机在5时刻起飞, 8时刻降落.
 * 第四架飞机在4时刻起飞, 7时刻降落.
 * 在5时刻到6时刻之间, 天空中有三架飞机.
 * 样例 2:
 * <p>
 * 输入: [(1, 2), (2, 3), (3, 4)]
 * 输出: 1
 * 解释: 降落优先于起飞.
 */
class Interval {
    public int start, end;
    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

class Point implements Comparable<Point>{
    public int idx;
    public int flag;
    public Point(){

    }
    public Point(int idx, int flag) {
        this.idx = idx;
        this.flag = flag;
    }

    @Override
    public int compareTo(Point o) {
        if(this.idx == o.idx) {
            return this.flag - o.flag;
        }
        return this.idx - o.idx;
    }
}
public class NumberOfAirplaneInTheSky_391 {

    public int countOfAirplanes(List<Interval> airplanes) {
        if (null == airplanes || airplanes.size() < 1) {
            return  0;
        }

        List<Point> points = new ArrayList<>();
        for (Interval ele : airplanes) {
            points.add(new Point(ele.start, 1));
            points.add(new Point(ele.end, 0));
        }

        Collections.sort(points);
        int max = 0;
        int sum = 0;
        for (int i = 0; i < points.size(); i++) {
            Point point = points.get(i);
            if (point.flag == 1) {
                sum++;
            } else {
                sum--;
            }
            max = Math.max(sum, max);
        }
        return max;
    }

    public static void main(String[] args) {
        Interval i1 = new Interval(49, 52);
        Interval i2 = new Interval(41, 52);
        Interval i3 = new Interval(52, 55);

        List<Interval> data = new ArrayList<>();
        data.add(i1);
        data.add(i2);

        NumberOfAirplaneInTheSky_391 dto = new NumberOfAirplaneInTheSky_391();
        int i = dto.countOfAirplanes(data);
        System.out.println(i);

    }

}
