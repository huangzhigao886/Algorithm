package com.algorithm.linkTable;


/**
 * @Auther: huangzhigao
 * @Date: 2021/3/4
 * @Description:合并两个有序链表
 */
public class Leecode21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;

        }
        ListNode res = l1.val > l2.val ? l2 : l1;
        if (l1.val > l2.val) {
            l2 = l2.next;
        } else {
            l1 = l1.next;
        }
        res.next = mergeTwoLists(l1, l2);
        return res;
    }

    //非递归版本
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;

        }
        ListNode listNode = new ListNode(0);
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                listNode.next = l2;
                l2 = l2.next;
            } else {
                listNode.next = l1;
                l1 = l1.next;
            }
        }
        while (l1 != null) {
            listNode.next = l1;
            l1 = l1.next;
        }

        while (l2 != null) {
            listNode.next = l2;
            l2 = l2.next;
        }
        return listNode.next;
    }
}
