package com.ll.lintcode.twopoint;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 设计并实现一个 TwoSum 类。他需要支持以下操作:add 和 find。
 * add -把这个数添加到内部的数据结构。
 * find -是否存在任意一对数字之和等于这个值
 *
 * 样例
 * 样例 1:
 *
 * add(1);add(3);add(5);
 * find(4)//返回true
 * find(7)//返回false
 */
public class TwoSum_DataStructureDesign_607 {

    private List<Integer> list = null;
    private Map<Integer,Integer> map = null;

    public TwoSum_DataStructureDesign_607(){
        list = new ArrayList<Integer>();
        map = new HashMap<Integer, Integer>();
    }
    /**
     * @param number: An integer
     * @return: nothing
     */
    public void add(int number) {
        if(map.containsKey(number)){
            map.put(number,map.get(number) + 1);
        }else{
            map.put(number,1);
            list.add(number);
        }

    }

    /**
     * @param value: An integer
     * @return: Find if there exists any pair of numbers which sum is equal to the value.
     */
    public boolean find(int value) {
        for (Integer integer : list) {
            int num1 = integer, num2 = value - num1;
            if ((num1 == num2 && map.get(num1) > 1)
                    || (num1 != num2 && map.containsKey(num2))) {
                return true;
            }
        }
        return false;
    }
}
