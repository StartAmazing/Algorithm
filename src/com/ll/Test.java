package com.ll;

import java.util.*;

public class Test{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int idx = 0;
//        int[] noOrderArray = new int[n];
//        while (idx < n) {
//            noOrderArray[idx] = sc.nextInt();
//            idx++;
//        }
//
//        idx = 0;
//        int m = sc.nextInt();
//        int[] orderArray = new int[m];
//        while (idx < m) {
//            orderArray[idx] = sc.nextInt();
//            idx++;
//        }
//        int[] ints = mergeTwoList(noOrderArray, orderArray);
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < ints.length; i++) {
//            sb.append(ints[i]);
//            if (i != ints.length - 1) {
//                sb.append(" ");
//            }
//        }
//        System.out.println(sb);

        int time = sc.nextInt();
        int tasks = sc.nextInt();
        int[][] tasksArr = new int[tasks][2];
        for (int i = 0; i < tasks; i++) {
            tasksArr[i][0] = sc.nextInt();
            tasksArr[i][1] = sc.nextInt();
        }

        int[] ints = maxProfit(time, tasksArr);
        System.out.println(ints[0]);
        System.out.println(ints[1]);
    }

    private static int[] maxProfit(int time,
                                   int[][] tasksArr) {
        // idx0 = profit, idx1 = number of task
        int[] res = new int[2];
        List<Task> tasks = new ArrayList<>();
        for (int[] ints : tasksArr) {
            tasks.add(new Task(ints[0], ints[1]));
        }
        tasks.sort((o1, o2) -> {
            if (o1.time == o2.time) {
                return o2.profit - o1.profit;
            }
            return o1.time - o2.time;
        });
        for (int i = 0; i < tasks.size(); i++) {
            int remindTime = time;
            List<Task> subTasks = new ArrayList<>();
            for (int j = i; j < tasks.size(); j ++) {
                if (remindTime -tasks.get(j).time < 0) {
                    j--;
                    updateProfit(res, subTasks);
                    if (subTasks.size() > 0) {
                        remindTime += subTasks.get(subTasks.size() - 1).time;
                        subTasks.remove(subTasks.size() - 1);
                    }
                } else {
                    remindTime -= tasks.get(j).time;
                    subTasks.add(tasks.get(j));
                }
            }
            updateProfit(res, subTasks);
        }

        return res;
    }

    private static void updateProfit(int[] res, List<Task> subTasks) {
        int sumProfit = 0;
        for (Task subTask : subTasks) {
            sumProfit += subTask.profit;
        }
        if (sumProfit >= res[0]) {
            if (sumProfit > res[0] || subTasks.size()> res[1]) {
                res[0] = sumProfit;
                res[1] = subTasks.size();
            }
        }
    }

    static class Task{
        int time;
        int profit;

        public Task(int time, int profit) {
            this.time = time;
            this.profit = profit;
        }
    }

    private static int[] mergeTwoList(int[] noOrder,
                                      int[] order) {

        Arrays.sort(noOrder);
        int m = noOrder.length;
        int n = order.length;
        int[] res = new int[m + n];
        int idx1 = 0, idx2 = 0, idx3 = 0;
        while (idx1 < m && idx2 < n) {
            if (noOrder[idx1] < order[idx2]) {
                res[idx3++] = noOrder[idx1++];
            } else {
                res[idx3++] = order[idx2++];
            }
        }

        while (idx1 < m) {
            res[idx3++] = noOrder[idx1++];
        }

        while (idx2 < n) {
            res[idx3++] = order[idx2++];
        }

        return res;
    }
}
