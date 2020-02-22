package com.ll.lintcode.twopoint;

public class ValidPalindrome_415 {

    public boolean isPalindrome(String s) {
        if(s == null || s.length() < 2){
            return true;
        }
        int l = 0;
        int r = s.length() - 1;
        char[] chars = s.toLowerCase().toCharArray();
        while (l < r){
            if(chars[l] < '0' || (chars[l] > '9' && chars[l] < 'A') || (chars[l] > 'Z' && chars[l] < 'a') || chars[l] > 'z'){
                l ++;
                continue;
            }
            if(chars[r] < '0' || (chars[r] > '9' && chars[r] < 'A') || (chars[r] > 'Z' && chars[r] < 'a') || chars[r] > 'z'){
                r --;
                continue;
            }
            if(chars[l ++] != chars[r --]){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println((int)'a');
        ValidPalindrome_415 dto = new ValidPalindrome_415();
        String s = "ab";
        boolean palindrome = dto.isPalindrome(s);
        System.out.println(palindrome);
    }
}
