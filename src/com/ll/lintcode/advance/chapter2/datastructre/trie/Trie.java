package com.ll.lintcode.advance.chapter2.datastructre.trie;

import java.util.HashMap;
import java.util.Map;

/**
 * 实现一个 Trie，包含 insert, search, 和 startsWith 这三个方法。
 * <p>
 * 样例
 * 样例 1:
 * <p>
 * 输入:
 * insert("lintcode")
 * search("lint")
 * startsWith("lint")
 * 输出:
 * false
 * true
 * 样例 2:
 * <p>
 * 输入:
 * insert("lintcode")
 * search("code")
 * startsWith("lint")
 * startsWith("linterror")
 * insert("linterror")
 * search("lintcode”)
 * startsWith("linterror")
 * 输出:
 * false
 * true
 * false
 * true
 * true
 * 注意事项
 * 你可以认为所有的输入都是小写字母a-z。
 */


public class Trie {
    class TrieNode {
        public char c;
        public Map<Character, TrieNode> children = new HashMap<>();
        public boolean isEnd;

        public TrieNode() {

        }

        public TrieNode(char c) {
            this.c = c;
        }
    }

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    /*
     * @param word: a word
     * @return: nothing
     */
    public void insert(String word) {
        TrieNode cur = root;
        Map<Character, TrieNode> curChildren = root.children;
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (curChildren.containsKey(chars[i])) {
                cur = curChildren.get(chars[i]);
            } else {
                TrieNode newNode = new TrieNode(chars[i]);
                curChildren.put(chars[i], newNode);
                cur = newNode;
            }

            curChildren = cur.children;
            if (i == chars.length - 1) {
                cur.isEnd = true;
            }
        }
    }

    /*
     * @param word: A string
     * @return: if the word is in the trie.
     */
    public boolean search(String word) {
        return searchWordNodePos(word) != null && searchWordNodePos(word).isEnd;
    }

    /*
     * @param prefix: A string
     * @return: if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        return searchWordNodePos(prefix) != null;
    }

    private TrieNode searchWordNodePos(String s) {
        Map<Character, TrieNode> children = root.children;
        TrieNode cur = null;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (children.containsKey(chars[i])) {
                cur = children.get(chars[i]);
                children = cur.children;
            } else {
                return null;
            }
        }

        return cur;
    }
}
