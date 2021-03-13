package com.algorithm.tree;


import java.util.LinkedList;
import java.util.Queue;

/**
 * 判断一棵树是否是平衡二叉树
 * <p>
 * 分为四部 ，以一个节点为例
 * 1；如果它的左子树是否平衡
 * 2：它的右子树是否平衡
 * 3：它的左边高度
 * 4 它的右子树高度
 */
public class TreeDemo1 {
    public static class Node {
        private int value;
        private Node left;
        private Node right;
    }

    public static class ReturnData {
        private boolean isBalance;
        private int height;

        public ReturnData(boolean isBalance, int height) {
            this.isBalance = isBalance;
            this.height = height;
        }
    }

    /**
     * 是否平衡二叉树
     *
     * @param head
     * @return
     */
    public Boolean isBalanceTree(Node head) {
        return process(head).isBalance;
    }

    public ReturnData process(Node head) {
        if (head == null) {
            //如果为空，则是平衡树
            return new ReturnData(true, 0);
        }
        //返回该节点左边的高度以及是否是平衡树
        ReturnData left = process(head.left);
        if (!left.isBalance) {
            return new ReturnData(false, 0);
        }
        //返回该节点左右边的高度以及是否是平衡树
        ReturnData right = process(head.right);
        if (!right.isBalance) {
            return new ReturnData(false, 0);
        }
        if (Math.abs(left.height - right.height) < 2) {
            //如果是平衡树，返回该节点的高度，高度为左右子树中最大的一个，并加上自己
            return new ReturnData(true, Math.max(left.height, right.height) + 1);
        } else {
            return new ReturnData(false, 0);
        }
    }


    public void isTree(Node head) {
        if (head == null) {

        }

        Queue queue = new LinkedList<Node>();
        queue.offer(head);
        Node left = null;
        Node right = null;
        while (head != null) {
            Node poll = (Node) queue.poll();
            if (poll.left != null) {
                queue.offer(poll.left);
            }
            if (poll.right != null) {
                queue.offer(poll.right);
            }
        }
    }


    /**
     * 是否是完全二叉树
     * 3中条件
     * 1如果右子树有值左子树没有，不是
     * 2如果是叶子节点，右不为空，或者左不为空
     *
     * @param head
     * @return
     */
    public boolean isCBT(Node head) {
        if (head == null) {
            return true;
        }
        boolean leaf = false;
        Node left = null;
        Node right = null;
        LinkedList<Node> queue = new LinkedList<Node>();
        queue.offer(head);
        while (head != null) {
            head = queue.poll();
            left = head.left;
            right = head.right;
            if ((left == null && right != null) || (leaf && (left != null || right != null))) {
                return false;
            }



            if (left != null) {
                queue.offer(left);
            }
            if (right != null) {
                queue.offer(right);
            }
            //如果左右开始为空，则后面的节点都是叶子节点
            if (left == null || right == null) {
                leaf = true;
            }

        }
        return true;
    }
}
