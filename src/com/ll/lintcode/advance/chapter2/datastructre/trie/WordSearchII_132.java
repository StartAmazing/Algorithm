package com.ll.lintcode.advance.chapter2.datastructre.trie;

import java.util.*;

/**
 * 给出一个由小写字母组成的矩阵和一个字典。找出所有同时在字典和矩阵中出现的单词。
 * 一个单词可以从矩阵中的任意位置开始，可以向左/右/上/下四个相邻方向移动。
 * 一个字母在一个单词中只能被使用一次。且字典中不存在重复单词
 *
 * 您在真实的面试中是否遇到过这个题？
 * 样例
 * 样例 1:
 *
 * 输入：["doaf","agai","dcan"]，["dog","dad","dgdg","can","again"]
 * 输出：["again","can","dad","dog"]
 * 解释：
 *   d o a f
 *   a g a i
 *   d c a n
 * 矩阵中查找，返回 ["again","can","dad","dog"]。
 * 样例 2:
 *
 * 输入：["a"]，["b"]
 * 输出：[]
 * 解释：
 *  a
 * 矩阵中查找，返回 []。
 */
class WordSearcIIhNode {
    public String s;
    public boolean isString;
    public Map<Character, WordSearcIIhNode> subtree;

    public WordSearcIIhNode() {
        isString = false;
        subtree = new HashMap<>();
        s = "";
    }
}

class TrieTree {
    WordSearcIIhNode root;
    public TrieTree(WordSearcIIhNode TrieNode) {
        root = TrieNode;
    }

    public void insert(String s) {
        WordSearcIIhNode now = root;
        for (int i = 0; i < s.length(); i++) {
            if(!now.subtree.containsKey(s.charAt(i))) {
                now.subtree.put(s.charAt(i), new WordSearcIIhNode());
            }

            now = now.subtree.get(s.charAt(i));
        }
        now.s = s;
        now.isString = true;
    }

    public boolean find(String s) {
        WordSearcIIhNode now = root;
        for (int i = 0; i < s.length(); i++) {
            if (!now.subtree.containsKey(s.charAt(i))) {
                return false;
            }

            now = now.subtree.get(s.charAt(i));
        }

        return now.isString;
    }
}

public class WordSearchII_132 {
    public int[] dx = {1, 0, -1, 0};
    public int[] dy = {0, -1, 0, 1};

    public void search(char[][] board, int x, int y, WordSearcIIhNode root, List<String> ans) {
        if (root.isString) {
            if (!ans.contains(root.s)) {
                ans.add(root.s);
            }
        }

        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length || board[x][y] == 0) {
            return;
        }

        if (root.subtree.containsKey(board[x][y])) {
            for (int i = 0; i < 4; i ++) {
                char now = board[x][y];
                board[x][y] = 0;
                search(board, x + dx[i], y + dy[i], root.subtree.get(now), ans);
                board[x][y] = now;
            }
        }

    }

    public List<String> wordSearchII(char[][] board, List<String> words) {
        List<String> ans = new ArrayList<>();
        TrieTree tree = new TrieTree(new WordSearcIIhNode());
        for (String word : words) {
            tree.insert(word);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                search(board, i, j, tree.root, ans);
            }
        }

        return ans;
    }
}
