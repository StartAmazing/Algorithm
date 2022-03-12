1. 二分法模板化
- Given an sorted integer array - nums, and an integer - target.
  find the any/first/last position of target in nums
  returns -1 if target does not exist.
- 时间复杂度
  T(n) = T(n / 2) + O(1) = O(log n)
  T(n) = T(n / 2) + O(n) = O(n)
- Time Complexity in coding interview
  O(1) 极少
  O(log n) 几乎都是二分法
  O(根号n) 几乎都是分解质因数
  O(n) 高频
  O(nlogn) 一般都可能要排序
  O(n^2)数组，枚举，动态规划
  O(n^3)数组，枚举，动态规划
  O(2^n)与组合有关的搜索
  O(n!)与排列有关的搜索
- 比O(n)更优的时间复杂度，几乎只能是O(logn)的二分法
  经验之谈: 根据时间复杂度倒推算法是面试中常用策略
- Recursion or While Loop?
  R: Recursion
  W: While loop
  B: Both work
- Notice
  while(start + 1 < end)    ----> 最后只需要判断两个数(start, end), 二分法不一定最后就只能剩一个数
  start + (end - start) / 2
  A[mid] ==, > , <  三种情况判断
  A[start], A[end]   ---> 两端都需要判断

2. 二分法 AAABBB 类
- 找到满足某个条件的第一个位置或是最后一个位置

3. 二分法 保留一半 类  half half
- 保留有解的一般，或者去掉无解的一半
