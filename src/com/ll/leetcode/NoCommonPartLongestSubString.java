package com.ll.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/*
    给定一个字符串，找出不含有重复字符的最长字符串的最长子串的长度,是子串而不是子序列！
 */
public class NoCommonPartLongestSubString {

    public static  void main(String[] args){
        String s = "pwwkew";
        System.out.println(slidWindow(s));
        System.out.println(optimizedSlidWindow(s));
    }


    //solution1:滑动窗口 使用一个HashSet<Character>()集合
    public static int slidWindow(String s){
        Set<Character> set = new HashSet<>();
        int len=s.length();
        int i=0,j=0,ans=0;
        while(i<len && j<len){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                ans=Math.max(ans,j-i+1);
                j++;
            }else{
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }
    //solution2: 用一个HashMap<Character,Integer>()集合
    public static int optimizedSlidWindow(String s){
        HashMap<Character,Integer> map = new HashMap<>();
        int len = s.length();
        int i=0,j=0,ans=0;
        for(;j<len;j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }

            map.put(s.charAt(j), j);
            ans = Math.max(j - i ,ans);
        }
        return ans;
    }

}
