package com.ll;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符 "go" 时，第一个只出现一次的字符是 "g" 。
 * 当从该字符流中读出前六个字符 “google" 时，第一个只出现一次的字符是"l"。
 *
 *
 *   数据范围：字符串长度满足 1 \le n \le 1000 \ 1≤n≤1000  ，字符串中出现的字符一定在 ASCII 码内。
 *  进阶：空间复杂度 O(n)\ O(n)  ，时间复杂度 O(n) \ O(n)
 *
 *   后台会用以下方式调用 Insert 和 FirstAppearingOnce 函数
 *
 *
 *    string caseout = "";
 *
 *    1.读入测试用例字符串casein
 *
 *    2.如果对应语言有Init()函数的话，执行Init() 函数
 *
 *    3.循环遍历字符串里的每一个字符ch {
 *
 *    Insert(ch);
 *
 *    caseout += FirstAppearingOnce()
 *
 *    }
 *
 *    2. 输出caseout，进行比较。
 *
 * 输出描述
 * 如果当前字符流没有存在出现一次的字符，返回#字符。
 */

public class Test{

    private StringBuffer sequence = new StringBuffer();
    private Map<Character, Integer> chMap = new HashMap<>();
    private int num = 0;
    private Map<Character, Integer> orderMap= new HashMap<>();

    //Insert one char from stringstream
    public void Insert(char ch) {
        sequence.append(ch);
        num++;
        chMap.putIfAbsent(ch, 1);
        orderMap.putIfAbsent(ch, num);
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        Set<Character> set = new HashSet<>();
        for (Character ch :  chMap.keySet()) {
            if (chMap.get(ch) == 1) {
                set.add(ch);
            }
        }

        return 'C';
    }

    public static void main(String[] args) {
//        Test test = new Test();
//        String str = "google";
//        char[] chars = str.toCharArray();
//        StringBuilder res = new StringBuilder();
//        for (int i = 0; i < chars.length; i++) {
//            test.Insert(chars[i]);
//            char c = test.FirstAppearingOnce();
//            res.append(c);
//        }
//        System.out.println(res);

//        String s1 = "liuliang";
        String s2 = new StringBuilder("liuliang").toString();
        System.out.println(s2 == s2);
        System.out.println(s2 == s2.intern());


        Integer i1 = 128;
        Integer i2 = 128;
        System.out.println(i1 == i2);

        Integer i3 = -128;
        Integer i4 = -128;
        System.out.println(i3 == i4);
    }
}
