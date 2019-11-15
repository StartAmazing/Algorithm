package com.ll.leetcode;

import com.ll.muke.queue.Array;

import java.util.List;
import java.util.ArrayList;

/**
 * @Author liuliang
 * @Date   2019/4/3 0003 21:06
 */
//给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
public class ProduceBracket_22 {

    /**
     * 1、暴力法
     * 思路
     *
     * 我们可以生成所有 2^{2n}2
     * 2n
     *   个 '(' 和 ')' 字符构成的序列。然后，我们将检查每一个是否有效。
     *
     * 算法
     *
     * 为了生成所有序列，我们使用递归。长度为 n 的序列就是 '(' 加上所有长度为 n-1 的序列，以及 ')' 加上所有长度为 n-1 的序列。
     *
     * 为了检查序列是否为有效的，我们会跟踪平衡，也就是左括号的数量减去右括号的数量的净值。如果这个值始终小于零或者不以零结束，该序列就是无效的，否则它是有效的。
     * @param num 括号的对数
     */
    public static List<String> solution1(int num){
        List<String> combinations = new ArrayList<>();
        generateAll(new char[2 * num], 0, combinations);
        return combinations;
    }

    /**
     * @param current 数组用来保存所有的符号，长度为num*2
     * @param pos   数组下标
     * @param result 结果
     */
    private static void generateAll(char[] current, int pos, List<String> result){
        if(pos == current.length){
//            System.out.println(new String(current));
            if(valid(current))
                result.add(new String(current));
        }else{
            current[pos] = '(';
            generateAll(current,pos+1, result);
            current[pos] = ')';
            generateAll(current,pos+1,result);
        }
    }

    /**
     * 判断一个括号序列是否合法
     * @param current
     * @return
     */
    private static boolean valid(char[] current){
        int balance = 0;
        for(char c: current){
            if(c == '(') balance++;
            else balance--;
            if(balance < 0) return false;
        }
        return (balance ==0);
    }

    /**
     * 回溯法
     * 思路和算法
     *
     * 只有在我们知道序列仍然保持有效时才添加 '(' or ')'，而不是像方法一那样每次添加。我们可以通过跟踪到目前为止放置的左括号和右括号的数目来做到这一点，
     *
     * 如果我们还剩一个位置，我们可以开始放一个左括号。 如果它不超过左括号的数量，我们可以放一个右括号。
     * @param num 括号的对数
     * @return 所有合法序列
     */
    public static List<String> solution2(int num){
        List<String> ans = new ArrayList<>();
        backtrack(ans,"",0,0,num);
        return ans;
    }

    /**
     * @param ans   结果收集集合
     * @param cur   当前字符串
     * @param open  （个数
     * @param close     ）个数
     * @param max   对数
     */
    private static void backtrack(List<String> ans, String cur, int open,int close,int max){
        if(cur.length() == max * 2){
            ans.add(cur);
            return;
        }
        if(open < max){
            backtrack(ans, cur+"(",open +1,close,max);
        }
        if(close < open){
            backtrack(ans, cur +")",open,close+1,max);
        }
    }

    /**
     * 3、闭合数
     * 思路
     *
     * 为了枚举某些内容，我们通常希望将其表示为更容易计算的不相交子集的总和。
     *
     * 考虑有效括号序列 S 的闭包数：至少存在index> = 0，使得 S[0], S[1], ..., S[2*index+1]是有效的。 显然，每个括号序列都有一个唯一的闭包号。 我们可以尝试单独列举它们。
     *
     * 算法
     *
     * 对于每个闭合数 c，我们知道起始和结束括号必定位于索引 0 和 2*c + 1。然后两者间的 2*c 个元素一定是有效序列，其余元素一定是有效序列。
     * @param num 括号的对数
     */
    public static List<String> solution3(int num){
        List<String> ans =new ArrayList<>();
        if(num == 0){
            ans.add("");
        }else{
            for(int c = 0; c < num; ++c ){
                for(String left : solution3(c))
                    for(String right : solution3(num-1-c)){
                        ans.add("(" + left +")" + right);
                    }
            }
        }
        return ans;
    }

    public static List<String> generateParenthesis(int n) {
        ArrayList<String> resList = new ArrayList<>();
        generateAllx(new char[n * 2], 0, resList);
        return resList;
    }
    private static void generateAllx(char[] current, int pos, List<String> resList){
        if(pos == current.length){
            if(isValidx(current)){
                resList.add(new String(current));
            }
        }else{
            current[pos] = ')';
            generateAll(current, pos ++ , resList);
            current[pos] = '(';
            generateAll(current, pos ++ , resList);
        }
    }
    private static boolean isValidx(char[] current){
        int balance = 0;
        for(char c : current){
            if( c == '(') balance ++;
            if( c == ')') balance --;
            if(balance < 0) return false;
        }
        return balance == 0;
    }


    private static ArrayList<String> step1(int num){
        ArrayList<String> resList = new ArrayList<>();
        step2(new char[2 * num], 0, resList);
        return resList;
    }
    private static void step2(char[] chars, int start, ArrayList<String> resList){
        if(start == chars.length){
            if(step3(chars)){
                resList.add(new String(chars));
            }
        }else {
            chars[start] = ')';
            step2(chars, start + 1,resList);
            chars[start] = '(';
            step2(chars, start + 1,resList);
        }
    }
    private static boolean step3(char[] chars){
        int balance = 0;
        for (int i = 0 ; i < chars.length; i ++){
            if(chars[i] == ')') balance -- ;
            if(chars[i] == '(') balance ++;
            if(balance < 0) return false;
        }
        return balance == 0;
    }

    private static ArrayList<String> step4(int num){
        ArrayList<String> resList = new ArrayList();
        step5(0,0,num,resList,"");
        return resList;
    }
    private static void step5(int open, int close, int max, ArrayList<String> resList, String cur){
        if(cur.length() == max * 2){
            resList.add(cur);
            return;
        }
        if(open < max){
            step5(open + 1, close, max, resList, cur + "(");
        }
        if(close < open){
            step5(open,close + 1, max, resList, cur + ")");
        }
    }

    private static ArrayList<String> step6(int num){

    }



    public static void main(String[] args) {
//        System.out.println(solution1(3));
//        System.out.println(solution2(3));
//        System.out.println(solution3(3));
//
//
//        System.out.println(generateParenthesis(7));
//
//        System.out.println(step1(3));
//        System.out.println(step4(3));
        System.out.println("hello".split(",").length);
    }

}
