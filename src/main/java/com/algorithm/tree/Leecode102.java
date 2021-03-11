package com.algorithm.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Auther: huangzhigao
 * @Date: 2021/3/9
 * @Description:
 */
public class Leecode102 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }


    }

    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            if (root == null) {
                return null;
            }
            List<List<Integer>> res = new ArrayList<>();
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.add(root);

            while (!queue.isEmpty()) {
                List<Integer> tmpRes = new ArrayList<>();
                int size = queue.size();
                while (size > 0) {
                    TreeNode node = queue.poll();
                    tmpRes.add(node.val);
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                    size--;
                }
                res.add(tmpRes);

            }
            return res;


        }


    }
}
