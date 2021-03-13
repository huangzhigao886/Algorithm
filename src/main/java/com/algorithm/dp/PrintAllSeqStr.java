package com.algorithm.dp;

/**
 * 打印所有子序列
 * 思路：从字符串头开始，进行打印，可以选择要这个字符，或者不要这个字符
 */
public class PrintAllSeqStr {

    public void printAllSeq(char[] chars, int i, String res) {
        if (i == chars.length) {
            System.out.println(res);
            return;
        }
        //当前步骤不要这个字符
        printAllSeq(chars, i + 1, res);
        //当前步骤需要这个字符
        printAllSeq(chars, i + 1, res + chars[i]);
    }


    public boolean printAim(int[] arr, int i, int sum, int aim) {
        if (i == arr.length) {
            return sum == aim;
        }
        return printAim(arr, i + 1, sum, aim) || printAim(arr, i + 1, sum + arr[i], aim);
    }

}
