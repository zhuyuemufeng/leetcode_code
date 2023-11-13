package org.example.leetcode_string;

public class Leetcode_string_541 {

    /*
    给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。
    如果剩余字符少于 k 个，则将剩余字符全部反转。
    如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
     */

    public static void main(String[] args) {
        System.out.println(reverseStr("abcdefg", 4));
    }

    public static String reverseStr(String s, int k) {
        char[] array = s.toCharArray();
        int k2 = 2 * k;
        int left = 0;
        int right = 0;
        while (left < array.length) {
            int addNum = 0;
            int perod = array.length - left;
            if (perod >= k2) {
                right = left + k;
                addNum = k2;
            } else if (k <= perod && perod < k2) {
                right = left + k;
                addNum = perod;
            } else {
                right = array.length;
                addNum = perod;
            }
            int index_left = left;
            int index_right = right - 1;
            while (index_left < index_right) {
                char leftValue = array[index_left];
                array[index_left] = array[index_right];
                array[index_right] = leftValue;
                index_left ++;
                index_right --;
            }
            left += addNum;
        }
        return new String(array);
    }
}
