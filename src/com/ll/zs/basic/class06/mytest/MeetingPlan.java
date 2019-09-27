package com.ll.zs.basic.class06.mytest;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 一些项目要占用一个会议室宣讲，会议室不能同时容纳两个项目的宣讲
 * 。给你每一个项目开始的时间和结束的时间（给你一个数组，里面是一个
 * 个具体的项目），你来安排宣讲的日程，要求会议室进行的宣讲的场次最多。
 * 返回这个最多的宣讲场次
 *
 *  1、按照开始时间最早安排？  ×
 *  2、按照占用时间最短？ ×
 *  3、按照最早时间结束？ √这种方式选择，数量最多
 */
public class MeetingPlan {
    public static class Program{
        int start;
        int end;
        public Program(int start, int end){
            this.start = start;
            this.end = end;
        }
    }

    public static class ProgramComparator implements Comparator<Program>{

        @Override
        public int compare(Program o1, Program o2) {
            return o1.end - o2.end;
        }
    }

    public static int bestPlanOfMeeting(Program[] programs, int start){
        Arrays.sort(programs,new ProgramComparator());
        int count = 0;
        for (int i = 0; i < programs.length; i++){
            if(programs[i].start >= start){
                count ++;
                start =  programs[i].end;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Program[] programs = new Program[]{
                new Program(3,5),
                new Program(4,7),
                new Program(6,12),
                new Program(8,11),
                new Program(13,15),
                new Program(16,20)
        };
        int i = bestPlanOfMeeting(programs, 2);
        System.out.println(i);
    }


}
