package com.ll.lintcode.advance.chapter2.datastructre.trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordSearchII {

    class TrieNode{
        boolean isEnd;
        char ch;
        String str;
        Map<Character, TrieNode> childMap = new HashMap<>();

        public TrieNode(char ch) {
            this.ch = ch;
        }

        public TrieNode() {

        }
    }

    TrieNode root = new TrieNode();

    public void insert(String word) {
        char[] chars = word.toCharArray();
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            if (!cur.childMap.containsKey(chars[i])) {
                cur.childMap.put(chars[i], new TrieNode(chars[i]));
            }
            if (i == word.length() - 1) {
                cur.isEnd = true;
                cur.str = word;
            }
            cur = cur.childMap.get(chars[i]);
        }
    }

    public List<String> wordSearchII(char[][] board, List<String> words) {
        if (words == null || words.size() < 1) {
            return new ArrayList<>();
        }
        
        List<String> res = new ArrayList<>();
        WordSearchII dto = new WordSearchII();
        words.forEach(dto::insert);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                dfs(i, j, dto.root, board, res);
            }
        }
        
        return res;
    }
    
    private void dfs(int i, int j, TrieNode curNode, char[][] board, List<String> res) {
        if (curNode.isEnd && !res.contains(curNode.str)) {
            res.add(curNode.str);
        }

        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == 0) {
            return;
        }

        int[][] position = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        if (curNode.childMap.containsKey(board[i][j])) {
            for (int n = 0; n < 4; n++) {
                int nextX = i + position[n][0];
                int nextY = j + position[n][1];
                char now = board[i][j];
                board[i][j] = 0;
                dfs(nextX, nextY, curNode.childMap.get(now), board, res);
                board[i][j] = now;
            }
        }
    }

    public static void main(String[] args) {
        char[][] chars = new char[][]{{'a'}};
        List<String> data = new ArrayList<>();
        data.add("b");

        WordSearchII dto = new WordSearchII();
        List<String> strings = dto.wordSearchII(chars, data);
        strings.forEach(System.out::println);
    }
}
