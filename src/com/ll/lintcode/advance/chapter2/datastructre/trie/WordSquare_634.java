package com.ll.lintcode.advance.chapter2.datastructre.trie;

import java.util.List;

/**
 * 给出一系列 不重复的单词，找出所有用这些单词能构成的 单词矩阵。
 * 一个有效的单词矩阵是指, 如果从第 k 行读出来的单词和第 k 列读出来的单词相同(0 <= k < max(numRows, numColumns))，那么就是一个单词矩阵.
 * 例如，单词序列为 ["ball","area","lead","lady"] ,构成一个单词矩阵。因为对于每一行和每一列，读出来的单词都是相同的。
 *
 * b a l l
 * a r e a
 * l e a d
 * l a d y
 * 现在至少有一个单词并且不多于1000个单词
 * 所有的单词都有相同的长度
 * 单词的长度最短为 1 最长为 5
 * 每一个单词均由小写字母组成
 *
 * 您在真实的面试中是否遇到过这个题？
 * 样例
 * 样例 1:
 *
 * 输入:
 * ["area","lead","wall","lady","ball"]
 * 输出:
 * [["wall","area","lead","lady"],["ball","area","lead","lady"]]
 *
 * 解释:
 * 输出包含 两个单词矩阵，这两个矩阵的输出的顺序没有影响(只要求矩阵内部有序)。
 * 样例 2:
 *
 * 输入:
 * ["abat","baba","atan","atal"]
 * 输出:
 *  [["baba","abat","baba","atan"],["baba","abat","baba","atal"]]
 */
public class WordSquare_634 {
    /*
     * @param words: a set of words without duplicates
     * @return: all word squares
     */
    public List<List<String>> wordSquares(String[] words) {
        // write your code here
        return null;
    }
}
