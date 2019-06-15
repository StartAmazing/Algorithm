package com.ll.math;

public class RemainderGroup {

    //1.1、Josephus环  非递归
    /**
     * @param personNum 参与游戏的总人数
     * @param colNum  数到的出列数字
     */
    public static void josephusSort(int personNum,int colNum){
        int[] man = new int[personNum]; //保存出列的序号，为0则表示未出列
        int count = 1;  //出列计数器
        int i = 0;  //报数计数器
        int pos = -1;   //位置计数器
        int alive = 0;

        while(count <= personNum){      //模拟在n个人中循环报数
            do{
                pos = (pos + 1) % personNum;    //取余，进行环状处理
                //如果计数器超过personNum值，又从1开始计数
                if(man[pos] == 0){  //若编号pos还没有出列
                    i++;    //报数
                }
                if(i==colNum){      //报数为colNum的人
                    i = 0;          //初始化计数器，又从1开始报数
                    break;
                }
            }while(true);

            man[pos] = count;   //保存出列序号
            count++;
        }
        System.out.println("约瑟夫排列（最初位置-约瑟夫环）：");    //输出排列位置
        for(i = 0;i < personNum;i++){
            System.out.print((i+1) + " - " + man[i] + "   ");
            if(i != 0 && i % 10 == 0){      //每行输出10组
                System.out.print("\n");
            }
        }
        System.out.println();
        for(i = 0; i < personNum; i ++){
            if(man[i] > personNum -1){
                System.out.println("初始序号："+ (i + 1) + ",约瑟夫环序号：" + man[i]);
            }
        }
        System.out.println();
    }

    //1.2  Josephus环 递归 位置从0开始
    public static int recJosephusSort(int personNum, int colNum){
        if(personNum == 1){
            return 0;
        }else{
            return (recJosephusSort(personNum - 1, colNum) + colNum) % personNum;
        }
    }
    //1.3``Josephus环 非递归的递推 位置从0开始
    public static void noRecJosephusSort(int personNum, int colNum){
        int m,n,i,s = 0;
        n = personNum;
        m = colNum;
        for(i = 2; i <= personNum; i ++){
            s = (s+m)%i;
        }
        System.out.println("最后出列的人的初始位置是："+ (s+1));
    }

    public static void main(String[] args) {
        josephusSort(41,3);

        System.out.println("最后出列的人的初识位置是：" + (recJosephusSort(41,3) + 1));

        noRecJosephusSort(41,3);
    }
}
