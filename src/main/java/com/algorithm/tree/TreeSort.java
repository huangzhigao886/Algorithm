package com.algorithm.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的遍历
 *
 * @Author: huangzhigao
 * @Date: 2020/4/11 14:33
 */
public class TreeSort {

    List<Integer> res = new ArrayList<Integer>();

    /**
     * 先序遍历
     * 先遍历该节点，然后遍历它的左节点下的所有节点，后遍历它的右节点下的所有节点
     *
     * @param node
     */
    public void preOrder(Node node) {
        if (node != null) {
            res.add(node.value);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    /**
     * 非递归先序遍历
     *
     * @param node 先将头节点进行压栈，然后弹出头节点，如果右子树不为空，压栈，左子树不为空，压栈，循环上面的步骤
     */
    public void preOrderNoDp(Node node) {
        if (node != null) {
            Stack<Node> stack = new Stack<Node>();
            stack.push(node);
            while (!stack.isEmpty()) {
                node = stack.pop();
                if (node.right != null) {
                    stack.push(node.right);
                }
                if (node.left != null) {
                    stack.push(node.left);
                }
            }
        }
    }

    /**
     * 中序遍历
     * 先打印左子树，在打印中间节点，最后打印右子树
     *
     * @param node
     */
    public void Inorder(Node node) {
        if (node != null) {
            Inorder(node.left);
            res.add(node.value);
            Inorder(node.right);
        }
    }

    /**
     * 中序非递归
     *
     * @param node 如果当前不为空，压栈，指针向左移动，如果为空，打印，并将指针向右移动
     */
    public void InOrderNoDp(Node node) {
        if (node != null) {
            Stack<Node> stack = new Stack<Node>();
            while (!stack.isEmpty() || node != null) {
                if (node != null) {
                    stack.push(node);
                    node = node.left;
                } else {
                    node = stack.pop();
                    res.add(node.value);
                    node = node.right;
                }
            }
        }
    }

    /**
     * 后序遍历
     * 先打印左子树，在打印右子树，最后打印中间节点
     *
     * @param node
     */
    public void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            res.add(node.value);
        }
    }

    /**
     * 后续遍历，先模拟一个先中后右在左的方式存到一个辅助栈，接着再从辅助站依次弹出,即可达到先左后右再中的过程
     *
     * @param node
     */
    public void postOrderNoDp(Node node) {
        Stack<Node> help = new Stack<Node>();

        if (node != null) {
            Stack<Node> stack = new Stack<Node>();
            stack.push(node);
            while (!stack.isEmpty()) {
                node = stack.pop();
                help.push(node);
                if (node.left != null) {
                    stack.push(node.left);
                }
                if (node.right != null) {
                    stack.push(node.right);
                }
            }
        }
        while (!help.isEmpty()) {
            res.add(help.pop().value);
        }
    }


    class Node {
        int value;
        Node right;
        Node left;
    }
}
