package com.algorithm.tree;

/**
 * 寻找一颗树上某个节点的后继节点
 * 后续代表，经过中序遍历后，该节点的下一个节点就是后继节点
 * 思路：如果一个节点有右子树，则它的后继节点为它右子树上最左的节点
 * 如果没有，判断当前节点是否为父节点的左孩子，不是则，当前节点为父，继续向上寻找
 * 直至找到当前节点为父节点的左孩子，则父节点为后继节点
 */
public class TreeDemo {
    public Node getSuccessorNode(Node node) {
        if(node == null){
            return null;
        }
        if(node.right!=null){
            return getLeftMost(node.right);
        }else{
            Node parent = node.parent;
            while(parent!=null && parent.left!=node){
                node = parent;
                parent = node.parent;
            }
            return parent;
        }
    }


    public Node getLeftMost(Node node){
        if(node == null){
            return node;
        }
        while (node.left!=null){
            node = node.left;
        }
        return node;
    }


    class Node {
        int value;
        Node right;
        Node left;
        Node parent;
    }
}
