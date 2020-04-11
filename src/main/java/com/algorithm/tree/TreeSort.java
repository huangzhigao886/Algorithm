package com.algorithm.tree;

import java.util.ArrayList;
import java.util.List;

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
     * 中序遍历
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
     * 后序遍历
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


    class Node {
        int value;
        Node right;
        Node left;
    }
}
