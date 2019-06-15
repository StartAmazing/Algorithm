package com.ll.math;

public class PrimeNumber {

    //判断一个数是否为素数
    public static boolean isPrime(int n){
        int i;

        if( n <= 1){
            return false;
        }
        for(i = 2; i*i <= n; i++ ){
            if(n % i ==0){
                return false;
            }
        }
        return true;
    }

    //寻找素数---暴力法

    /**
     * @param n 表示找出从[1, n]范围内的所有素数
     */
    public static void findPrime(int n){
        int i, m = 0, t = 1;
        System.out.println(n + "内的所有素数： ");

        for(i = 2 ; i < n ; i++){
            if(isPrime(i)){
                m++;
                t++;
                System.out.print(i + " ");
                if(t > 10){
                    System.out.print("\n");
                    t = 1;
                }
            }
        }
        System.out.println();
        System.out.println(n + "内的素数一共有：" + m + "个");
    }

    //寻找素数---Eratosthenes算法

    /**
     * @param n 表示找出从[1, n]范围内的所有素数
     */
    public static void findPrimeWithEratosthenes(int n){
        int i, j, c=0;
        int[] prime=new int[n + 1];     //定义保存素数的数组
        for(i = 2; i <= n; i++){         //初始化数组
            prime[i] = 1;                //标志为1表示对应的数是素数
        }

        for(i = 2; i*i <= n;i ++){      //循环处理前i个
            if(prime[i] == 1)           //若为素数则进行筛选
            {
                for(j = 2 * i; j <= n; j ++){      //筛去合数
                    if(prime[j] == 0)
                        continue;
                    if(j % i == 0)
                        prime[j] = 0;
                }
            }
        }

        //输出素数
        for(i = 2; i < n; i++){     //输出素数
            if(prime[i] == 1){
                System.out.print(i + " ");
                c++;
                if(c % 10 == 0){
                    System.out.print("\n");
                }
            }
        }

        System.out.println();
        System.out.println("共有"+c+"个素数");
    }

    /**
     * @param n 找出[1, n]区间内所有的孪生素数
     */
    public static void getTwinPrime(int n){
        int i, j, c = 0;
        long twin = 2, t = 0;

        int[] prime = new int[n + 1];     //定义保存素数的数组
        prime[0] = 0;
        prime[1] = 0;

        for(i = 2; i <= n; i++){        //初始化数组
            prime[i] = 1;       //标志为1对应的数为素数
        }

        for(i = 2; i*i <= n; i++){      //筛选合数
            if(prime[i] == 1){          //若为素数
                for(j = 2 * i ; j <= n; j ++){      //筛去合数
                    if(prime[j] == 0) continue;
                    if(j % i == 0)      //数j能被整除，说明不是素数
                        prime[j] = 0;   //清除标志位
                }
            }
        }

        //统计素数数量
        for(i = 2; i < n; i ++){
            if(prime[i] == 1){
                c++;
                if(i-2 == twin){
                    System.out.print("{"+ twin +","+ i +"}");
                    t++;
                    if(t % 5 == 0)
                        System.out.println();
                }
                twin = i;
            }

        }
        System.out.println("共有"+c+"个素数！共有"+t+"对素数！");

    }

    public static void main(String[] args) {
        findPrime(1000);
        System.out.println("=====================");
        findPrimeWithEratosthenes(1000);
        System.out.println("*********************");
        getTwinPrime(10000);
    }

}
