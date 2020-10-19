package com.ll.lintcode.advance.chapter4.sweepline;

import com.ll.zs.nowcoder.tree.Tree;

import java.util.*;

/**
 * 水平面上有 N 座大楼，每座大楼都是矩阵的形状，可以用一个三元组表示 (start, end, height)，分别代表其在x轴上的起点，终点和高度。大楼之间从远处看可能会重叠，求出 N 座大楼的外轮廓线。
 * <p>
 * 外轮廓线的表示方法为若干三元组，每个三元组包含三个数字 (start, end, height)，代表这段轮廓的起始位置，终止位置和高度。
 * <p>
 * <p>
 * <p>
 * 请注意合并同样高度的相邻轮廓，不同的轮廓线在x轴上不能有重叠。
 * <p>
 * 您在真实的面试中是否遇到过这个题？
 * 样例
 * 样例1
 * <p>
 * 输入:
 * [
 * [1, 3, 3],
 * [2, 4, 4],
 * [5, 6, 1]
 * ]
 * 输出:
 * [
 * [1, 2, 3],
 * [2, 4, 4],
 * [5, 6, 1]
 * ]
 * 说明:
 * 建筑物如下图所示，黄色部分表示建筑物
 * 图片
 * <p>
 * 样例2
 * <p>
 * 输入:
 * [
 * [1, 4, 3],
 * [6, 9, 5]
 * ]
 * 输出:
 * [
 * [1, 4, 3],
 * [6, 9, 5]
 * ]
 * <p>
 * 超难级
 */
class BuildingPair {
    public int idx;
    public int isStart;
    public int height;

    public BuildingPair() {

    }

    public BuildingPair(int idx, int isStart, int height) {
        this.idx = idx;
        this.isStart = isStart;
        this.height = height;
    }

}


class BuildingComparator implements Comparator<BuildingPair> {

    @Override
    public int compare(BuildingPair o1, BuildingPair o2) {
        if (o1.idx != o2.idx) {
            return compareInteger(o1.idx, o2.idx);
        }
        if (o1.isStart == 1 && o2.isStart == 1){
            return compareInteger(o2.height, o1.height);
        }

        if (o1.isStart != 0 && o2.isStart != 0) {
            return compareInteger(o1.height, o2.height);
        }

        return o1.isStart == 1 ? -1 : 1;

    }

    private int compareInteger(int a, int b) {
        return a <= b ? -1 : 1;
    }
}


public class TheSkyLineProblem_131 {

    public List<List<Integer>> buildingOutline(int[][] buildings) {
        List<List<Integer>> ans = new ArrayList<>();
        if (null == buildings || buildings.length < 1) {
            return ans;
        }

        List<BuildingPair> buildingPairs = new ArrayList<>();
        for (int[] ele : buildings) {
            buildingPairs.add(new BuildingPair(ele[0], 1, ele[2]));
            buildingPairs.add(new BuildingPair(ele[1], 0, ele[2]));
        }

        Collections.sort(buildingPairs, new BuildingComparator());

        TreeMap<Integer, BuildingPair> treeMap = new TreeMap<>();

        List<Integer> now = null;
        for (BuildingPair ele : buildingPairs) {
            if (ele.isStart == 1) {
                if (treeMap.isEmpty() || ele.height > treeMap.lastKey()) {
                    now = new ArrayList<Integer>(Arrays.asList(ele.idx, ele.height));
                    ans.add(now);
                }
                treeMap.put(ele.height, ele);
            } else {
                treeMap.remove(ele.height);
                if (treeMap.isEmpty() || ele.height > treeMap.lastKey()) {
                    if (treeMap.isEmpty()) {
                        now = new ArrayList<>(Arrays.asList(ele.idx, 0));
                    } else {
                        now = new ArrayList<>(Arrays.asList(ele.idx, treeMap.lastKey()));
                    }
                    ans.add(now);
                }

            }
        }


        return output(ans);
    }

    private List<List<Integer>> output(List<List<Integer>> res) {
        List<List<Integer>> ans = new ArrayList<>();
        if (res.size() > 0) {
            int pre = res.get(0).get(0);
            int height = res.get(0).get(1);
            for (int i = 1; i < res.size(); i++) {
                List<Integer> now = new ArrayList<>();
                int idx = res.get(i).get(0);
                if (height > 0) {
                    now.add(pre);
                    now.add(idx);
                    now.add(height);
                    ans.add(now);
                }

                pre = idx;
                height = res.get(i).get(1);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        TheSkyLineProblem_131 dto = new TheSkyLineProblem_131();
        int[][] data = new int[][]{{4,67,187},{3,80,65},{49,77,117},
                {67,74,9},{6,42,92},{48,67,69},{10,13,58},{47,99,152},{66,99,53},
                {66,71,34},{27,63,2},{35,81,116},{47,49,10},{68,97,175},{20,33,53},
                {24,94,20},{74,77,155},{39,98,144},{52,89,84},{13,65,222},{24,41,75},
                {16,24,142},{40,95,4},{6,56,188},{1,38,219},{19,79,149},{50,61,174},
                {4,25,14},{4,46,225},{12,32,215},{57,76,47},{11,30,179},{88,99,99},
                {2,19,228},{16,57,114},{31,69,58},{12,61,198},{70,88,131},{7,37,42},
                {5,48,211},{2,64,106},{49,73,204},{76,88,26},{58,61,215},{39,51,125},
                {13,38,48},{74,99,145},{4,12,8},{12,33,161},{61,95,190},{16,19,196},
                {3,84,8},{5,36,118},{82,87,40},{8,44,212},{15,70,222},{16,25,176},
                {9,100,74},{38,78,99},{23,77,43},{45,89,229},{7,84,163},{48,72,1},
                {31,88,123},{35,62,190},{21,29,41},{37,97,81},{7,49,78},{83,84,132},
                {33,61,27},{18,45,1},{52,64,4},{58,98,57},{14,22,1},{9,85,200},{50,76,147},
                {54,70,201},{5,55,97},{9,42,125},{31,88,146}};

        List<List<Integer>> lists = dto.buildingOutline(data);
        System.out.println(lists);
    }
}
