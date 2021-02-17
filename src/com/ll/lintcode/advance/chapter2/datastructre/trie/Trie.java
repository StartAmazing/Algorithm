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
class TrieNode {
    public char c;
    public Map<Character, TrieNode> childMap = new HashMap<>();
    public boolean isEnd;

    public TrieNode() {

    }

    public TrieNode(char c) {
        this.c = c;
    }
}

public class Trie {


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
        Map<Character, TrieNode> childMap = root.childMap;
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (childMap.containsKey(chars[i])) {
                cur = childMap.get(chars[i]);
            } else {
                TrieNode newNode = new TrieNode(chars[i]);
                childMap.put(chars[i], newNode);
                cur = newNode;
            }

            childMap = cur.childMap;
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
        TrieNode resNode = searchWordNodePos(word);
        return resNode != null && resNode.isEnd;
    }

    /*
     * @param prefix: A string
     * @return: if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        return searchWordNodePos(prefix) != null;
    }

    private TrieNode searchWordNodePos(String s) {
        Map<Character, TrieNode> childMap = root.childMap;
        TrieNode cur = null;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (childMap.containsKey(chars[i])) {
                cur = childMap.get(chars[i]);
                childMap = cur.childMap;
            } else {
                return null;
            }
        }

        return cur;
    }
}
