package com.ll.muke.trie;

import com.ll.muke.set.BSTSet;
import com.ll.muke.set.FileOperation;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args){

        System.out.println("Pride And Prejudice");

        ArrayList<String> words = new ArrayList<>();
        if(FileOperation.readFile("C:\\Users\\Administrator\\Workspaces\\IDEA\\Algorithm\\src\\pride-and-prejudice.txt",words));{
            long startTime = System.nanoTime();

            BSTSet<String> set = new BSTSet<>();
            for(String word : words){
                set.add(word);
            }
            for(String word : words){
                set.contains(word);
            }

            long endTime = System.nanoTime();
            double time = (endTime - startTime) / 1000000000.0;
            System.out.println("Total different words: " + set.getSize());
            System.out.println("BSTSet: "+ time + " s");

            System.out.println("=======================");

            startTime = System.nanoTime();

            Trie trie = new Trie();
            for(String word : words){
                trie.add(word);
            }
            for(String word : words){
                trie.contains(word);
            }

            endTime = System.nanoTime();
            time = (endTime - startTime) / 1000000000.0;
            System.out.println("Total different words: " + set.getSize());
            System.out.println("Trie: "+ time + " s");
        }
    }

}
