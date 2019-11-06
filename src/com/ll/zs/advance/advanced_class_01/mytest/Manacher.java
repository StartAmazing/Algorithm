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

    private static char[] manacherString(String str){
        char[] chars = str.toCharArray();
        char[] res = new char[str.length() * 2 + 1];
        int index = 0;
        for(int i = 0 ; i != res.length; i++){
            res[i] = (i & 1) == 0 ? '#' : chars[index ++];
        }
        return res;
    }

    public static int maxLcpsLength(String str){
        if(str == null || str.length() == 0){
            return 0;
        }
        char[] charArr = manachering(str);          //计算的字符串数组
        int[] pArr = new int[charArr.length];       //回文半径数组
        int C = -1;     //回文中心
        int R = -1;     //回文半径
        int max = Integer.MIN_VALUE;
//        int maxContainsEnd = -1;
        for(int i = 0 ; i != charArr.length; i ++){
            pArr[i] = R > C ? Math.min(pArr[C * 2 - i], R - i )  : 1;
            while (i + pArr[i]  < charArr.length && i - pArr[i] > -1){
                if(charArr[i + pArr[i]] == charArr[i - pArr[i]]){
                    pArr[i] ++;
                }else{
                    break;
                }
            }
            if(i + pArr[i] > R){
                C = i;
                R = i + pArr[i];
            }
//            if(R ==  charArr.length){
//                maxContainsEnd = pArr[i];
//                break;
//            }
            max = Math.max(max,pArr[i]);
        }
//        char[] res = new char[str.length() - maxContainsEnd + 1];
//        for(int i = 0; i < res.length; i ++){
//            res[res.length - 1 - i] = charArr[i * 2 + 1];
//        }
//        return String.valueOf(res);
        return max - 1;
    }

}
