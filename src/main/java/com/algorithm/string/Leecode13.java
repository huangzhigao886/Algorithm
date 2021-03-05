package com.algorithm.string;

import java.util.HashMap;

/**
 * @Auther: huangzhigao
 * @Date: 2021/3/4
 * @Description: 罗马数字转整数
 * 如果当前字符代表的值不小于其右边，就加上该值；否则就减去该值。以此类推到最左边的数，最终得到的结果即是答案
 */
public class Leecode13 {
    public int romanToInt(String s) {
        HashMap<Character, Integer> maps = new HashMap<>();
        maps.put('I', 1);
        maps.put('V', 5);
        maps.put('X', 10);
        maps.put('L', 50);
        maps.put('C', 100);
        maps.put('D', 500);
        maps.put('M', 1000);
        maps.put('0', 0);
        char[] chars = s.toCharArray();
        int res = 0;
        for (int i = 0; i < chars.length - 1; i++) {
            if (maps.get(chars[i]) < maps.get(chars[i + 1])) {
                res = res - maps.get(chars[i]);
            } else {
                res = res + maps.get(chars[i]);
            }
        }
        return res + maps.get(chars[chars.length - 1]);
    }

    public static void main(String[] args) {
        String str = "III";
        Leecode13 leecode13 = new Leecode13();
        System.out.println(leecode13.romanToInt(str));
    }
}
