package com.ll.zs.question;


import java.util.Arrays;

/**
 * 有一排正数，玩家A和玩家B都可以看到。
 * 每位玩家在拿走数字的时候，都只能从最左和最右的数中选择一个。
 * 玩家A先拿，玩家B再拿，两人交替拿走所有的数字，
 * 两人都力争自己拿到的数的总和比对方多。请返回最后获胜者的分数。
 * <p>
 * 例如：
 * 5,2,3,4
 * 玩家A先拿，当前他只能拿走5或者4。
 * 如果玩家A拿走5，那么剩下2，3，4。轮到玩家B，此时玩家B可以选择2或4中的一个，…
 * 如果玩家A拿走4，那么剩下5，2，3。轮到玩家B，此时玩家B可以选择5或3中的一个，…
 *
 * @Author liuliang
 * @Date 2019/5/12 0012 8:24
 */
public class Problem_03_CarsInLine {

//    public static int step = 0;

    //双递归
    public static int win01(int arr[]) {
        if (arr == null || arr.length < 1) {
            return 0;
        }
        try {
            return Math.max(f(arr, 0, arr.length - 1), s(arr, 0, arr.length - 1));
        }finally {
//            System.out.println("step: " + step);
        }
    }

    private static int f(int[] arr, int i, int j) {
        if (i == j) {
            return arr[i];
        }
//        step++;
        return Math.max(arr[i] + s(arr, i + 1, j), arr[j] + s(arr, i, j - 1));
    }

    private static int s(int[] arr, int i, int j) {
        if (i == j) {
            return 0;
        }
//        step++;
        return Math.min(f(arr, i + 1, j), f(arr, i, j - 1));
    }

    //动态规划，两张表
    public static int win02(int[] arr) {
        if(arr == null || arr.length < 1) {
            return 0;
        }
//        step = 0;
        int[][] f = new int[arr.length][arr.length];
        int[][] s = new int[arr.length][arr.length];
        for (int j = 0; j < arr.length; j ++){
            f[j][j] = arr[j];
            for(int i = j - 1; i >= 0; i--){
//                step ++ ;
                f[i][j] = Math.max(arr[i] + s[i + 1][j], arr[j] + s[i][j  - 1]);
                s[i][j] = Math.min(f[i + 1][j], f[i][j - 1]);
            }
        }

//        System.out.println("----------------------");
//        for(int i = 0; i < f.length; i++){
//            for (int j = 0 ; j < f[i].length; j ++){
//                System.out.print(" " + f[i][j] + " " );
//            }
//            System.out.println();
//        }
//        System.out.println("----------------------");
//        for(int i = 0; i < s.length; i++){
//            for (int j = 0 ; j < s[i].length; j ++){
//                System.out.print(" " + s[i][j] + " " );
//            }
//            System.out.println();
//        }
//        System.out.println("----------------------");


//        System.out.println("step: "+step);
        return Math.max(f[0][arr.length - 1],s[0][arr.length - 1]);
    }

    //一个递归
    public static int win03(int[] arr){
        if(arr == null || arr.length < 1){
            return 0;
        }
        int sum = 0;
        for (int anArr : arr) {
            sum += anArr;
        }
//        step = 0;
        int scores = p(arr, 0, arr.length - 1);
//        System.out.println("step: " + step);
        return Math.max(sum - scores, scores);
    }

    private static int p(int[] arr, int i, int j){
//        step++;
        if(i == j){
            return arr[i];
        }
        if(i + 1 == j){
            return  Math.max(arr[i], arr[j]);
        }
        return Math.max(arr[i] + Math.min(p(arr, i + 2, j), p( arr, i + 1, j - 1)),
                arr[j] + Math.min(p(arr, i + 1, j - 1), p(arr, i, j - 2)));
    }

    //一张表的动态规划
    public static int win04(int[] arr){
//        step = 0;
        if(arr == null || arr.length < 1){
            return 0;
        }
        if(arr.length == 1){
            return arr[0];
        }
        if(arr.length == 2){
            return Math.max(arr[0], arr[1]);
        }
        int sum = 0;
        for (int a :
                arr) {
            sum += a;
        }

        int[][] p = new int[arr.length][arr.length];
        for(int j = 0 ; j < p.length - 1 ; j++){
            p[j][j] = arr[j];
            p[j][j+1] = Math.max(arr[j], arr[j+1]);
        }
        p[arr.length - 1][arr.length - 1] = arr[arr.length -1];

        for(int k = 2; k < arr.length ; k++){
            for(int j = k; j < arr.length ; j++){
//                step ++;
                int i = j - k;
                p[i][j] = Math.max(arr[i] + Math.min(p[i + 2][j], p[i + 1][j - 1]),
                        arr[j] + Math.min(p[i][j - 2] ,p[i + 1][j - 1]));
            }
        }

//        System.out.println("step: " + step);
        return Math.max(p[0][arr.length - 1], sum-p[0][arr.length - 1]);
    }

    public static int[] generateRandomArray(){
        int[] res = new int[((int) Math.random() * 20)  + 1];
        for(int i = 0; i < res.length; i++){
            res[i] = (int)(Math.random() * 50) + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        int testTime = 50000;
        boolean err = false;
        for(int i = 0; i < testTime; i ++){
            int[] arr = generateRandomArray();
            int r1 = win01(arr);
            int r2 = win02(arr);
            int r3 = win03(arr);
            int r4 = win04(arr);
            if(r1 != r2 || r2 != r3 || r3 != r4){
                err = true;
                break;
            }
        }
        if(err){
            System.out.println("Test failed!");
        }else{
            System.out.println("All right!");
        }

    }


}
