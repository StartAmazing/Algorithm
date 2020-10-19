package com.ll.zs.nowcoder.basic.class07.mytest;

/**
 * 折纸凹痕问题 - 二叉树的中序遍历
 * 请把一段纸条竖放在桌子上，然后从纸条的下边向上方对折一次，压出折痕后展开，
 * 此时折痕是凹下去的，即折痕凸起的方向指向纸条的背面。如果从纸条的下边向上方
 * 连续低着两次，压出折痕之后展开，此时有三条折痕，从上到下依次是下折痕、下折
 * 痕和上折痕。给定一个输入参数N，代表纸条都从下边向上方连续对折N次，请从上到
 * 下打印所有折痕的方向。例如：N = 1 时，打印：down；N = 2时，打印： down,down,up
 *
 */
public class PaperFolding {

    public static void printAllFolds(int N){
        printProcess(1, N, true);
    }

    /**
     * @param i 当前所在的层数，初始值为第0层
     * @param N 固定不变的，表示该二叉树（完全二叉树）总共拥有的层数
     * @param down  表示当前在左子树还是右子树（true表示在左子树，false表示在右子树）
     *              第一层默认为true
     */
    public static void printProcess(int i, int N,boolean down){
        if(i > N){
            return;
        }
        printProcess(i + 1, N ,true);   //折痕左子树都向下
        System.out.print(down ? "down  " : "up  ");
        printProcess(i + 1, N, false);  //折痕右子树都向上
    }

    public static void main(String[] args) {
        int N = 3;
        printAllFolds(N);
    }

}
