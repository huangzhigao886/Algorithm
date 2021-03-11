package com.algorithm.linkTable;

/**
 * @Auther: huangzhigao
 * @Date: 2021/3/5
 * @Description: 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 */
public class LeeCode19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        if (n == 1) {
            return head.next;
        }
        int i = 1;
        ListNode pre = null;
        ListNode l = head;
        while (head != null) {

            if (i == n) {
                pre.next = head.next;
                return l;
            } else {
                pre = head;
                head = head.next;
                i++;
            }
        }
        return l;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
