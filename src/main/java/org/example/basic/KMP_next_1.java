package org.example.basic;

import java.util.Arrays;

public class KMP_next_1 {

    /**
     *   a b c d f a b c d
     * [-1,0,0,0,0,0,1,2,3]
     */

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getNext("abcdabecabcdab")));
    }

    // 动态规划
    public static int[] getNext(String s){
        if (s == null || s.length() == 0) {
            return new int[0];
        }
        int[] next = new int[s.length()];
        next[0] = -1;
        if (s.length() == 1){
            return next;
        }
        next[1] = 0;
        if (s.length() == 2) {
            return next;
        }
        for (int i = 2; i < s.length(); i++) {
            if (s.charAt(next[i - 1]) == s.charAt(i -1)) {
                next[i] = next[i - 1] + 1;
            } else {
                int index = next[next[i -1]];
                while (true) {
                    if (index <= 0) {
                        next[i] = 0;
                        break;
                    }
                    if (s.charAt(index) == s.charAt(i - 1)) {
                        next[i] = next[next[i -1]] + 1;
                        break;
                    } else{
                        index = next[index];
                    }
                }
            }
        }
        return next;
    }
}
