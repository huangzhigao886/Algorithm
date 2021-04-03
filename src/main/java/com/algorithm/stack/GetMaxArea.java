package com.algorithm.stack;


import java.util.HashMap;
import java.util.Stack;

public class GetMaxArea {

    public int maxRecSize(int[][] arr) {
        if (arr.length == 1 || arr[0].length == 0) {
            return 0;
        }
        int maxArea = 0;
        int[] help = new int[arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                help[j] = arr[i][j] == 0 ? 0 : help[j] + 1;
            }
            maxArea = Math.max(getRecFromBottom(help), maxArea);
        }
        return maxArea;
    }



    private class ListNode{
        private int val;
        ListNode next;

    }

    public boolean is(ListNode head){
        if(head == null){
            return true;
        }


        HashMap<ListNode,Integer> listNodeHashMap = new HashMap();
        while (head!=null){
            if(listNodeHashMap.containsKey(head)){
               return false;
            }
            listNodeHashMap.put(head,1);
            head = head.next;
        }
        return true;
    }

    public int getRecFromBottom(int[] arr) {
        if (arr.length < 1) {
            return 0;
        }
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                int j = stack.pop();
                int k = stack.isEmpty() ? -1 : stack.peek();
                int curArea = arr[j] * (i - k - 1);
                maxArea = Math.max(curArea, maxArea);
            }
            stack.add(i);
        }

        while (!stack.isEmpty()) {
            int j = stack.pop();
            int k = stack.isEmpty() ? -1 : stack.peek();
            int curArea = arr[j] * (arr.length - k - 1);
            maxArea = Math.max(curArea, maxArea);
        }
        return maxArea;
    }
}
