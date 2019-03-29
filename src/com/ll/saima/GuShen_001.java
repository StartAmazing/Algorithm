package com.ll.saima;

/**
 * 有股神吗？
 *
 * 有，小赛就是！
 *
 * 经过严密的计算，小赛买了一支股票，他知道从他买股票的那天开始，股票会有以下变化：第一天不变，以后涨一天，跌一天，涨两天，跌一天，涨三天，跌一天...依此类推。
 *
 * 为方便计算，假设每次涨和跌皆为1，股票初始单价也为1，请计算买股票的第n天每股股票值多少钱？
 * 
 */
/**
 * @Author liuliang 
 * @Date   2019/3/28 0028 10:40
 */
public class GuShen_001 {

    //方法一，for循环方法
    public static int solution(int day){
        int price = 1;
        int priceDownDate = 3;
        int priceDownNumber = 1;
        for(int i = 2; i <= day ; i++){
            if(priceDownDate == i){
                priceDownNumber ++;
                priceDownDate = (priceDownNumber*priceDownNumber + 3 * priceDownNumber) / 2 + 1;
                price --;
            }else{
                price ++;
            }
        }
        return price;
    }

        //方法二，公式
    public static int solution2(int day){
        int price,priceDownNum;
        priceDownNum = (int)(Math.sqrt(2*day + 0.25) - 1.5);
        price = day - 2 * priceDownNum;
        return price;
    }

    //方法3：步长法
    public static int solution3(int day){
        int result = 1;
        boolean flag = true;
        int step = 1;
        for(int i = 2, j = 0; i <= day; i++){
            if(j < step){
                j++;
            }else{
                j = 0;
                flag = false;
                step ++;
            }
            if(flag){
                result++;
            }else{
                result--;
                flag = true;
            }
        }
        return result;
    }

    //方法4:找规律
    public static int solution4(int day){
        int i = 0; //用于统计遇到了多少次下跌
        int j = 2; //每次下跌之后上涨的天数,包含已经下跌的那天
        int  k  = day;
        while(k > j){
            i += 2;
            k = k - j;
            ++j;
        }
        return day - i;
    }


    public static void main(String[] args) {
        int solution = solution(4);
        System.out.println(solution);
        solution = solution2(4);
        System.out.println(solution);
        solution = solution3(4);
        System.out.println(solution);
        solution = solution4(4);
        System.out.println(solution);
    }
}
