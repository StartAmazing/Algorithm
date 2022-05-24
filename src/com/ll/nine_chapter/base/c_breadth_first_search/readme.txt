- 二叉树带上的宽搜  BFS in Binary Tree


- 图上的宽搜  BFS in Graph
    - 拓扑排序 Topological Sorting

- 棋盘上的宽搜 BFS

- 什么时候应该使用BFS？
    - 层级遍历(Level Order Traversal)
    - 由点及面(Connected Component)
    - 拓扑排序(Topological Sorting)
- 最短路径 Shortest Path in Simple Graph
    - 仅限简单图求最短路径
        - 即，图中每边长度是1，且没有方向

- 最长路径？
    - 除了BFS还可能是什么算法？最长路径呢？  dp & dfs ?

- 序列化？
1. 将内存中的数据持久化存储时
内存中重要的数据不能只是呆在内存里，这样断电的话数据就丢失了，所以需要一种方式写入到磁盘，需要用到的时候，就可以从硬中再读出来重新创建
2. 网路传输时
机器与机器之间交换数据的时候，不可能相互去读对方的内存，只能将数据变成字符流数据（字符串）后，再通过网络传输过去，接收的一方再将字符串解析后到内存中

常用的一些序列化手段
- XML
- Json
- Thrift(by FaceBook)
- ProtoBuf(by Google)

序列化算法设计时主要考虑到的算法
1. 压缩率
2. 可读性


- 图上的BFS
 图VS树
 图中可能存在环，图中节点之间的关系是双向的，树中更多是单向的
 图的表现形式
 - 邻接表
 - 邻接矩阵

- 能使用BFS解决的问题，一定不要用DFS去做！
    因为用Recursion实现的DFS肯能会造成StackOverFlow

- Topological Sorting 拓扑排序
    - 一种依赖关系

    A -->  B ---> E
      \     \
       \     \
        C --> D

- 矩阵上的BFS
    矩阵 VS 图
    - 图
        N个点，M条边
        M最大是O(N^2)的级别
        图上的BFS的时间复杂度 = O(N + M)
        - 说是O(M)问题也不大，一般M都会比N大
        所以最坏情况下可能是O(N ^ 2)

    - 矩阵 Matrix
    R行C列
    R*C个点，R*C*2条边(每个点上下左右4条，每条边被两个点公用)
    矩阵中BFS时间复杂度 = O(R * C)
