package com.ll.zs.nowcoder.java;

public class Test4 {
    public static int output=0;
    public static int foo(int i){
        try{
            if(i == 1){
                throw new Exception();
            }
            return output;
        }catch (Exception e){
            output += 2;
            return output;
        }finally {
            output += 3;
        }
    }

    public static void main(String[] args) {

        System.out.println(foo(1));
        System.out.println(output);
    }
}
