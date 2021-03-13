package com.algorithm.tree;

/**
 * 前缀树
 */
public class PreTreeDemo {
    public static class TreeNode {
        //经过当前节点的次数
        private int path;
        //以当前结果结尾的次数
        private int end;
        //该节点下，可划分的分叉
        private TreeNode[] nexts;

        public TreeNode() {
            path = 0;
            end = 0;
            //根据实际情况，当前以字母区分，说明这个节点最多有26中分叉
            nexts = new TreeNode[26];
        }
    }

    public static class Trie {
        private TreeNode root;

        public Trie() {
            root = new TreeNode();
        }

        public void insert(String word) {
            if ("".equals(word)) {
                return;
            }
            char[] chars = word.toCharArray();
            TreeNode node = root;
            int index = 0;
            for (int i = 0; i < chars.length; i++) {
                index = chars[i] - 'a';
                if (node.nexts[index] == null) {
                    node.nexts[index] = new TreeNode();
                }
                node = node.nexts[index];
                node.path++;
            }
            node.end++;
        }

        public int search(String word) {
            if ("".equals(word)) {
                return 0;
            }
            char[] chars = word.toCharArray();
            TreeNode node = root;
            int index = 0;
            for (int i = 0; i < chars.length; i++) {
                index = chars[i] - 'a';
                if (node.nexts[index] == null) {
                    return 0;
                }
                node = node.nexts[index];
            }
            return node.end;
        }

        public void delete(String word) {
            if (search(word) != 0) {
                char[] chars = word.toCharArray();
                int index = 0;
                TreeNode node = root;
                for (int i = 0; i < chars.length; i++) {
                    index = chars[i] - 'a';
                    if (--node.nexts[index].path == 0) {
                        node.nexts[index] = null;
                        return;
                    }
                    node = node.nexts[index];
                }
                node.end--;
            }
        }


        /**
         * 前缀数量
         *
         * @param pre
         * @return
         */
        public int preFixNum(String pre) {
            if (pre == null) {
                return 0;
            }
            char[] chars = pre.toCharArray();
            int index = 0;
            TreeNode node = root;
            for (int i = 0; i < chars.length; i++) {
                index = chars[i] - 'a';
                if (node.nexts[index] == null) {
                    return 0;
                }
                node = node.nexts[index];
            }
            return node.path;
        }
    }
}
