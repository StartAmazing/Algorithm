package com.ll.nine_chapter.base.c_breadth_first_search;

import com.ll.utils.DirectedGraphNode;
import com.ll.utils.NotPassed;
import com.ll.utils.UndirectedGraphNode;

import java.util.*;

/**
 * 图上的宽度优先搜索
 */
public class GraphSearch {

    /**
     * @link https://www.lintcode.com/problem/178/
     * @param n: An integer
     * @param edges: a list of undirected edges
     * @return: true if it's a valid tree, or false
     * @see 1. n points and n-1 edges;
     *      2. n ponits connected.
     *
     */
    public static boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) {
            return false;
        }

        if (n == 1) {
            return true;
        }

        Map<Integer, List<Integer>> graphMap = initGraphMap(edges);
        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> visitedSet = new HashSet<>();
        queue.add(edges[0][0]); // start point
        visitedSet.add(edges[0][0]);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer curVal = queue.poll();
                List<Integer> neighbors = graphMap.get(curVal);
                neighbors.forEach(ele -> {
                    if (visitedSet.contains(ele)) {
                        return;
                    }
                    queue.add(ele);
                    visitedSet.add(ele);
                });
            }
        }

        return visitedSet.size() == n;
    }

    private static Map<Integer, List<Integer>> initGraphMap(int[][] edges) {
        Map<Integer, List<Integer>> resMap = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            resMap.putIfAbsent(edges[i][0], new ArrayList<>());
            resMap.putIfAbsent(edges[i][1], new ArrayList<>());
            resMap.get(edges[i][0]).add(edges[i][1]);
            resMap.get(edges[i][1]).add(edges[i][0]);
        }

        return resMap;
    }

    /**
     * @link https://www.lintcode.com/problem/137/
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
    public static UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        // step1  node --find--> all nodes
        List<UndirectedGraphNode> allNodes = getNodes(node);

        // step2  node --copy--> node'
        Map<UndirectedGraphNode, UndirectedGraphNode> oldNode2NewNodeMap = new HashMap<>();
        for (UndirectedGraphNode oldNode : allNodes) {
            oldNode2NewNodeMap.put(oldNode, new UndirectedGraphNode(oldNode.label));
        }

        // step 3  node1-node2   --connect-->  node1'-node2'
        for (UndirectedGraphNode oldNode : allNodes) {
            for (UndirectedGraphNode neighbor : oldNode.neighbors) {
                oldNode2NewNodeMap.get(oldNode).neighbors.add(oldNode2NewNodeMap.get(neighbor));
            }
        }

        // step 4 return node'
        return oldNode2NewNodeMap.get(node);
    }

    private static List<UndirectedGraphNode> getNodes(UndirectedGraphNode node) {
        List<UndirectedGraphNode> res = new ArrayList<>();
        if (node == null) {
            return res;
        }
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.add(node);
        HashSet<Integer> visited = new HashSet<>();
        visited.add(node.label);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                UndirectedGraphNode curNode = queue.poll();
                res.add(curNode);
                for (UndirectedGraphNode neighbor : curNode.neighbors) {
                    if (visited.contains(neighbor.label)) {
                        continue;
                    }
                    visited.add(neighbor.label);
                    queue.add(neighbor);
                }
            }
        }

        return res;
    }

    /*
     * @link https://www.lintcode.com/problem/618/
     * @param graph: a list of Undirected graph node
     * @param values: a hash mapping, <UndirectedGraphNode, (int)value>
     * @param node: an Undirected graph node
     * @param target: An integer
     * @return: a node
     */
    public static UndirectedGraphNode searchNode(ArrayList<UndirectedGraphNode> graph,
                                          Map<UndirectedGraphNode, Integer> values,
                                          UndirectedGraphNode node,
                                          int target) {
        if (node == null || values.get(node) == target) {
            return node;
        }

        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.add(node);
        Set<Integer> visited = new HashSet<>();
        visited.add(node.label);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                UndirectedGraphNode curNode = queue.poll();
                for (UndirectedGraphNode neighbor : curNode.neighbors) {
                    if (values.get(neighbor) == target) {
                        return neighbor;
                    }
                    if (visited.contains(neighbor.label)) {
                        continue;
                    }
                    visited.add(neighbor.label);
                    queue.add(neighbor);
                }
            }
        }

        return null;
    }


    /**
     * @link https://www.lintcode.com/problem/127/
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */
    public static ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        ArrayList<DirectedGraphNode> res = new ArrayList<>();
        if (graph == null) {
            return res;
        }

        // step1. count indegree
        Map<DirectedGraphNode, Integer> indegreeMap = getIndegreeMap(graph);

        // step2. topological sorting - bfs
        List<DirectedGraphNode> startNodes  = getStartNodes(indegreeMap);

        // step3. bfs
        res = topologicSortBfs(indegreeMap, startNodes);

        if (res.size() == graph.size()) {
            return res;
        }

        return null;
    }

    private static Map<DirectedGraphNode, Integer> getIndegreeMap(ArrayList<DirectedGraphNode> graph) {
        Map<DirectedGraphNode, Integer> res = new HashMap<>();
        if (graph == null) {
            return res;
        }

        for (DirectedGraphNode aNode : graph) {
            res.putIfAbsent(aNode, 0);
            for (DirectedGraphNode neighbor : aNode.neighbors) {
                res.putIfAbsent(neighbor, 0);
                res.put(neighbor, res.get(neighbor) + 1);
            }
        }

        return res;
    }

    private static List<DirectedGraphNode> getStartNodes(Map<DirectedGraphNode, Integer> indegreeMap) {
        List<DirectedGraphNode> res = new ArrayList<>();
        if (indegreeMap == null || indegreeMap.size() == 0) {
            return res;
        }

        for (DirectedGraphNode aNode : indegreeMap.keySet()) {
            if (indegreeMap.get(aNode) == 0) {
                res.add(aNode);
            }
        }

        return res;
    }

    private static ArrayList<DirectedGraphNode> topologicSortBfs(Map<DirectedGraphNode, Integer> indegreeMap, List<DirectedGraphNode> startNodes) {
        ArrayList<DirectedGraphNode> res = new ArrayList<>(startNodes);
        Queue<DirectedGraphNode> queue = new LinkedList<>(startNodes);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                DirectedGraphNode cueNode = queue.poll();
                for (DirectedGraphNode neighbor : cueNode.neighbors) {
                    indegreeMap.put(neighbor, indegreeMap.get(neighbor) - 1);
                    if (indegreeMap.get(neighbor) == 0) {
                        queue.add(neighbor);
                        res.add(neighbor);
                    }
                }
            }
        }

        return res;
    }

    /**
     * @link https://www.lintcode.com/problem/615/
     * @param numCourses: a total of n courses
     * @param prerequisites: a list of prerequisite pairs
     * @return: true if can finish all courses or false
     */
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0 || prerequisites == null || prerequisites.length == 0) {
            return true;
        }

        //step1. get all indegree
        Map<Integer, List<Integer>> indegreeMap = getIndegreeCaurseMap(prerequisites);

        //step2. from 0 indegree start bfs
        List<Integer> startNodes = getStartCaurseNodes(indegreeMap, numCourses);

        //step3. get neighborMap
        Map<Integer, List<Integer>> neighborMap = getNeighborMap(prerequisites, numCourses);

        //step4. bfs
        return courseBfs(startNodes, indegreeMap, neighborMap) == numCourses;
    }

    private static Map<Integer, List<Integer>> getIndegreeCaurseMap(int[][] graph) {
        Map<Integer, List<Integer>> resMap = new HashMap<>();
        if (graph == null || graph.length == 0) {
            return resMap;
        }

        for (int[] ints : graph) {
            resMap.putIfAbsent(ints[1], new ArrayList<>());
            resMap.putIfAbsent(ints[0], new ArrayList<>());
            resMap.get(ints[1]).add(ints[0]);
        }

        return resMap;
    }

    private static List<Integer> getStartCaurseNodes(Map<Integer, List<Integer>> indegreeMap, int numCause) {
        List<Integer> resList = new ArrayList<>();
        if (indegreeMap == null || indegreeMap.size() == 0) {
            return resList;
        }

        for (int i = 0; i < numCause; i++) {
            if (indegreeMap.get(i) == null || indegreeMap.get(i).size() == 0) {
                resList.add(i);
            }
        }

        return resList;
    }

    private static Map<Integer, List<Integer>> getNeighborMap(int[][] graph, int count) {
        Map<Integer, List<Integer>> neighborMap = new HashMap<>();

        for (int i = 0; i < count; i++) {
            neighborMap.putIfAbsent(i, new ArrayList<>());
        }
        for (int[] ints : graph) {
            neighborMap.putIfAbsent(ints[0], new ArrayList<>());
            neighborMap.putIfAbsent(ints[1], new ArrayList<>());
            neighborMap.get(ints[0]).add(ints[1]);
        }
        return neighborMap;
    }

    private static Integer courseBfs(List<Integer> startNodes, Map<Integer, List<Integer>> indegreeMap, Map<Integer, List<Integer>> neightborMap) {
        Queue<Integer> queue = new LinkedList<>(startNodes);
        Integer visitCount = startNodes.size();
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer poll = queue.poll();
                for (Integer neighbor : neightborMap.get(poll)) {
                    indegreeMap.get(neighbor).remove(poll);
                    if (indegreeMap.get(neighbor).size() == 0) {
                        queue.add(neighbor);
                        visitCount++;
                    }
                }
            }
        }

        return visitCount;
    }

    /**
     * @link https://www.lintcode.com/problem/616
     * @param numCourses: a total of n courses
     * @param prerequisites: a list of prerequisite pairs
     * @return: the course order
     */
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        // step1. find indegree of all nodes
        Map<Integer, List<Integer>> indegreeMap = getIndegreeCaurseMap2(numCourses, prerequisites);

        // step2, find startNodes
        List<Integer> startNodes = getStartCaurseNodes2(indegreeMap);

        // step3, get neighbor relation
        Map<Integer, List<Integer>> neighborRelationMap = getNeighborMap2(numCourses, prerequisites);

        // step4 bfs
        List<Integer> order = courseBfs2(startNodes, indegreeMap, neighborRelationMap);

        if (order.size() != numCourses) {
            return new int[]{};
        }

        for (int i = 0; i < numCourses; i++) {
            res[i] = order.get(i);
        }

        return res;
    }

    private static Map<Integer, List<Integer>> getIndegreeCaurseMap2(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> resMap = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            resMap.putIfAbsent(i, new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            resMap.get(prerequisite[0]).add(prerequisite[1]);
        }

        return resMap;
    }

    private static List<Integer> getStartCaurseNodes2(Map<Integer, List<Integer>> indegreeMap) {
        List<Integer> resList = new ArrayList<>();
        for (Integer integer : indegreeMap.keySet()) {
            if (indegreeMap.get(integer).size() == 0) {
                resList.add(integer);
            }
        }
        return resList;
    }

    private static Map<Integer, List<Integer>> getNeighborMap2(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> resMap = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            resMap.putIfAbsent(i, new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            resMap.get(prerequisite[1]).add(prerequisite[0]);
        }

        return resMap;
    }


    private static List<Integer> courseBfs2(List<Integer> startNodes, Map<Integer, List<Integer>> indegreeMap, Map<Integer, List<Integer>> neighborRelationMap) {
        List<Integer> resList = new ArrayList<>(startNodes);
        Queue<Integer> queue = new LinkedList<>(startNodes);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer curCourse = queue.poll();
                for (Integer neighbor : neighborRelationMap.get(curCourse)) {
                    indegreeMap.get(neighbor).remove(curCourse);
                    if (indegreeMap.get(neighbor).size() != 0) {
                        continue;
                    }
                    queue.add(neighbor);
                    resList.add(neighbor);
                }
            }
        }
        return resList;
    }

    /**
     * @link https://www.lintcode.com/problem/605/
     * @param org: a permutation of the integers from 1 to n
     * @param seqs: a list of sequences
     * @return: true if it can be reconstructed only one or false
     */
    @NotPassed
    public boolean sequenceReconstruction(int[] org, int[][] seqs) {
//        if ((org == null || org.length == 0) && (seqs == null || seqs.length == 0)) {
//            return true;
//        }
//        if ((org != null && org.length != 0) && (seqs == null || seqs.length == 0)) {
//            return false;
//        }

        // step1. get indegree map
        Map<Integer, Set<Integer>> indegreeMap = getIndegreeSeqMap(org, seqs);

        // step2. get start nodes
        Set<Integer> startNodes = getStartSeqNodes(indegreeMap);

        if (org.length != 0 && startNodes.size() != 1) {
            return false;
        }

        // step3. get neighbor map
        Map<Integer, Set<Integer>> neighborMap = getSeqNeighborMap(org, seqs);

        // step4. bfs
        return bfs(org, startNodes, indegreeMap, neighborMap);
    }

    private Map<Integer, Set<Integer>> getIndegreeSeqMap(int[] org, int[][] seqs) {
        Map<Integer, Set<Integer>> resMap = new HashMap<>();
//        for (int i = 0; i < org.length; i++) {
//            resMap.putIfAbsent(org[i], new HashSet<>());
//        }

        for (int[] seq : seqs) {
            for (int i = 0; i < seq.length; i++) {
                if (i ==  0) {
                    resMap.putIfAbsent(seq[0], new HashSet<>());
                } else {
                    resMap.putIfAbsent(seq[i], new HashSet<>());
                    resMap.get(seq[i]).add(seq[i - 1]);
                }
            }
        }

        return resMap;
    }

    private Set<Integer> getStartSeqNodes( Map<Integer, Set<Integer>> indegreeMap) {
        Set<Integer> resSet = new HashSet<>();
        for (Integer integer : indegreeMap.keySet()) {
            if (indegreeMap.get(integer).size() == 0) {
                resSet.add(integer);
            }
        }
        return resSet;
    }

    private Map<Integer, Set<Integer>> getSeqNeighborMap(int[] org, int[][] seqs) {
        Map<Integer, Set<Integer>> resMap = new HashMap<>();
//        for (int i = 0; i < org.length; i++) {
//            resMap.putIfAbsent(org[i], new HashSet<>());
//        }

        for (int[] seq : seqs) {
            for (int i = 0; i < seq.length; i++) {
                if (i ==  seq.length - 1) {
                    resMap.putIfAbsent(seq[seq.length - 1], new HashSet<>());
                } else {
                    resMap.putIfAbsent(seq[i], new HashSet<>());
                    resMap.get(seq[i]).add(seq[i + 1]);
                }
            }
        }

        return resMap;

    }

    private boolean bfs(int[] org, Set<Integer> startNodes, Map<Integer, Set<Integer>> indegreeMap, Map<Integer, Set<Integer>> neighborMap) {
        Queue<Integer> queue = new LinkedList<>(startNodes);
        int idx = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            if (size != 1) {
                return false;
            }
            for (int i = 0; i < size; i++) {
                Integer curNode = queue.poll();
                if (idx > org.length - 1 || org[idx] != curNode) {
                    return false;
                }
                idx++;
                for (Integer neighbor : neighborMap.get(curNode)) {
                    indegreeMap.get(neighbor).remove(curNode);
                    if (indegreeMap.get(neighbor).size() != 0) {
                        continue;
                    }
                    queue.add(neighbor);
                }
            }

        }

        return idx == org.length;
    }

    /**
     * @link https://www.lintcode.com/problem/431/
     * @param nodes: a array of Undirected graph node
     * @return: a connected set of a Undirected graph
     */
    public List<List<Integer>> connectedSet(List<UndirectedGraphNode> nodes) {
        List<List<Integer>> res = new ArrayList<>();
        if (nodes == null || nodes.size() == 0) {
            return res;
        }

        Set<Integer> visited = new HashSet<>();
        for (UndirectedGraphNode node : nodes) {
            if (!visited.contains(node.label)) {
                List<Integer> subRes = bfsConnect(node, visited);
                res.add(subRes);
            }
        }

        return res;
    }

    private List<Integer> bfsConnect(UndirectedGraphNode startNode, Set<Integer> visited) {
        List<Integer> res = new ArrayList<>();
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        visited.add(startNode.label);
        queue.add(startNode);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                UndirectedGraphNode curNode = queue.poll();
                res.add(curNode.label);
                for (UndirectedGraphNode neighbor : curNode.neighbors) {
                    if (!visited.contains(neighbor.label)) {
                        queue.add(neighbor);
                    }
                    visited.add(neighbor.label);
                }
            }
        }

        Collections.sort(res);
        return res;
    }


    /**
     * @link https://www.lintcode.com/problem/120/
     * @param start: a string
     * @param end: a string
     * @param dict: a set of string
     * @return: An integer
     */
    public static int ladderLength(String start, String end, Set<String> dict) {
        int step = 2;

        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        dict.add(start);
        dict.add(end);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                String curWord = queue.poll();
                for (String s : getNext(curWord, dict)) {
                    if (s.equals(end)) {
                        return step;
                    }
                    queue.add(s);
                    dict.remove(s);
                }
            }
            step++;
        }

        return 0;
    }

    private static ArrayList<String> getNext(String current, Set<String> dict) {
        ArrayList<String> rel = new ArrayList<String>();

        for (char c = 'a'; c <= 'z'; c++) {
            for (int i = 0; i < current.length(); i++) {
                char[] chars = current.toCharArray(); //26个字母只换一个
                chars[i] = c;
                String temp = new String(chars);//生成新的String

                if (dict.contains(temp)) {
                    rel.add(temp);
                }
            }
        }
        return rel;
    }


    private static boolean oneCharDiff(String start, String end) {
        char[] chars1 = start.toCharArray();
        char[] chars2 = end.toCharArray();
        int size = chars1.length;
        boolean chance = true;
        for (int i = 0; i < size; i++) {
            if (chars1[i] != chars2[i]) {
                if (chance) {
                    chance = false;
                } else {
                    return false;
                }
            }
        }

        return !chance;
    }

    public static void main(String[] args) {
//        int n = 1;
//        int[][] data = new int[][]{{}};
//        System.out.println(validTree(n, data));
//
//        UndirectedGraphNode node1 = new UndirectedGraphNode(1);
//        UndirectedGraphNode node2 = new UndirectedGraphNode(2);
//        UndirectedGraphNode node4 = new UndirectedGraphNode(4);
//        node1.neighbors.add(node2);
//        node1.neighbors.add(node4);
//        node2.neighbors.add(node1);
//        node2.neighbors.add(node4);
//        node4.neighbors.add(node1);
//        node4.neighbors.add(node2);
//        UndirectedGraphNode undirectedGraphNode = cloneGraph(node1);
//        System.out.println(undirectedGraphNode);

//
//        DirectedGraphNode directNode0 = new DirectedGraphNode(0);
//        DirectedGraphNode directNode1 = new DirectedGraphNode(1);
//        DirectedGraphNode directNode2 = new DirectedGraphNode(2);
//        DirectedGraphNode directNode3 = new DirectedGraphNode(3);
//        DirectedGraphNode directNode4 = new DirectedGraphNode(4);
//        DirectedGraphNode directNode5 = new DirectedGraphNode(5);
//
//        directNode0.neighbors.add(directNode1);
//        directNode0.neighbors.add(directNode2);
//        directNode0.neighbors.add(directNode3);
//        directNode0.neighbors.add(directNode4);
//
//        directNode1.neighbors.add(directNode3);
//        directNode1.neighbors.add(directNode4);
//
//        directNode2.neighbors.add(directNode4);
//        directNode2.neighbors.add(directNode1);
//
//        directNode3.neighbors.add(directNode4);
//
//        ArrayList<DirectedGraphNode> directedGraphNodes = new ArrayList<>();
//        directedGraphNodes.add(directNode0);
//        directedGraphNodes.add(directNode1);
//        directedGraphNodes.add(directNode2);
//        directedGraphNodes.add(directNode3);
//        directedGraphNodes.add(directNode4);
//        directedGraphNodes.add(directNode5);
//        ArrayList<DirectedGraphNode> resNodes = topSort(directedGraphNodes);
//        System.out.println(resNodes);

//        int courseNum = 2;
//        int[][] courseGraph = new int[][]{{1, 0}};
//        System.out.println(Arrays.toString(findOrder(courseNum, courseGraph)));

//        GraphSearch dto = new GraphSearch();
//        int[] org = new int[]{};
//        int[][] seqs = new int[][]{{}};
//        System.out.println(dto.sequenceReconstruction(org, seqs));
        String start = "hit";
        String end = "cog";
        Set<String> set = new HashSet<>();
        set.add("hot");
        set.add("dot");
        set.add("dog");
        set.add("lot");
        set.add("log");

        System.out.println(ladderLength(start, end, set));
    }
}