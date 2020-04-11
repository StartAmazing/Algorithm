package com.ll.zs.advance.mytest;

import com.ll.interest.greed.BagQuestion;

/**
 * KMP目的一样的RabinKrap算法
 */
public class RabinKrapKMP {

    public static int BASE = 1000000;

    public static int strStr(String source, String target){
        if(source == null || target == null || target.length() > source.length()){
            return -1;
        }

        int m = target.length();
        if(target.length() == 0){
            return 0;
        }

        //31^(m-1)
        int power = 1;
        for(int i = 0; i < m; i++){
            power = (power * 31) % BASE;
        }

        int targetCode = 0;
        for(int i = 0; i < m; i ++){
            targetCode = (targetCode * 31 + target.charAt(i)) % BASE;
        }

        int hashCode = 0;
        for(int i = 0; i < source.length(); i++){
            //abc + d
            hashCode = (hashCode * 31 + source.charAt(i)) % BASE;
            if( i  < m -1){
                continue;
            }

            //   d
            //abcd - a
            if(i >= m){
                hashCode = (hashCode - source.charAt(i - m) * power) % BASE;
                if(hashCode < 0){
                    hashCode += BASE;
                }
            }

            //double check
            if(hashCode == targetCode){
                if(source.substring(i - m + 1, i + 1).equals(target)){
                    return i - m + 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int i = strStr("abcdef", "de");
        System.out.println(i);

        int i1 = strStr("abcdef", "de");
        System.out.println(i1);
    }


}
