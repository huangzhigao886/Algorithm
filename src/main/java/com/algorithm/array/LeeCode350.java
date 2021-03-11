package com.algorithm.array;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Auther: huangzhigao
 * @Date: 2021/3/5
 * @Description:
 */
public class LeeCode350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new LinkedList<>();
        for(int n:nums1){
          list.add(n);
        }
        List<Integer> list2 = new LinkedList<>();
        for(int n:nums2){
            if(list.contains(n)){
                list2.add(n);
                list.remove(Integer.valueOf(n));
            }
        }
        int[] res = new int[list2.size()];
        for(int i =0;i<list2.size();i++){
            res[i] = list2.get(i);
        }
        return res;
    }
}
