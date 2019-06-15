package com.ll.leetcode;

public class IntegerReverse_07 {

    public static int solution(int x){
        int rev = 0;
        while(x != 0){
            int pop = x % 10;
            x /= 10;
            if(rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop >  7)) return 0;
            if(rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }

    public static void main(String[] args) {
        int solution = solution(1234);
        System.out.println(solution);
        solution = solution(-1234);
        System.out.println(solution);
        solution = solution(-9324);
        System.out.println(solution);
    }

}
