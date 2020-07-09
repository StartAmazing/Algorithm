package com.ll.lintcode.advance.chapter2.datastructre.trie;

/**
 * 给出一个二维的字母板和一个单词，寻找字母板网格中是否存在这个单词。
 * <p>
 * 单词可以由按顺序的相邻单元的字母组成，其中相邻单元指的是水平或者垂直方向相邻。每个单元中的字母最多只能使用一次。
 * <p>
 * 您在真实的面试中是否遇到过这个题？
 * 样例
 * 样例 1:
 * <p>
 * 输入：["ABCE","SFCS","ADEE"]，"ABCCED"
 * 输出：true
 * 解释：
 * [
 * A B C E
 * S F C S
 * A D E E
 * ]
 * (0,0)A->(0,1)B->(0,2)C->(1,2)C->(2,2)E->(2,1)D
 * 样例 2:
 * <p>
 * 输入：["z"]，"z"
 * 输出：true
 * 解释：
 * [ z ]
 * (0,0)z
 */
public class WordSearch_123 {
    /**
     * @param board: A list of lists of character
     * @param word:  A string
     * @return: A boolean
     */
    public boolean exist(char[][] board, String word) {
        // write your code here
        return false;
    }
}
