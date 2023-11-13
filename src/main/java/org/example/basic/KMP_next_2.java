package org.example.basic;

import java.util.Arrays;

public class KMP_next_2 {

    /**
     *   a b c d f a b c d
     * [-1,0,0,0,0,0,1,2,3]
     */

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getNext("agctagcagctagctg")));
    }

    // 动态规划
    public static int[] getNext(String s){
        if (s == null || s.length() == 0) {
            return new int[0];
        }
        int[] next = new int[s.length()];
        next[0] = 0;
        if (s.length() == 1){
            return next;
        }
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(next[i - 1]) == s.charAt(i)) {
                next[i] = next[i - 1] + 1;
            } else {
                int index = next[i -1] - 1;
                while (true) {
                    if (index <= 0) {
                        next[i] = 0;
                        break;
                    }
                    int arr_index = next[index];
                    if (s.charAt(arr_index) == s.charAt(i)) {
                        next[i] = arr_index + 1;
                        break;
                    } else{
                        index = next[arr_index] -1;
                    }
                }
            }
        }
        return next;
    }
}
