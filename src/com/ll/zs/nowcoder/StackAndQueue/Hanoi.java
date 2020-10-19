package com.ll.zs.nowcoder.StackAndQueue;

import java.util.Stack;

//经典的汉诺塔问题
public class Hanoi {
    //1、递归方法求解汉诺塔问题
    /**
     *  如果剩下N层塔，从上至下依次为1~N，则有如下判断
     *  1.如果剩下的N层塔都在“左”，希望全部移到“中”，则有如下三个步骤
     *      step 1:将1~N-1层塔先全部从“左”移到“右”，使用递归过程；
     *      step 2:将第N层塔从“左”移到“中”；
     *      step 3:再将1~N-1层塔全部从“右”移到“中”，使用递归过程；
     *  2、如果把剩下的N层从“中”移到“左”、从“右”移到“中”、从“中”移到“右”，过程与过程1同理，同样是分为三步
     *  3、如果剩下的N层都从“左”移到“右”，则分为五个步骤
     *      step 1:将1~N-1层全部先从“左”移到“右”，使用递归过程
     *      step 2:将第N层塔从“左”移到“中”；
     *      step 3:将1~N-1层全部从“右”移到“左”，使用递归过程
     *      step 4:将第N层塔从“中”移到“右”；
     *      step 5:将1~N-1层全部从“左”移到“右”，使用递归过程
     *  4、如果把剩下的N层都从“右”移到“左”，和过程3同理，同样是分为5部
     */
    public static int hanoiProblem1(int num, String left, String mid, String right){
        if(num < 1){
            return 0;
        }
        return process(num, left, mid, right, left, right);
    }

    public static int process(int num, String left, String mid, String right, String from, String to){
        if(num == 1){
            if(from.equals(mid) || to.equals(mid)){
                System.out.println("Move 1 from " + from + " to " + to);
                return 1;
            }else{
                System.out.println("Move 1 from " + from + " to " + mid );
                System.out.println("Move 1 from " + mid + " to " + to);
                return 2;
            }
        }
        if(from.equals(mid) || to.equals(mid)){         //如果from 和 to之间有一个是mid则属于第一种大的情况，即分为三步移动
            String another = (from.equals(left) || to.equals(left)) ? right : left;     //确定1~N-1是从左移到右还是从右移到左
            int part1 = process(num - 1, left, mid, right, from, another);
            int part2 = 1;
            System.out.println("Move " + num + " from " + from + " to " + to);
            int part3 = process(num - 1,left, mid, right, another, to);
            return part1 + part2 + part3;
        }else{      //如果from和mid都不是mid，则属于第二种大的情况，分为五步移动
            int part1 = process(num - 1, left, mid, right, from, to);
            int part2 = 1;
            System.out.println("Move " + num + " from " + from + " to " + mid);
            int part3 = process(num - 1, left, mid, right, to, from);
            int part4 = 1;
            System.out.println("Move " + num + " from " + mid + " to " + to);
            int part5 = process( num -1, left, mid, right, from, to);
            return part1 + part2 + part3 + part4 + part5;
        }
    }

    //2、非递归方法求解汉诺塔问题
    /**
     * 改进了的汉诺塔问题实际能够产生的行为只有四种
     * “左”到“中”、“中”到“左”、“右”到“中”、“中”到“右”
     * 非递归求解汉诺塔问题的核心原则：
     * 1、游戏的第一个动作一定是L->M
     * 2、在走出最少步数过程中的任何时刻，四个动作中只有一个动作不违反小压大和相邻不可逆原则，另外三个动作一定都会违反
     * 综上所述：每走一步只会有一个动作达标。那么只要每走一步都根据这两个原则考察所有的动作就可以，哪个动作达标就走哪个动作即可。
     */
    public enum Action{
        No, LToM, MToL, RToM, MToR
    }
    /**
     * @param record    用来改变当前记录的步骤
     * @param preNoAct  上一个步骤
     * @param nowAct     这个步骤
     * @param fStack    从哪个栈中
     * @param tStack    到哪个栈中
     * @param from      从哪个柱子
     * @param to        到哪个柱子
     * @return
     */
    public static int fStackTotStack(Action[] record, Action preNoAct, Action nowAct, Stack<Integer> fStack, Stack<Integer> tStack, String from, String to){
       if(record[0] != preNoAct && fStack.peek() < tStack.peek()){
           tStack.push(fStack.pop());
           System.out.println("Move " + tStack.peek() + " from " + from + " to " + to);
           record[0]  = nowAct;
           return 1;
       }
       return 0;
    }

    public static int hanoiProblem2(int num, String left, String mid, String right){
        Stack<Integer> LS = new Stack<>();
        Stack<Integer> MS = new Stack<>();
        Stack<Integer> RS = new Stack<>();

        LS.push(Integer.MAX_VALUE);
        MS.push(Integer.MAX_VALUE);
        RS.push(Integer.MAX_VALUE);
        for(int i = num; i > 0; i--){
            LS.push(i);
        }
        Action[] record = {Action.No};
        int step = 0;
        while(RS.size() != num + 1){    //当全部完成时，3号柱子上面的的元素个数应该为Num的个数加上一个Integer.MAX_VALUE,所以总的size是num+1
            step += fStackTotStack(record, Action.MToL, Action.LToM, LS, MS, left, mid);
            step += fStackTotStack(record, Action.LToM, Action.MToL, MS, LS, mid, left);
            step += fStackTotStack(record, Action.RToM, Action.MToR, MS, RS, mid, right);
            step += fStackTotStack(record, Action.MToR, Action.RToM, RS, MS, right, mid);
        }
        return step;
    }

    public static void main(String[] args) {
        int count = hanoiProblem1(2, "1", "2", "3");
        System.out.println("递归算法共需要：" + count + "步完成！");
        count = hanoiProblem2(2,  "1", "2", "3");
        System.out.println("非递归算法共需要：" + count + "步完成！");
    }


}
