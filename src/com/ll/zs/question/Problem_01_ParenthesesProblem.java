package com.ll.zs.question;

/**
 * 1、已知一个字符串都是由左括号(和右括号)组成，判断该字符串是否是有效的括号组合。
 *
 * 例子：
 * 有效的括号组合:()(),(()),(()())
 * 无效的括号组合:(,()),((),()(()
 *
 *
 * 2、题目进阶：
 * 已知一个字符串都是由左括号(和右括号)组成，返回最长有效括号子串的长度
 *
 * @Author liuliang
 * @Date   2019/5/12 0012 13:52
 */
public class Problem_01_ParenthesesProblem {

    //判断是否有效
    public static boolean isValid(String str){
        if(str == null || "".equals(str)){
            return false;
        }
        char[] chars = str.toCharArray();
        int status = 0;
        for (char aChar : chars) {
            if (aChar != ')' && aChar != '(') {
                return false;
            }
            if (aChar == ')' && --status < 0) {
                return false;
            }
            if (aChar == '(') {
                status++;
            }
        }
        return status==0;
    }

    //最长有效子串长度
    public static int maxLength(String str){
        if(str == null || "".equals(str)){
            return 0;
        }
        char[] chars = str.toCharArray();
        int[] dp = new int[chars.length];
        int pre = 0;
        int res = 0;
        for (int i = 1; i < chars.length; i ++){
            if(chars[i] == ')'){
                pre = i - dp[i - 1] - 1;
                if(pre >= 0 && chars[pre] == '('){
                    dp[i] = dp[i - 1] + 2 + (pre > 0 ? dp[pre - 1] : 0);
                }
            }
            res = Math.max(res,dp[i]);
        }
        return res;
    }


    public static void main(String[] args) {
        String str1 = "())())()";
        String str2 = "()(())()";
        String str3 = "()()()";
        String str4 = "(())())";

        System.out.println(isValid(str1));
        System.out.println(isValid(str2));
        System.out.println(isValid(str3));
        System.out.println(isValid(str4));

        System.out.println(maxLength(str1));
        System.out.println(maxLength(str2));
        System.out.println(maxLength(str3));
        System.out.println(maxLength(str4));

    }


}
