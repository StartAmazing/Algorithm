package com.ll.github.notes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵的
 *  中向上下左右移动一个格子，如果一条路径经过了矩阵中的某一个格子，则路径不
 *  能再进入该格子，例如下面的矩阵包含了一条bfce的路径
 *
 *          【a  b  t  g】
 *          【c  f  c  s】
 *          【j  d  e  h】
 *  思路
 *  使用回溯法（backtracing）进行求解，它是一种暴力搜索方法，通过搜索所有的可
 *  能的结果来求解问题，回溯法在一次搜索结束之后需要进行回溯（回退），将这一
 *  次搜索过程中设置的状态进行清除，从而开始一次新的搜索过程。例如下面实例中，
 *  从f开始，下一步有四种搜索的可能，如果先搜索b，需要将b标记为已经使用，防止
 *  重复使用。在这一次搜索结束之后，需要将b的已经使用状态清除，并开始搜索c
 *
 *          【a  b  t  g】
 *          【c  f  c  s】
 *          【j  d  e  h】
 *
 */
public class StrPathInMatrix {

    private final static int[][] next = {{0,-1}, {0, 1}, {1, 0}, {-1, 0}};
    private int rows;
    private int cols;

    public boolean hasPath(char[] array, int rows, int cols, char[] str){
        if(rows == 0 || cols == 0){
            return false;
        }
        this.rows = rows;
        this.cols = cols;
        boolean [][] marked = new boolean[rows][cols];
        char[][] matrix = buildMatrix(array);
        for(int i = 0; i < rows; i ++){
            for(int j = 0 ; j < cols ; j ++){
                if(backtracking(matrix,str,marked,0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtracking(char[][] matrix, char[] str,boolean[][] marked, int pathLen, int r, int c){
        if(pathLen == str.length) {
            return true;
        }
        if(r < 0 || r >= rows || c < 0 || c >= cols
                || matrix[r][c] != str[pathLen] || marked[r][c]){
            return false;
        }
        marked[r][c] = true;
        for (int[] n : next) {
            if (backtracking(matrix, str, marked, pathLen + 1, r + n[0], c + n[1])) {
                return true;
            }
        }
        marked[r][c] = false;
        return false;
    }

    private char[][] buildMatrix(char[] array){
        char[][] matrix = new char[rows][cols];
        for (int r = 0, idx = 0;  r < rows; r ++){
            for(int c = 0; c < cols; c ++){
                matrix[r][c] = array[idx ++];
            }
        }
        return matrix;
    }


    public static boolean validPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        char[] charArr = s.toCharArray();
        int chance = 1;
        while(i <= j){
            if(charArr[i] == charArr[j]){
                i ++;
                j --;
            }else{
                return isValid(s,i + 1,j) || isValid(s,i,j - 1);
            }
        }
        return true;
    }
    private static boolean isValid(String str, int i, int j){
        while(i < j){
            if(str.charAt(i ++) != str.charAt(j --)) {
                return false;
            }
        }
        return true;
    }


    public static String findLongestWord(String s, List<String> d) {
        ArrayList<String> subStr = new ArrayList<>();
        for(String ele : d) {
            int i = 0;
            int j = 0;
            while(i < s.length() && j < ele.length()){
                if(s.charAt(i) == ele.charAt(j)){
                    i++;
                    j++;
                }else{
                    i++;
                }
            }
            if(j == ele.length()){
                subStr.add(ele);
            }
        }
        String res = "";
        for(String ele : subStr){
            if(ele.length() != res.length()){
                res = ele.length() > res.length() ? ele : res;
            }else{
                for(int i = 0 ; i < ele.length(); i++){
                    if(ele.charAt(i) < res.charAt(i)){
                        res = ele;
                        break;
                    }else if(ele.charAt(i) > res.charAt(i)){
                        break;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("word", "good", "best", "good");
        String str = "wordgoodgoodgoodbestword";
        String longestWord = findLongestWord(str, strings);
        System.out.println(longestWord);

    }

}
