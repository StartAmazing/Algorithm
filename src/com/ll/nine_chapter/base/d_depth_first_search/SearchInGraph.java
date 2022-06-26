package com.ll.nine_chapter.base.d_depth_first_search;

import java.util.*;

public class SearchInGraph {

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


    /**
     * @link https://www.lintcode.com/problem/121/
     * @param start: a string
     * @param end: a string
     * @param dict: a set of string
     * @return: a list of lists of string
     *          we will sort your return value in output
     *
     *   终点 -> 起点  bfs
     *   起点 -> 终点  dfs
     *
     */
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        List<List<String>> ladders = new ArrayList<>();
        Map<String, List<String>> neighbors = new HashMap<>();
        Map<String, Integer> distince = new HashMap<>();




        return ladders;
    }


    public static void main(String[] args) {

    }
}
