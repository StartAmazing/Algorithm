package com.ll.zs.nowcoder.hash;

/**
 * @author LL
 * @date 2019/8/5
 * @description 布隆过滤器
 */
public class BoolongFilter {

    public static void main(String[] args) {

        int[] arr = new int[1000];  //可以表示32000个bit位 0 ~ 31999

        int index = 30000;

        int intIndex = 30000 / 32;      //找到第30000个数字位于哪个数字上
        int bitIndex = index % 32;   //找到第30000个数字位于哪个bit上

        // 1左移bitIndex位,或运算为了保留前一次的结果,准备K个相互独立的哈希函数
        arr[intIndex] = (arr[intIndex] | (1 << bitIndex));


        /**
         *
         *  布隆过滤器
         * 公式一：
         *      关于数组长度的取值（bit）
         *      长度：       n * ln p
         *          len = - ------------     其中n是样本量，p是允许可接受的误差大小，向上取整
         *                   (ln 2)^2
         * 公式二：
         *      关于hash函数的个数确定
         *      个数：                     m
         *           K   =  (ln 2)^2  *  ----       向上取整
         *                                 n
         * 公式三：
         *       最后失误率：
         *           Pr   =   (1 - e^(-n*k/m))^k
         *
         *
         * 一致性hash -> 用途，服务器负载均衡
         *        虚拟节点技术
         *
         *
         *
         *
         *
         *
         *
         */
    }


}
