package com.algorithm.string;

/**
 * @Auther: huangzhigao
 * @Date: 2021/3/4
 * @Description: 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 最长前缀，代表先从首位开始比较
 */
public class Leecode14 {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0)return "";
        //公共前缀比所有字符串都短，随便选一个先
        String s=strs[0];
        for (String string : strs) {
            while(!string.startsWith(s)){
                if(s.length()==0)return "";
                //公共前缀不匹配就让它变短！
                s=s.substring(0,s.length()-1);
            }
        }
        return s;
    }

    public static void main(String[] args) {
        String[] str = {"", ""};
        Leecode14 leecode14 = new Leecode14();
        System.out.println(leecode14.longestCommonPrefix(str));
    }
}
