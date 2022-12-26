- Linked List VS Array
    - Linked List
      Dummy Node
      High Frequency

    - Array
      Subarray
      Sorted Array

如何使用DummyNode
    - 当链表结构发生变化的时候
    - DummyNode不需要删除

子数组 Subarray
    令 PrefixSum[i] = A[0] + A[1] + … A[i - 1],
    PrefixSum[0] = 0
    易知构造 PrefixSum 耗费 O(n) 时间和 O(n) 空间
    如需计算子数组从下标i到下标j之间的所有数之和
    则有 Sum(i~j) = PrefixSum[j + 1] - PrefixSum[i]