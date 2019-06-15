package com.ll.leetcode;

public class GetCommonPrefix_14 {

    //1、水平扫描
    public static String solution(String[] arr){
        if(arr.length == 0){
            return "";
        }
        String prefix = arr[0];
        for(int i = 0; i < arr.length ; i ++){
            while(arr[i].indexOf(prefix) != 0){
                prefix = prefix.substring(0,prefix.length() - 1);
                if(prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }

    //2、优化的水平扫描
    public static String solution2(String[] arr){
        if(arr.length == 0) return "";
        for(int i = 0; i < arr[0].length(); i++ ){
            char c = arr[0].charAt(i);
            for(int j = 1 ; j < arr.length ; j ++){
                if( i == arr[j].length() || c != arr[j].charAt(i)){
                    return arr[0].substring(0,i);
                }
            }
        }
        return arr[0];
    }

    //3、分治
    public static String solution3(String[] arr){
        if(arr == null || arr.length == 0) return "";
        return solution3(arr, 0, arr.length - 1);
    }
    private static String solution3(String[] arr,int l, int r){
        if(l == r){
            return arr[l];
        }
        else{
            int mid = (l + r) / 2;
            String lcpLeft = solution3(arr, l, mid);
            String lcpRight = solution3(arr, mid + 1, r);
            return commonPrefix(lcpLeft,lcpRight);
        }
    }
    private static String commonPrefix(String left, String right){
        int min = Math.min(left.length(), right.length());
        for(int i = 0; i < min; i++){
            if(left.charAt(i) != right.charAt(i)){
                return left.substring(0,i);
            }
        }
        return left.substring(0,min);
    }

    //4、二分查找法
    public static String solution4(String[] arr){
        if(arr == null || arr.length == 0){
            return "";
        }
        int minLen = Integer.MAX_VALUE;
        for(String s : arr){
            minLen = Math.min(minLen, s.length());
        }
        int low = 1;
        int high = minLen;
        while( low <= high){
            int middle = (low + high) / 2;
            if(isCommonPrefix(arr,middle))
                low = middle + 1;
            else
                high = middle - 1;
        }
        return arr[0].substring(0,(low + high) / 2);
    }
    private static boolean isCommonPrefix(String[] arr,int len){
        String str1 = arr[0].substring(0,len);
        for(int i = 1; i < arr.length ; i++){
            if(! arr[i].startsWith(str1)){
                return false;
            }
        }
        return true;
    }

    //5、Trie字典树


    public static void main(String[] args) {
        String[] arr = {"leetsCode","leettty","lett","letyte"};
        String solution = solution(arr);
        System.out.println(solution);

        solution = solution2(arr);
        System.out.println(solution);

        solution = solution3(arr);
        System.out.println(solution);

        solution = solution4(arr);
        System.out.println(solution);
    }







}
