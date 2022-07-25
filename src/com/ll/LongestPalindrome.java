package com.ll;

public class LongestPalindrome {
    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        char[] chars = s.toCharArray();
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            int left = i, right = i;
            while (left >= 0 && right < s.length()) {
                if (chars[left] == chars[right]) {
                    if (res.length() < s.substring(left, right + 1).length()) {
                        res = s.substring(left, right + 1);
                    }
                    left--;
                    right++;
                } else {
                    break;
                }
            }
        }

        for (int i = 0; i < s.length() - 1; i++) {
            int left = i, right = i + 1;
            while (left >= 0 && right < s.length()) {
                if (chars[left] == chars[right]) {
                    if (res.length() < s.substring(left, right + 1).length()) {
                        res = s.substring(left, right + 1);
                    }
                    left--;
                    right++;
                } else {
                    break;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        String s = "babad";
        String s1 = longestPalindrome(s);
        System.out.println(s1);
    }
}
