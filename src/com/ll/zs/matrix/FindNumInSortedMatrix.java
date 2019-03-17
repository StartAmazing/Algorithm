package com.ll.zs.matrix;

public class FindNumInSortedMatrix {

    public static boolean isContains(int[][] m, int k){
        int row = 0;
        int col = m[0].length - 1;
        int step = 0;
        while( row < m.length && col >= 0){
            if(m[row][col] == k){
                System.out.println("step : " + step);
                return true;
            }else if(m[row][col] > k){
                col--;
                step++;
            }else{
                row++;
                step++;
            }
        }
        return false;
    }

    public static void main(String[] args){
        int[][] m = {{1,2,4,7},{3,4,5,9},{6,8,9,12},{7,11,15,17}};
        isContains(m,6);
    }
}
