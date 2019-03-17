package com.ll.math;

public class Recursion {
    public static long count = 1;

    //1、递归获取最大公约数---辗转相除法
    public static int getGCD(int m, int n){
        if(n > m){
            swap(m, n);
        }
        if(m % n == 0){
            return n;
        }
        return getGCD(n, (m % n));
    }
    public static int getGCD2(int m, int n){
        if(n > m){
            swap(m, n);
        }
        int r = m % n;
        if(r == 0){
            return n;
        }else {
            return getGCD2(n, r);
        }

    }

    //阶乘计算
    //计算进位
    //wrong!
    public static void carry(int bit[], int pos){
        int i, carry = 0;
        for(i = 0; i <= pos; i++){      //从0 ~ pos逐位检查是否需要进位
            bit[i] += carry;
            if(bit[i] <= 9)     //小于9不需要进位
                carry = 0;
            else if(bit[i] > 9 && i < pos){     //大于9但不是最高位
                carry = bit[i] / 10;            //保存进位值
                bit[i] = bit[i] % 10;           //得到该位的一位数
            }
            else if(bit[i] > 9 && i >= pos){     //大于9且是最高位
                while(bit[i] > 9){
                    carry = bit[i] / 10;    //计算进位值
                    bit[i] = bit[i] % 10;   //当前一位数
                    i++;
                    bit[i] = carry;     //在下一位保存进位的值
                }
            }
        }
    }
    public static int getFactorial(int a){
        int count = 0;
        double sum = 0;
        int num, pos, digit, i, j, m, n;
        int[] fact = new int[3000];     //保存阶乘结果的数组
        for(i = 1; i <= a; i++){
            sum += Math.log10(i);           //计算阶乘的位数
        }
        digit = (int)sum + 1;
        return count;
    }

    //2、阶乘计算
    public static int factorial(int n){
        if(n == 0){
            return 1;           //递归的结束条件
        }else{
            return n*factorial(n-1);
        }

    }

    //3、汉诺塔
    public static void hanoi(int n, char a, char b, char c){
        if(n==1){
            System.out.println("第"+(count++)+"次移动"+a+"柱移动到"+c+"柱");
        }else{
            hanoi(n-1,a,b,c);
            System.out.println("第"+(count++)+"次移动"+a+"柱移动到"+c+"柱");
            hanoi(n-1,b,a,c);
        }
    }
    //4、斐波那契数列
    public static int fibo(int n){
        if(n==0){
            return 0;
        }else if(n==1){
            return 1;
        }else{
            return fibo(n-1)+fibo(n-2);
        }
    }

    //交换参数
    public static void swap(int m, int n){
        int tmp = m;
        m = n;
        n = tmp;
    }

    public static void main(String[] args) {
//        int n = getGCD(9,24);
//        int m = getGCD2(9,24);
//        System.out.println(n);
//        System.out.println(m);
//        int res = factorial(6);
//        System.out.println(res);
//        hanoi(8,'a','b','c');
//        System.out.println(fibo(3));
//        System.out.println(fibo(5));
//        System.out.println(fibo(6));
//        System.out.println(fibo(22));
    }


}
