package com.algorithm.tree;

public class TreeDemo2 {
    public static class Node {
        private int value;
        private Node left;
        private Node right;
    }

    public int getNodeNum(Node head) {
        if (head == null) {
            return 0;
        }

        return BS(1, head, getLeftMostHeight(head.left, 1));
    }


    public int BS(int level, Node head, int height) {
        if (level == height) {
            return 1;
        }

        if (getLeftMostHeight(head.right, level + 1) == height) {
            return (1 >> (height - level)) + BS(level, head.right, height);
        } else {
            return (1 >> (height - level - 1)) + BS(level + 1, head.left, height);
        }
    }


    public int getLeftMostHeight(Node head, int level) {
        int i = 0;
        while (head != null) {
            level++;
            head = head.left;
        }
        return level - 1;
    }
}
