package com.ll.zs.basic.class07.mytest;

import java.util.Comparator;

public class LowestLexicography {

    public static class MyComparator implements Comparator<String>{

        @Override
        public int compare(String o1, String o2) {
            return (o1 + o2).compareTo(o2 + o1);
        }
    }




}
