package com.ll.muke.AVLTree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {

        System.out.println("Pride and Prejuice");

        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile("C:\\Users\\Administrator\\Workspaces\\IDEA\\Algorithm\\src\\pride-and-prejudice.txt", words)) {


            //Test BST
            long startTime = System.nanoTime();

            BST<String, Integer> bst = new BST<>();
            for(String word : words){
                if(bst.contains(word)) {
                    bst.set(word, bst.get(word) + 1);
                }else{
                    bst.add(word, 1);
                }
            }
            for(String word: words){
                bst.contains(word);
            }

            long endTime = System.nanoTime();

            double time = (endTime - startTime) / 1000000000.0;
            System.out.println("BST used time : " + time + " s ");

            Collections.sort(words);
            //Test AVLTree
            startTime = System.nanoTime();

            AVLTree<String, Integer> avl = new AVLTree<>();
            for(String word : words){
                if(avl.contains(word)){
                    avl.set(word, avl.get(word) + 1);
                }else{
                    avl.add(word, 1);
                }
            }

            for(String word :words){
                avl.contains(word);
            }
            endTime = System.nanoTime();

            time = (endTime - startTime) / 1000000000.0;
            System.out.println("AVLTree used time : " + time + " s ");

        }
    }
}
