package org.example.leetcode_stack;

import java.util.Stack;

/**
 * @author fengwang219475
 * @version 1.0
 * @project leetcode_code
 * @description
 * @date 2023/11/13 22:33:06
 */
public class Leetcode_stack_20 {
    
    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
     *
     * 有效字符串需满足：
     *
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 每个右括号都有一个对应的相同类型的左括号。
     */

    public static void main(String[] args) {
        System.out.println(isValid("(dssaw)[dsa]da{asd}"));
    }

    public static boolean isValid(String s) {
        if (s == null || s.isEmpty()) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Character pop = null;
            switch (c){
                case '(' :
                    stack.push(c);
                    break;
                case ')' :
                    if (stack.isEmpty()) {
                        return false;
                    }
                    pop = stack.pop();
                    if (pop != '(') {
                        return false;
                    }
                    break;
                case '{' :
                    stack.push(c);
                    break;
                case '}' :
                    if (stack.isEmpty()) {
                        return false;
                    }
                    pop = stack.pop();
                    if (pop != '{') {
                        return false;
                    }
                    break;
                case '[' :
                    stack.push(c);
                    break;
                case ']' :
                    if (stack.isEmpty()) {
                        return false;
                    }
                    pop = stack.pop();
                    if (pop != '[') {
                        return false;
                    }
                    break;
            }
        }
        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }
}
