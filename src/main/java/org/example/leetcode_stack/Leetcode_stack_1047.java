package org.example.leetcode_stack;

import java.util.Iterator;
import java.util.Stack;

/**
 * @author fengwang219475
 * @version 1.0
 * @project leetcode_code
 * @description
 * @date 2023/11/13 22:56:23
 */
public class Leetcode_stack_1047 {
    
    /***
     * 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
     *
     * 在 S 上反复执行重复项删除操作，直到无法继续删除。
     *
     * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
     */

    public static void main(String[] args) {
        System.out.println(removeDuplicates("abbaca"));
    }

    public static String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (stack.isEmpty()) {
                stack.push(c);
                continue;
            }
            Character pop = stack.pop();
            if (c != pop) {
                stack.push(pop);
                stack.push(c);
            }
        }
        Iterator<Character> iterator = stack.iterator();
        char[] characters = new char[stack.size()];
        int index = 0;
        while (iterator.hasNext()) {
            Character next = iterator.next();
            characters[index ++] = next;
        }
        return new String(characters);
    }
}
