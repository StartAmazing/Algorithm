package com.ll.nine_chapter.special_topic;

public class RabinKarp {

    private static int HASH_MAGIC_NUMBER = 31;

    private static int HASH_BASE_NUMBER = 1000000;

    /**
     * @param source
     * @param target
     * @return
     */
    public static int strStr(String source, String target) {
        if (source == null || target  == null ) {
            return -1;
        }

        int m = target.length();
        if (m == 0) {
            return 0;
        }

        // 31 ^ m
        int power = 1;
        for (int i = 0; i < m; i++) {
            power = (power * HASH_MAGIC_NUMBER) / HASH_BASE_NUMBER;
        }

        int targetCode = 0;
        for (int i = 0; i < m; i++) {
            targetCode = (targetCode * 31 + target.charAt(i)) % HASH_BASE_NUMBER;
        }
        int hashcode = 0;
        // ""
        for(int i = 0; i < source.length(); i++) {
            // abc + d
            hashcode = (hashcode * 31 + source.charAt(i)) % HASH_BASE_NUMBER;
            if (i < m - 1) {
                continue;
            }

            // abcd - a
            if (i >= m) {
                hashcode = hashcode - (power * source.charAt(i - m)) % HASH_BASE_NUMBER;
                if (hashcode < 0 ) {
                    hashcode = hashcode + HASH_BASE_NUMBER;
                }
            }

            // double check the string
            if (hashcode == targetCode) {
                if (source.substring(i - m + 1, i + 1).equals(target)) {
                    return i - m + 1;
                }
            }
        }
        // not found
        return -1;
    }

    public static void main(String[] args) {
    }
}
