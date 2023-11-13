package org.example.leetcode_string;

public class Leetcode_string_459 {

    /*
        给定一个非空的字符串 s ，检查是否可以通过由它的一个子串重复多次构成。
     */

    public static void main(String[] args) {
        System.out.println(repeatedSubstringPattern("aba"));
    }

    public static boolean repeatedSubstringPattern(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        boolean result = false;
        int slow = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(slow)) {
                result = true;
                slow += 1;
            } else {
                result = false;
                slow = 0;
            }
        }
        return result;
    }

}
