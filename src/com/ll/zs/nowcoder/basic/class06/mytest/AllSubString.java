package com.ll.zs.nowcoder.basic.class06.mytest;

/**
 * 打印一个字符串的所有子序列
 *
 * 打印一个字符串的全排列? --- 有点 问题
 */
public class AllSubString {

    private static void printAllSubstring(char[] arr, int start, String res){
        if(start == arr.length){
            System.out.println(res);
            return;
        }
        printAllSubstring(arr, start + 1, res + arr[start]);
        printAllSubstring(arr, start + 1, res);
    }


    private static void printAllSubString3(char[] str,int start,String res){
        if(start == str.length){
            System.out.println(res);
            return;
        }
        printAllSubString3(str, start+1, res);
        printAllSubString3(str,start+1, res + str[start]);
    }


    private static void printAllSubstring2(char[] arr, int start, String res){
        if(start == arr.length){
            System.out.println(res);
            return;
        }
        printAllSubstring2(arr,start + 1, res);
        printAllSubstring2(arr,start + 1, res + arr[start]);
    }

    private static void printAllPermutations(char[] arr, int i){
        if(i == arr.length){
            System.out.println(String.valueOf(arr));
        }
        for(int j = i ;j < arr.length; j++){
            swap(arr, i, j);
            printAllPermutations(arr, i +1);
        }
    }

    private static void swap(char[] arr, int i, int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args) {
        String test = "abcd";
        printAllSubstring(test.toCharArray(), 0, "");

        System.out.println(" ------------- ");
        printAllPermutations(test.toCharArray(),0);

        System.out.println("---------------");
        printAllSubstring2("abcd".toCharArray(),0,"");

        System.out.println("===============");
        printAllSubString3(test.toCharArray(),0,"");

    }
}
