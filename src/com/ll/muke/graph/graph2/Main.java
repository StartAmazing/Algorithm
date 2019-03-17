package com.ll.muke.graph.graph2;

import java.util.Vector;

public class Main {

    public static void main(String[] args) {

        int N = 20;
        int M = 100;

        System.out.println("============SparseGraph=================");
        //Sparse Graph
        SparseGraph g1 = new SparseGraph(N, false);

        for(int i = 0; i < M; i++){
            int a = ( int ) (Math.random()*N);
            int b = ( int ) (Math.random()*N);
            g1.addEdge( a , b );
        }

        //O（E）
        for(int v = 0; v < N ; v ++){
            System.out.print(v + " : ");
            Vector<Integer> adj = (Vector<Integer>) g1.adj(v);
            for(int i= 0 ; i< adj.size() ;i ++){
                System.out.print(  adj.elementAt(i)+ " ");
            }
            System.out.println();
        }

        System.out.println("============DenseGraph=================");
        //DenseGraph
        DenseGraph g2 = new DenseGraph(N, false);

        for(int i = 0; i < M; i++){
            int a = ( int ) (Math.random()*N);
            int b = ( int ) (Math.random()*N);
            g2.addEdge( a , b );
        }

        for(int i = 0; i < N; i ++){
            System.out.print(i + ": ");
            Vector<Integer> adj = (Vector<Integer>) g2.adj(i);
            for(int j = 0 ; j < adj.size(); j++){
                System.out.print( adj.elementAt(j) + " ");
            }
            System.out.println();
        }


    }
}

