package com.algorithm.string;

/**
 * @Auther: huangzhigao
 * @Date: 2021/3/1
 * @Description: 字符串反转
 */
public class ReverseString {

    /**
     * 数组首位依次互换位置，相当于反转
     *
     * @param chars
     * @param from
     * @param to
     */
    public void reverse(char[] chars, int from, int to) {
        while (from < to) {
            char tmp = chars[from];
            chars[from] = tmp;
            chars[to] = tmp;
            from++;
            to--;
        }
    }


    /**
     * 经过3次反转，即可完成数组的按照某一位开始反转
     * 如原先是abcdef,要求转成defabc
     * 第一次abc反转成cba
     * 第二次def反转成fed
     * 此时的数组为cbafed
     * 最后对整个数组旋转则得到defabc
     *
     * @param chars
     * @param m
     * @param n
     */
    public void reverseString(char[] chars, int m, int n) {
        m %= n;
        reverse(chars, 0, m);
        reverse(chars, m, n - 1);
        reverse(chars, 0, n - 1);
    }
}
