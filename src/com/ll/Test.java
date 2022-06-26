package com.ll;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

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

    public static <T> List<T> filter(List<T> numbers, Predicate<T> p) {
        List<T> result = new ArrayList<>();
        for (T number : numbers) {
            if (p.test(number)) {
                result.add(number);
            }
        }

        return result;
    }

    public static <T, R> List<R> map(List<T> list, Function<T, R> mapper) {
        List<R> res = new ArrayList<>();
        for (T t : list) {
            res.add(mapper.apply(t));
        }

        return res;
    }

    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);

        ArrayList<String> strings = new ArrayList<>();
        strings.add("aass");
        strings.add("aassa");
        strings.add("as");
        strings.add("aasxss");

        List<Integer> filter = filter(numbers, (aNum) -> aNum % 2 == 0);
        System.out.println(filter);
        List<String> filter1 = filter(strings, aStr -> aStr.length() > 3);
        System.out.println(filter1);

        List<Integer> filter3 = filter(numbers, ((Predicate<Integer>) integer -> integer % 2 != 0).and(integer -> integer % 3 != 0));
        System.out.println(filter3);

        List<Integer> map = map(strings, str -> str.length());
        System.out.println(map);

        System.out.println("Running:" + 0b11100000000000000000000000000000);
        System.out.println("SHUTDOWN:" + 0b00000000000000000000000000000000);
        System.out.println("STOP:" + 0b00100000000000000000000000000000);
        System.out.println("TIDYING:" + 0b01000000000000000000000000000000);
        System.out.println("TERMINATED:" + 0b01100000000000000000000000000000);
    }
}
