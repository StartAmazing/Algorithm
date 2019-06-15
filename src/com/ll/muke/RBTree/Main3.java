package com.ll.muke.RBTree;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.Random;

public class Main3 {

    public static void main(String[] args) {

        int n = 3000000;

        ArrayList<Integer> testData = new ArrayList<>();
        for(int i = 0; i < n; i++){
            testData.add(i);
        }
//        //Test BST
//        long startTime = System.nanoTime();
//
//        BST<Integer, Integer> bst = new BST<>();
//        for(Integer x : testData){
//            bst.add(x, null);
//        }
//        long endTime = System.nanoTime();
//
//        double time = (endTime - startTime) / 1000000000.0;
//        System.out.println("BST add time: " + time + " s");

        //test AVL
        long startTime = System.nanoTime();

        AVLTree<Integer,Integer> avl = new AVLTree<>();
        for(Integer x : testData){
            avl.add(x, null);
        }
        long endTime = System.nanoTime();

        double time = (endTime - startTime) / 1000000000.0;
        System.out.println("AVL add time: " + time + " s");

        //test RB
        startTime = System.nanoTime();

        RBTree<Integer, Integer> rbt = new RBTree<>();
        for(Integer x :testData){
            rbt.add(x, null);
        }

        endTime = System.nanoTime();

        time = (endTime - startTime) / 1000000000.0;
        System.out.println("RBTree add: " + time + " s");

    }

}
