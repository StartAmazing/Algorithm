package com.ll.leetcode;

//判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
public class IsPalindrome_09 {

    public static boolean solution(int x){
        //特殊情况：
        /**
         * 如上所述，当 x < 0 时，x不是回文数
         * 同样的，如果数字的最后一位0，为了使该数字为回文
         * 则其第一位数字应该是0
         * 只有0满足这一性质
         */
        if(x < 0 || (x % 10 == 0 && x != 0)){
            return false;
        }

        int revertedNumber = 0;
        while(x > revertedNumber){
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }

        //当数字长度为奇数时，我们可以通过revertedNumber/10去除处于中位的数字
        //例如，当输入为12321时，在while循环的末尾我们可以得到x = 12，revertedNumber = 123
        //由于处于中位数的数字不影响回文（它总是与自己相等），所以我们可以简单地将其去除
        return x == revertedNumber || x == revertedNumber/10;
    }

    public static void main(String[] args) {
        int a =  1234321;
        boolean b = solution(a);
        System.out.println(b);
        b = solution(1234553);
        System.out.println(b);
    }

}
