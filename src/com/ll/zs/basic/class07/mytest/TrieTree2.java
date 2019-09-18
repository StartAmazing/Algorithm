package com.ll.zs.basic.class07.mytest;

public class TrieTree2 {
    public static class TrieNode{
        public int pass;
        public int end;
        public TrieNode[] nexts;

        public TrieNode(){
            pass = 0;
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
            if(word == null || "".equals(word)){
                return;
            }
            char[] chars = word.toCharArray();
            TrieNode node = root;
            int index = 0;
            for(int i = 0; i < chars.length; i ++){
                index = chars[i] - 'a';
                if(node.nexts == null){
                    node.nexts[index] = new TrieNode();
                }
                node = node.nexts[index];
                node.pass ++;
            }
            node.end ++;
        }

        public void delete(String word){
            if(search(word) == 0){
                return;
            }
            char[] chars = word.toCharArray();
            int index = 0;
            TrieNode node = root;
            //node.pass -- ?
            for (int i = 0; i < chars.length; i ++){
                index = chars[i] - 'a';
                if(--node.nexts[index].pass == 0){
                    node.nexts[index] = null;
                    return;
                }
                node = node.nexts[index];
            }
            node.end --;
        }

        //查看前缀树中一共插入了几次该单词
        public int search(String word){
             if(word == null || "".equals(word)){
                 return 0;
             }
             char[] chars = word.toCharArray();
             int index = 0;
             TrieNode node = root;
             for(int i = 0; i < chars.length; i++){
                 index = chars[i] - 'a';
                 if(node.nexts[index] == null){
                     return 0;
                 }
                 node = node.nexts[index];
             }
             return node.end;
        }

        //找到前缀树中有多少个单词是以某个前缀开头的
        public int prefix(String word){
            if(word == null || "".equals(word)){
                return 0;
            }
            char[] chars = word.toCharArray();
            int index = 0;
            TrieNode node = root;
            for(int i = 0 ; i < chars.length; i++){
                index = chars[i] - 'a';
                if(node.nexts[index] == null){
                    return 0;
                }
                node = node.nexts[index];
            }
            return node.pass;
        }
    }
}
