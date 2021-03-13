package com.algorithm.string;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 贪心策略
 * 给定一组字符串，将它们拼接，使之成为最小的拼接字符串
 * 如： b, ba   结果为bab  而不是bba
 */
public class LowestStringDemo {
    public class MyComparator implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            return (o1 + o2).compareTo(o2 + o1);
        }
    }


    /**
     *
     * @param strings
     * @return
     */
    public String getResult(String[] strings) {
        if (strings.length < 1) {
            return "";
        }
        if (strings.length == 1) {
            return strings[0];
        }
        Arrays.sort(strings, new MyComparator());
        String res = "";
        for (String s : strings) {
            res = res + s;
        }
        return res;
    }
}
