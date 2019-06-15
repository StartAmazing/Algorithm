package com.ll.interest.greed;

import java.util.Stack;

//迪科斯彻的解决单源点的最短路径问题
public class LowestPath {

    public static int N = 100;     //城市的个数可以修改
    public static int INF = 10000000;   //初始化无穷大为INF
//    public static int[][] map = new int[N][N];    //图的带权邻接矩阵
    public static int[] dist = new int[N];    //初始化dist[i] = map[u][i]，如果源点u到i有边相连，初始化p[i] = u，否则p[i] = -1
    public static int[] p = new int[N];
    public static int n;
    public static int m;  //n表示城市的个数，m为城市间路线的条数
    public static boolean[] flag = new boolean[N];    //如果flag[i]等于true,说明顶点i已经加入到集合S,否则结点i属于V-S

    public static void dijkstra(int u,int [][]map){
        for(int i = 0; i < n ;i ++) {  //step1
            dist[i] = map[u][i];   //初始化源点u到其他各个顶点的最短路径长长度
            flag[i] = false;
            if (dist[i] == INF) {
                p[i] = -1;  //源点u到该顶点的路径长度为无穷大，说明顶点i与源点u不相邻
            } else {
                p[i] = u;   //说明顶点i与源点u相邻，设置顶点i的前驱p[i]=u
            }
        }
        dist[u] = 0;    //自身与自身的距离为0
        flag[u] = true; //初始时，集合S中只有一个元素，源点u
        for(int i = 0; i < n; i++){       //step2
            int temp = INF, t = u;
            for(int j = 0; j < n; j++) {    //step3 在集合V-S中寻找距离源点u最近的顶点t
                if (!flag[j] && dist[j] < temp) {
                    t = j;
                    temp = dist[j];
                }
            }
            if(t == u) return;  //找不到t则跳出循环
            flag[t] = true;     //否则，将t加入集合
            for(int j=0; j < n; j++) {      //step4  更新集合V-S 中与t临接的顶点到源点u的距离
                if (!flag[j] && map[t][j] < INF) {
                    if (dist[j] > (dist[t] + map[t][j])) {
                        dist[j] = dist[t] + map[t][j];
                        p[j] = t;
                    }
                }
            }
        }
    }

    public static void findPath(int u){
        int x;
        Stack<Integer> s = new Stack<>();
        for(int i = 0; i < n; i++){
             x = p[i];
             while(x!=-1){
                 s.push(x);//将前驱依次压入栈中
                 x = p[x];
             }
            System.out.print("源点到其他各个顶点的最短路径为： ");
             while(!s.isEmpty()){
                 System.out.print(s.pop() + "->");    //依次取出栈顶元素
             }
            System.out.println(i + "；最短路径为：" + dist[i]);
        }
    }

    public static void main(String[] args) {
        int u,v,w,st;
        n = 5;
        m = 8;

        int[][] map ={{INF,2,5,INF,INF},{INF,INF,2,6,INF},{INF,INF,INF,7,1},{INF,INF,2,INF,4},{INF,INF,INF,INF,INF}};
        st = 0;
        dijkstra(st,map);
        System.out.println("小明所在的位置： ");
        for(int i=0; i < n; i++) {
            System.out.print("小明： " + (st+1) + " - " + "要去的位置: " + (i+1) + " ");
            if (dist[i] == INF)
                System.out.println("sorry,无路可达");
            else {
                System.out.println("最短距离为： " + dist[i]);
            }
        }
        findPath(st);
    }







}
