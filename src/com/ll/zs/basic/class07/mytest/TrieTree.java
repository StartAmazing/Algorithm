package com.ll.zs.basic.class07.mytest;

import java.util.HashMap;

public class TrieTree {
    public static class TrieNode{
        //建立这个结构的时候，有多少个字符串到达过这个节点
        public int path;
        //有多少字符串以这个节点 结尾
        public int end;
        //路
//        public HashMap<Character,TrieNode> road;
        public TrieNode[] nexts;

        public TrieNode(){
            path = 0;
            end = 0;
            nexts = new TrieNode[26];
        }
    }

    public static class Trie{
        private TrieNode root;

        public Trie(){
            root = new TrieNode();
        }

        public void insert(String word){
            if (word == null || "".equals(word)){
                return;
            }
            char[] chars = word.toCharArray();
            TrieNode node = root;
            int index = 0;
            for(int i = 0; i < chars.length; i++){
                index = chars[i] - 'a';
                if(node.nexts[index] == null){
                    node.nexts[index] = new TrieNode();
                }
                node = node.nexts[index];
                node.path ++;
            }
            node.end ++;
        }

        //返回这个字符串被插入过几次
        public int search(String word) {
            if(word == null){
                return 0;
            }
            TrieNode node = root;
            char[] chars = word.toCharArray();
            for(int i = 0; i < chars.length; i++){
                int index = chars[i] - 'a';
                if(node.nexts[index] == null){
                    return 0;
                }
                node = node.nexts[index];
            }
            return node.end;
        }

        //删除某个字符串
        public void delete(String word){
            if(search(word) != 0){
                char[] chars = word.toCharArray();
                TrieNode node = root;
                int index = 0;
                for(int i = 0; i < chars.length;i++){
                    index = chars[i] - 'a';
                    if(--node.nexts[index].path == 0){
                        node.nexts[index] = null;
                        return;
                    }
                    node = node.nexts[index];
                }
                node.end --;
            }
        }

        //查找某个字符串的前缀数量，即这个字符串是多少个字符串的前缀
        public int prefixNumber(String pre){
            if(pre == null){
                return 0;
            }
            char[] chars = pre.toCharArray();
            TrieNode node = root;
            int index = 0;
            for (int i = 0; i < chars.length; i++){
                index = chars[i] - 'a';
                if(node.nexts[index] == null){
                    return 0;
                }
                node = node.nexts[index];
            }
            return node.path;
        }
    }
}
