package com.algorithm.string;

import java.util.Stack;

/**
 * @Auther: huangzhigao
 * @Date: 2021/3/4
 * @Description: 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * <p>
 * 思路讲解，
 * 使用栈，左括号代表入栈，右括号代表出栈
 * 如果要出栈，出栈的元素要与当前元素匹配
 * 最终栈要为空
 * <p>
 * "{[]}" true
 * "([)]" false
 */
public class Leecode20 {
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();

        if (chars.length % 2 != 0) {
            //如果不是偶数，一定是无效的
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            if ('(' == chars[i]) {
                stack.push(')');
            } else if ('{' == chars[i]) {
                stack.push('}');
            } else if ('[' == chars[i]) {
                stack.push(']');
            } else if (stack.isEmpty() || chars[i] != stack.pop()) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Leecode20 leecode20 = new Leecode20();
        leecode20.isValid("()");
    }
}
