package com.algorithm.linkTable;

/**
 * @Auther: huangzhigao
 * @Date: 2021/3/5
 * @Description:
 */
public class Lecode160 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int Alength = getLength(headA);
        int BLength = getLength(headB);
        int index = 0;
        if (Alength > BLength) {
            while (index < Alength - BLength) {
                headA = headA.next;
                index++;
            }
        } else if (Alength < BLength) {
            while (index < BLength - Alength) {
                headB = headB.next;
                index++;
            }
        }
        while (headA != null && headB != null) {
            if (headA.val != headB.val) {
                headA = headA.next;
                headB = headB.next;
            } else {
                return headA;
            }
        }
        return null;
    }


    public int getLength(ListNode head) {
        if (head == null) {
            return 0;
        }
        int h = 0;
        while (head != null) {
            h++;
            head = head.next;
        }
        return h;
    }
}
