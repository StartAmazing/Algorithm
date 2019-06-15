package com.ll.muke.hashtable;

import com.ll.muke.RBTree.AVLTree;
import com.ll.muke.RBTree.BST;
import com.ll.muke.RBTree.FileOperation;
import com.ll.muke.RBTree.RBTree;

import java.util.ArrayList;

public class Main2 {

    public static void main(String[] args) {

        System.out.println("A Tale Of To Cities");

        ArrayList<String> words = new ArrayList<>();
        if(FileOperation.readFile("C:\\Users\\Administrator\\Workspaces\\IDEA\\Algorithm\\src\\pride-and-prejudice.txt", words)) {
            System.out.println("Total words: " + words.size());

            // Collections.sort(words);

            // Test BST
            long startTime = System.nanoTime();

            BST<String, Integer> bst = new BST<>();
            for (String word : words) {
                if (bst.contains(word))
                    bst.set(word, bst.get(word) + 1);
                else
                    bst.add(word, 1);
            }

            for(String word: words)
                bst.contains(word);

            long endTime = System.nanoTime();

            double time = (endTime - startTime) / 1000000000.0;
            System.out.println("BST: " + time + " s");


            // Test AVL
            startTime = System.nanoTime();

            AVLTree<String, Integer> avl = new AVLTree<>();
            for (String word : words) {
                if (avl.contains(word))
                    avl.set(word, avl.get(word) + 1);
                else
                    avl.add(word, 1);
            }

            for(String word: words)
                avl.contains(word);

            endTime = System.nanoTime();

            time = (endTime - startTime) / 1000000000.0;
            System.out.println("AVL: " + time + " s");

            //Test RB
            startTime = System.nanoTime();

            RBTree<String, Integer> rbt = new RBTree<>();
            for(String word :words){
                if(rbt.contains(word)){
                    rbt.set(word, rbt.get(word) + 1);
                }else{
                    rbt.add(word, 1);
                }
            }

            for(String word: words){
                rbt.contains(word);
            }

            endTime = System.nanoTime();

            time = (endTime - startTime) / 1000000000.0;
            System.out.println("RBTree: " + time + " s");

            //Test hashtable
            startTime = System.nanoTime();

            HashTable<String, Integer> ht = new HashTable<>();
            for(String word : words){
                if(ht.contains(word)){
                    ht.set(word,ht.get(word) + 1);
                }else
                    ht.add(word, 1);
            }
            for(String word: words){
                ht.contains(word);
            }

            endTime = System.nanoTime();
            time = (endTime - startTime) / 1000000000.0;
            System.out.println("HashTable: " +time+" s");


        }
        System.out.println();
    }
}
