package com.nowcoder;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static int validNum(int N) {
        if (N == 0) {
            return 0;
        }
        if (N == 1) {
            return 2;
        }
        int[] dp = new int[2];
        dp[0] = 2;
        dp[1] = 3;
        for (int i = 2; i < N; i++) {
           int tmp = dp[0] + dp[1];
           dp[0] = dp[1];
           dp[1] = tmp;
        }

        return dp[1];
    }

    /**
     * "c12m23b3n4t56"
     * @param s  "c12m23b3n4t56"
     * @return [12, 23, 3, 4, 56]
     */
    public static ArrayList<Integer> extraNum (String s) {
        ArrayList<Integer> res = new ArrayList<>();
        int leftIdx = 0;
        int rightIdx = 0;
        char[] chars = s.toCharArray();
        while (rightIdx < chars.length) {
            if (!isNum(chars[rightIdx])) {
                rightIdx++;
            } else {
                leftIdx = rightIdx++;
                while (rightIdx < chars.length && isNum(chars[rightIdx])) {
                    rightIdx++;
                }
                res.add(translateNum(chars, leftIdx, rightIdx - 1));
            }
        }

        return res;
    }

    private static boolean isNum(char c) {
        return c >= '0' && c <= '9';
    }

    private static Integer translateNum(char[] chars, int startIndex, int endIndex) {
        int res = 0;
        while (startIndex < endIndex) {
            res += chars[startIndex++] - '0';
            res *= 10;
        }

        res += chars[endIndex] - '0';
        return res;
    }


    public static void main(String[] args) {
//        int data = 5;
//        System.out.println(validNum(data));
        String dataStr = "c12m23b3n4t56";
        ArrayList<Integer> integers = extraNum(dataStr);
        System.out.println(integers);
    }

}
