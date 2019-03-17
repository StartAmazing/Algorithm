package com.ll.interest.greed;

import javafx.scene.transform.MatrixType;

/**
 *
 * huffman编码的基本思想是以字符的使用频率作为权构建一棵huffman树，然后利用Huffman
 * 树对字符进行编码。构造一棵Huffman树，是将所要编码的字符作为叶子结点，该字符在文
 * 件中的使用频率作为叶子节点的权值，以自底向上的方式，通过n-1次的“合并”运算后构
 * 造一棵树，核心思想是权值越大的叶子离根越近
 * huffman算法的贪心策略是每次从树的集合中取出没有双亲且权值最小的两棵树作为左右子树
 * ，构造一棵新树，新树根结点的权值作为其左右结点权值之和，将新树插入到树的集合之中。
 *
 * 步骤：
 * （1）确定合适的数据结构。编写程序前需要考虑的情况有：
 *      a.huffman树中没有度为1的结点，则一棵有n个叶子节点的huffman树共有2n-1个节点
 *      ``(n-1次的“合并”,每次产生一个新的结点)；
 *      b.构成huffman树后，为求编码，需从叶子节点出发走一条从叶子到根的路径；
 *      c.译码需要从根出发走一条从根到叶子的路径，那么我们需要知道每个结点的权值、
 *        双亲、左孩子、右孩子和结点信息。
 *  （2）初始化。构造n棵结点为n个字符的单节点树集合T={t1,t2,t3,...,tn},每棵树只有一个
 *       带权的根结点，权值为该字符的使用频率
 *  （3）如果T中只剩下一颗树，则huffman树构造成功，则调至步骤（6）。否则，从集合T中取
 *       出没有双亲且权值最小的两棵树ti和tj，将他们合并成一棵新树zk，新树的左孩子为ti,
 *       右孩子为tj,zk的权值为ti和tj之和。
 *  （4）从集合T中删去ti和tj，加入zk。
 *  （5）重复以上（3）~（4）步
 *  （6）约定左分支上的编码为“0”，右分支上的编码为“1”，从叶子节点到根结点逆向求出
 *       每个huffman编码，从根结点到叶子节点的路径上的字符组成的字符串为该叶子节点的
 *       huffman编码。算法结束。
 *
 *  在构造huffman树的过程中，首先给每个节点的双亲、左孩子、右孩子初始化为-1，找出所有
 *  节点中双亲为-1，权值最小的两个结点t1,t2，并合并为一棵二叉树，更新信息（双亲节点中
 *  的权值为t1、t2权值之和，其左孩子为权值最小的结点t1,右孩子为次小的结点t2，t1、t2的
 *  双亲为双亲节点的编号）。重复此过程，构造一棵huffman树
 *
 *
 * （1）数据结构
 *      每个结点的结构包括权值、双亲、左孩子、右孩子、结点字符信息这5个领域。
 *      class HNodeType
 *      {
 *          double weight; //权值
 *          int parent; //双亲
 *          int lchild; //左孩子
 *          int rchild; //右孩子
 *          char value; //该节点表示的字符
 *      }
 *
 *      在编码结构体中，bit[]存放结点的编码，start记录编码开始下标，逆向译码（从叶子到根
 *      ，想一想为什么不从根到叶子呢？）。存储时，start从n-1开始依次递减，从后向前存储；
 *      读取时，从start+1开始到n-1，从前向后输出，即为该字符的编码。
 *      编码结构体
 *      class HcodeType
 *      {
 *          int bit[MAXBIT]; //存储编码的数组
 *          int start;   //编码开始下标
 *      }
 * （2）初始化
 *      初始化存放huffman数组HuffNode[]中的结点
 *      for(i = 0; i < 2*n - 1 ;i ++)
 *      {
 *          HuffNode[i].weight = 0; //权值
 *          HuffNode[i].parent = -1; //双亲
 *          HuffNode[i].lchild = -1; //左孩子
 *          HuffNode[i].rchild = -1; //右孩子
 *      }
 * （3）循环构造Huffman树
 *      从集合T中取出双亲为-1且权值最小的两棵树ti和tj,将他们合并成一棵树zk，新树的左孩子为ti，
 *      右孩子tj,zk的权值为ti和tj的权值之和。
 *      int i,j,x1,x2;   //x1,x2为两个最小权值结点的序号
 *      double m1,m2;  //m1、m2为两个最小结点的权值
 *      for(i = 0 ; i < n - 1 ; i ++){
 *          m1 = m2 = Double.MAX_VALUE;        //初始化为最大值
 *          x1 = x2 = -1;           //初始化为-1
 *          //找出所有结点中权值最小，无双亲结点的两个结点
 *          for(j = 0 ; j < n+i ; j ++){
 *              if(HuffNode[j].weight < m1 &&  HuffNode[j].parent == -1){
 *                  m2 = m1;
 *                  x2 = x1;
 *                  m1 = HuffNode[j].weight;
 *                  x1 = j;
 *              }
 *              else if(HuffNode[j].weight < m2 && HuffNode[j].parent == -1){
 *                  m2 = HuffNode[j].weight;
 *                  x2 = j;
 *              }
 *          }
 *          //更新新树信息
 *          HuffNode[x1].parent = n + i;
 *          HuffNode[x2].parent = n + i;
 *          HuffNode[n+i].weight = m1 + m2;
 *          HuffNode[n+i].lchild = x1;
 *          HuffNode[n+i].rchild = x2;
 *      }
 * （4）输出huffman编码
 *      void HuffmanCode(HCodeType HuffCode[MAXLEAF], int n)
 *      {
 *          HCodeType cd;  //定义一个临时变量来存放求解编码时的信息
 *          int i, j, c, p;
 *          for(i = 0; i < n; i++){
 *              cd.start = n - 1;
 *              c = i;      //i为叶子节点的编号
 *              p = HuffNode[c].parent;
 *              while(p != -1){
 *                  if(HuffNode[p].lchild == c){
 *                      cd.bit[cd.start] = 0;
 *                  }
 *                  else{
 *                      cd.bit[cd.start] = 1;
 *                  }
 *                  cd.start--;         //start向前移动一位
 *                  c = p;              //c，p变量上移，准备下一个循环
 *                  p = HuffNode[c].parent;
 *              }
 *              //把叶子结点的编码信息从临时编码cd中赋值出来，放入编码结构体中数组
 *              for(j = cd.start + 1; j<n; j++ ){
 *                  HuffCode[i].bit[j] = cd.bit[j];
 *              }
 *              HuffCode[i].start = cd.start;
 *          }
 *      }
 *
 *
 */
public class HuffmanCode {
    static Integer MAXBIT = 100;
    static Integer MAXVALUE = 10000;
    static Integer MAXLEAF = 30;
    static Integer MAXNODE = MAXLEAF * 2 -1;
    /**
     * 结点类
     */
    public static class HNodeType{
        double weight;
        int parent;
        int lchild;
        int rchild;
        char value;
        public HNodeType(){
            this.weight = 0;
            this.parent = -1;
            this.lchild = -1;
            this.rchild = -1;
            this.value = 'a';
        }
    }

    /**
     * 编码类
     */
    public static class HCodeType{
        int[] bit = new int[MAXBIT];
        int start;
        public HCodeType(){
            for (int i = 0; i < bit.length; i++ ){
                bit[i] = -1;
            }
            this.start = -1;
        }
    }

    static HNodeType[] HuffNode = new HNodeType[MAXNODE];  //定义一个结点类数组
    static HCodeType[] HuffCode = new HCodeType[MAXLEAF];  //定义一个编码机构体数组

    /*构造huffman树*/
    public static void HuffmanTree(int n){
        HuffNode = new HNodeType[MAXNODE];
        /**
         * i, j：循环变量
         * m1, m2：构造huffman树不同过程中两个最小权值结点的权值
         * x1, x2：构造huffman树不通过程中最小权值在数组中的序号
         */
        int i, j, x1, x2;
        double m1, m2;
        for(i = 0; i < 2*n - 1; i++){
            HuffNode[i] = new HNodeType();
        }
        //初始化存放huffman数组HuffNode[]中的节点
        for(i = 0; i < 2*n -1; i++){
            HuffNode[i].weight = 0; //权值
            HuffNode[i].parent = -1; //父节点
            HuffNode[i].lchild = -1; //左孩子
            HuffNode[i].rchild = -1; //右孩子
        }

        //输入n个叶子节点的权值和value值
        for(i = 0; i < n; i++){
            HuffNode[i].weight = (int) (Math.random() * 100);
            HuffNode[i].value = (char) ('a' + i);
            System.out.println(HuffNode[i].value + " weight is : " + HuffNode[i].weight);
        }

        //构造huffman树
        for(i = 0; i < n -1; i++){
            //执行n-1次合并
            m1 = m2 = MAXVALUE;
            //x1,x2存放两个无父节点且结点权值最小的两个结点
            x1 = x2 = -1;
            //找出所有节点中权值最小，无父节点的两个结点，并合并之为一棵二叉树
            for(j = 0; j < n + i; j ++){
                if(HuffNode[j].weight < m1 && HuffNode[j].parent == -1){
                    m2 = m1;
                    x2 = x1;
                    m1 = HuffNode[j].weight;
                    x1 = j;
                } else  if(HuffNode[j].weight < m2 && HuffNode[j].parent == -1){
                    m2 = HuffNode[j].weight;
                    x2 = j;
                }
            }

            //设置找到的两个子节点x1，x2的父节点的信息
            HuffNode[x1].parent = n + i;
            HuffNode[x2].parent = n + i;
            HuffNode[n+i].weight = m1 + m2;
            HuffNode[n+i].lchild = x1;
            HuffNode[n+i].rchild = x2;

            System.out.println("x1.weight and x2.weight in round " + (i + 1) + "\t" + HuffNode[x1].weight + "\t" + HuffNode[x2].weight); // for test
        }
    }

    //huffman编码
    public static void HuffmanCode(int n){
        HuffCode = new HCodeType[MAXLEAF];
        HCodeType cd = new HCodeType(); //定义一个临时变量来存放求解编码时的信息
        int i, j, c, p;
        for(i = 0; i < n; i++){
            HuffCode[i] = new HCodeType();
        }
        for(i = 0; i < n; i++){
            cd.start = n -1;
            c = i;
            p = HuffNode[c].parent;
            while(p != -1){
                if(HuffNode[p].lchild == c){
                    cd.bit[cd.start] = 0;
                }else{
                    cd.bit[cd.start] = 1;
                }
                cd.start --;        //求编码的低一位
                c = p;
                p = HuffNode[c].parent; //设置下一循环条件
            }
            //把叶子节点的编码信息从临时编码cd中赋值出来，放入编码结构体数组
            for(j = cd.start + 1 ; j < n ; j ++){
                HuffCode[i].bit[j] = cd.bit[j];
            }
            HuffCode[i].start = cd.start;
        }
    }

    public static void main(String[] args) {
        int i, j, n;
        n = 5;
        //构造huffman树
        HuffmanTree(n);
        //huffman树编码
        HuffmanCode(n);
        //输出已经保存好的所有存在编码的huffman编码
        for(i = 0; i < n; i++ ){
            System.out.print(HuffNode[i].value + ": HuffmanCode is:  ");
            for (j = HuffCode[i].start + 1 ; j < n; j++){
                System.out.print(HuffCode[i].bit[j]);
            }
            System.out.println();
        }


    }
}
