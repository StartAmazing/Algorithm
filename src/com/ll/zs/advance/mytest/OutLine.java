package com.ll.zs.advance.mytest;

import com.ll.zs.tree.Tree;

import java.util.*;

/**
 * 给定一个N行3列的二维数组，每一行表示有一座大楼，一共有N座大楼，
 * 所有大楼的地步都坐落在X轴上，每一行的三个值代表每座大楼的从(a,0)
 * 点开始，到(b,0)点结束，高度为c，输入的数据可以保证a<b,b,c均为正数，
 * 大楼间可以有重合，请输出整体的轮廓线
 *
 *
 * 例子：给定一个二维数组[[1,3,3], [2,4,4], [5,6,1]]
 * 输出轮廓线为[[1,2,3],[2,4,4],[5,6,1]]
 *
 */
public class OutLine {

    //上还是下，位置，高度
    public static class Node{
        public boolean isUp;
        public int posi;
        public int h;

        public Node(boolean bORe, int position,int height){
            this.isUp = bORe;
            this.posi = position;
            this.h = height;
        }

    }

    public static class NodeComparator implements Comparator<Node>{

        @Override
        public int compare(Node o1, Node o2) {
            if(o1.posi != o2.posi){
                return o1.posi - o2.posi;       //按照位置的从小到大排
            }
            if(o1.isUp != o2.isUp){         //如果是两栋大楼的重合处，上的高度排在前面，下的高度排在后面
                return o1.isUp ? -1 : 1;
            }
            return  0;
        }
    }

    public static List<List<Integer>> buildingOutline(int[][] buildings){
         Node[] nodes = new Node[buildings.length * 2];
         for(int i = 0; i < buildings.length; i++){
             nodes[i * 2] = new Node(true,buildings[i][0],buildings[i][3]);
             nodes[i * 2 + 1] = new Node(false,buildings[i][1],buildings[i][3]);
         }
        Arrays.sort(nodes,new NodeComparator());        //不管是上还是下，严格按照位置排序
        TreeMap<Integer, Integer> htMap = new TreeMap<>();      //k是某个高度，v是高度出现的次数
        TreeMap<Integer, Integer> pmMap = new TreeMap<>();

        for(int i = 0 ; i < nodes.length; i++){
            if(nodes[i].isUp){
                if(!htMap.containsKey(nodes[i].h)){     //高度第一次出现
                    htMap.put(nodes[i].h,1);
                }else{      //高度不是第一次出现。之前出现次数加一
                    htMap.put(nodes[i].h,htMap.get(nodes[i].h) + 1);
                }
            }else{
                if(htMap.containsKey(nodes[i].h)){      //之前出现过这个高度，减一
                    if(htMap.get(nodes[i].h) == 1){
                        htMap.remove(nodes[i].h);
                    }else{
                        htMap.put(nodes[i].h, htMap.get(nodes[i].h) - 1);
                    }
                }
            }
            //收集每一个位置的最大高度
            if(htMap.isEmpty()){
                pmMap.put(nodes[i].posi, 0);
            }else{
                pmMap.put(nodes[i].posi, htMap.lastKey());
            }
        }
        //利用pmMap生成轮廓线
        List<List<Integer>> res = new ArrayList<>();
        int start = 0;
        int height = 0;
        for(Map.Entry<Integer, Integer> entry : pmMap.entrySet()){
            int curPosition = entry.getKey();
            int curMaxHeight = entry.getValue();
            if(height != curMaxHeight){
                if(height != 0){
                    List<Integer> newRecord = new ArrayList<>();
                    newRecord.add(start);
                    newRecord.add(curPosition);
                    newRecord.add(height);
                    res.add(newRecord);
                }
                start = curPosition;
                height = curMaxHeight;
            }
        }
        return res;
    }

}
