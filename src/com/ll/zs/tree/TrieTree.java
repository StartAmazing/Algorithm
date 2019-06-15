package com.ll.zs.tree;

public class TrieTree {

    public static class TrieNode{
        //有多少个字符串到达过这个结点，即为多少个字符串的前缀
        public int path;
        //是多少个字符串的终点
        public int end;
        //        public TrieNode<Character, TrieNode> netx;
        //表示要走的路径
        public TrieNode[] nexts;

        public TrieNode(){
            path = 0;
            end = 0;
            //假设所给字符串都是小写字母组成
            nexts = new TrieNode[26];
        }
    }

    public static class Trie{

        private TrieNode root;

        public Trie(){
            root = new TrieNode();
        }
        //加入一个字符串
        public void insert(String word){
            if(word == null)
                return;
            char[] chs = word.toCharArray();
            TrieNode node = root;
            int index = 0;
            for(int i = 0; i < chs.length; i++){
                index = chs[i] - 'a';
                //nexts[]数组在index位置是否有值表示是否有“路”，如index[10] != null说明路径上有字符'k'
                if(node.nexts[index] == null){
                    //建‘路’
                    node.nexts[index] = new TrieNode();
                }
                node = node.nexts[index];
                node.path ++;
            }
            node.end ++;
        }
        //在结构中删除一个word
        //当词频不止一个的时候沿途path--,end--
        //当词频只有一个的时候，将第一个节点的path = 1(--path == 0)及其之后的的节点全部删除
        // 方法就是，将它父节点的node.next[index] == null,置为空，其之前的全部节点的path--
        public void delete(String word){
            if(search(word) != 0){
                char[] chs = word.toCharArray();
                TrieNode node = root;
                int index = 0;
                for(int i = 0; i < chs.length; i++){
                    index = chs[i] - 'a';
                    //这里进行path--操作，要删除结点的父节点和之前的所有节点
                    if(-- node.nexts[index].path == 0){
                        node.nexts[index] = null;
                        return;
                    }
                    node = node.nexts[index];
                }
                //被删除结点之前的一个节点的end--
                node.end --;
            }
        }
        //查询某个字符串在Trie中总共插入了几次
        public int search(String word){
            if(word == null)
                return 0;
            char[] chs = word.toCharArray();
            TrieNode node = root;
            int index = 0;
            for(int i = 0; i < chs.length; i++){
                index = chs[i] - 'a';
                if(node.nexts[index] == null){
                    return 0;
                }
                node = node.nexts[index];
            }
            return node.end;
        }

        //查某个字符串前缀的数量
        public int prefixNumber(String pre){
            if(pre == null)
                return 0;
            char[] chs = pre.toCharArray();
            TrieNode node = root;
            int index = 0;
            for(int i = 0; i < chs.length; i++){
                index = chs[i] - 'a';
                if(node.nexts[index] == null){
                    return 0;
                }
                node = node.nexts[index];
            }
            return node.path;
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        System.out.println(trie.search("liu")); //0
        trie.insert("liu");
        System.out.println(trie.search("liu")); //1
        trie.insert("liu");
        System.out.println(trie.search("liu")); //2
        trie.insert("liu");
        trie.insert("liu");
        trie.delete("liu");
        System.out.println(trie.search("liu")); //3
        trie.delete("liu");
        System.out.println(trie.search("liu")); //2
        trie.insert("liua");
        trie.insert("liuac");
        trie.insert("liuab");
        trie.insert("liuad");
        trie.insert("liua");
        System.out.println(trie.search("liua")); //2
        System.out.println(trie.prefixNumber("liu")); //7
    }

}
