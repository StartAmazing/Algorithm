package com.ll.lintcode.advance.chapter2.datastructre.trie;

import java.util.HashMap;
import java.util.Map;

/**
 * 设计一个包含下面两个操作的数据结构：addWord(word), search(word)
 * <p>
 * addWord(word)会在数据结构中添加一个单词。而search(word)则支持普通的单词查询或是只包含.和a-z的简易正则表达式的查询。
 * <p>
 * 一个 . 可以代表一个任何的字母。
 * <p>
 * 样例
 * 样例 1:
 * <p>
 * 输入:
 * addWord("a")
 * search(".")
 * 输出:
 * true
 * 样例 2:
 * <p>
 * 输入:
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad")
 * search("bad")
 * search(".ad")
 * search("b..")
 * 输出:
 * false
 * true
 * true
 * true
 * 注意事项
 * 你可以认为所有的单词都只包含小写字母 a-z。
 */
public class WordDictionary_473 {
    class WordNode {
        public char c;
        public Map<Character, WordNode> children = new HashMap<>();
        public boolean isEnd;

        public WordNode() {

        }

        public WordNode(char c) {
            this.c = c;
        }
    }

    WordNode root;

    public WordDictionary_473() {
        root = new WordNode();
    }

    /*
     * @param word: Adds a word into the data structure.
     * @return: nothing
     */
    public void addWord(String word) {
        WordNode curNode = root;
        Map<Character, WordNode> children = root.children;
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (children.containsKey(chars[i])) {
                curNode = children.get(chars[i]);
            } else {
                WordNode newNode = new WordNode(chars[i]);
                children.put(chars[i], newNode);
                curNode = children.get(chars[i]);
            }

            children = curNode.children;

            if (i == chars.length - 1) {
                curNode.isEnd = true;
            }
        }
    }
    public void addWord2(String word) {
        WordNode cur = root;
        char[] chars = word.toCharArray();
        Map<Character, WordNode> curChildMap = root.children;
        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if(!curChildMap.containsKey(ch)) {
                WordNode newNode = new WordNode(ch);
                curChildMap.put(ch, newNode);
            }
//            curChildMap = curChildMap.get(ch).children;
            if (i == word.length() - 1) {
                curChildMap.get(ch).isEnd = true;
            }
            curChildMap = curChildMap.get(ch).children;
        }
    }

    /*
     * @param word: A word could contain the dot character '.' to represent any one letter.
     * @return: if the word is in the data structure.
     */
    public boolean search(String word) {
        return find(word, 0, root);
    }

    private boolean find(String word, int index, WordNode now) {
        if (index == word.length()) {
            return now.isEnd;
        }

        char c = word.charAt(index);
        if (c == '.') {
            for (WordNode ele : now.children.values()) {
                if (find(word, index + 1, ele)) {
                    return true;
                }
            }
            return false;
        } else if (now.children.containsKey(c)) {
            return find(word, index + 1, now.children.get(c));
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        WordDictionary_473 dto = new WordDictionary_473();
        System.out.println(dto.search("lintcode"));
        System.out.println(dto.search("lint"));
        dto.addWord2("lint");
        System.out.println(dto.search("lint"));
//        boolean searched = dto.search("....e.");
//        System.out.println(searched);
    }
}
