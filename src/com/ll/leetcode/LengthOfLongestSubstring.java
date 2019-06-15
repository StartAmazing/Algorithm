package com.ll.leetcode;

import java.util.HashMap;

public class LengthOfLongestSubstring {
    public int solution(String s){
        HashMap<Character,Integer> map = new HashMap<>();
        int len = s.length();
        int i,j,ans=0;
        for(i = 0, j = 0; j < len; j++){
            if(map.containsKey(s.charAt(j))){
                i = Math.max(map.get(s.charAt(j))+1, i);
            }
            map.put(s.charAt(j), j);
            ans = Math.max(j - i + 1,ans);
        }
        return ans;
    }

}
