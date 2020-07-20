package com.ll.lintcode.advance.chapter4.binarysearch;

/**
 * 给定 n 本书, 第 i 本书的页数为 pages[i]. 现在有 k 个人来复印这些书籍, 而每个人只能复印编号连续的一段的书,
 * 比如一个人可以复印 pages[0], pages[1], pages[2], 但是不可以只复印 pages[0], pages[2], pages[3] 而不复印 pages[1].
 * <p>
 * 所有人复印的速度是一样的, 复印一页需要花费一分钟, 并且所有人同时开始复印. 怎样分配这 k 个人的任务,
 * 使得这 n 本书能够被尽快复印完?
 * <p>
 * 返回完成复印任务最少需要的分钟数.
 * <p>
 * 书籍页数总和小于等于2147483647
 * <p>
 * 您在真实的面试中是否遇到过这个题？
 * 样例
 * 样例 1:
 * <p>
 * 输入: pages = [3, 2, 4], k = 2
 * 输出: 5
 * 解释: 第一个人复印前两本书, 耗时 5 分钟. 第二个人复印第三本书, 耗时 4 分钟.
 * 样例 2:
 * <p>
 * 输入: pages = [3, 2, 4], k = 3
 * 输出: 4
 * 解释: 三个人各复印一本书.
 * 挑战
 * 时间复杂度 O(nk)
 */
public class CopyBooks_437 {

    public int copyBooks(int[] pages, int k) {
        if (null == pages || pages.length < 1) {
            return 0;
        }

        int end = getSum(pages);
        int start = getMax(pages);

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (check(pages, mid, k)) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (check(pages, start, k)) {
            return start;
        }

        return end;
    }

    private boolean check(int[] pages, int limit, int k) {
        int num = 0;
        int left = 0;
        for (int i = 0; i < pages.length; i++) {
            if (pages[i] > limit) {
                return false;
            }
            if (pages[i] > left) {
                num++;
                left = limit;
            }

            left -= pages[i];
        }

        return num <= k;
    }

    private int getSum(int[] pages) {
        int sum = 0;
        for (int i = 0; i < pages.length; i++) {
            sum += pages[i];
        }
        return sum;
    }

    private int getMax(int[] pages) {
        int max = pages[0];
        for (int i = 1; i < pages.length; i++) {
            max = Math.max(max, pages[i]);
        }

        return max;
    }
}
