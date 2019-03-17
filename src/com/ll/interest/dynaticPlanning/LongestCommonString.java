package com.ll.interest.dynaticPlanning;

import java.util.Scanner;

//求两个字符串的最长公共子序列
public class LongestCommonString {
    public static int[][] b = new int[1002][1002];
    public static char[] c1;
    public static char[] c2;
    public static int[][] LCSL(String s1,String s2){
        int len1 = s1.length();
        int len2 = s2.length();
        c1 = s1.toCharArray();
        c2 = s2.toCharArray();
        int[][] c = new int[len1+1][len2+1];
        int i,j;
        for(i = 0 ; i < len1; i++){
            c[i][0] = 0;
        }
        for(j = 0; j < len2; j ++){
            c[0][j] = 0;
        }
        for(i = 1; i <= len1; i++){
            for(j = 1; j <= len2; j++){
                if(c1[i - 1] == c2[j - 1]) {  //如果当前字符相同则公共子序列的长度为该字符前的最长公共序列+1
                    c[i][j] = c[i - 1][j - 1] + 1;
                    b[i][j] = 1;
                }else{
                    if(c[i][j - 1] >= c[i - 1][j]){
                        c[i][j] = c[i][j-1];
                        b[i][j] = 2;
                    }else{
                        c[i][j] = c[i-1][j];
                        b[i][j] = 3;
                    }
                }
            }
        }
        return c;
    }

    public static void print(int i,int j){
        if(i == 0 || j==0){
            return;
        }
        if(b[i][j] == 1){
            print(i-1,j-1);
            System.out.print(c1[i-1]);
        }else{
            if(b[i][j] == 2){
                print(i, j-1);
            }else{
                print(i-1, j);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please input s1: ");
        String s1 = sc.nextLine();
        System.out.println("Please input s2: ");
        String s2 = sc.nextLine();
        int[][] lcsl = LCSL(s1, s2);
        System.out.println("s1和s2的最长公共子序列的长度是： " + lcsl[s1.length()][s2.length()]);
        System.out.print("s1和s2的最长公共子序列为： ");
        print(s1.length(),s2.length());
    }
}

