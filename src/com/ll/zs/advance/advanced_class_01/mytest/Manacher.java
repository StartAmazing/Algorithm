package com.ll.zs.advance.advanced_class_01.mytest;

/**
 * 子串的问题，一个字符串中找到最长回文子串
 */
public class Manacher {

    public static char[] manachering(String str){
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < str.length() ;i ++){
            sb.append("#");
            sb.append(str.charAt(i));
        }
        sb.append("#");
        return sb.toString().toCharArray();
    }

    public static int manacher(String str){
        if(str == null || str.length() < 1){
            return 0;
        }
        char[] chars = manachering(str);
        int[] radius = new int[chars.length];
        int R = -1;
        int c = -1;
        int max = Integer.MAX_VALUE;
        for(int i = 0; i < radius.length; i++){
            radius[i] = R > i ? Math.min(radius[2 * c - i], R - i + 1): 1;
            while (i + radius[i] < chars.length && i - radius[i] > 1){
                if(chars[i - radius[i]] == chars[i + radius[i]]){
                    radius[i] ++;
                }else {
                    break;
                }
            }
            if(i + radius[i] > R){
                R = i + radius[i] - 1;
                c = i;
            }
            max = Math.max(max,radius[i]);
        }

        return max - 1;
    }
}
