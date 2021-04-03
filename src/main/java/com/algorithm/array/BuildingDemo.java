package com.algorithm.array;

import sun.reflect.generics.tree.Tree;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;

/**
 * 画大楼的轮廓
 */
public class BuildingDemo {
    public static class Node {
        //是否向上
        private boolean isUp;
        //坐标位置
        private int position;
        //高度
        private int h;

        public Node(boolean isUp, int position, int h) {
            this.isUp = isUp;
            this.position = position;
            this.h = h;
        }
    }

    public static class NodeComparator implements Comparator<Node> {

        @Override
        public int compare(Node o1, Node o2) {
            if (o1.position != o2.position) {
                return o1.position - o2.position;
            }
            if (o1.isUp != o2.isUp) {
                return o1.isUp ? -1 : 1;
            }
            return 0;
        }
    }

    public void buildLine(int[][] arr) {
        Node[] nodes = new Node[arr.length * 2];
        for (int i = 0; i < arr.length; i++) {
            nodes[i * 2] = new Node(true, arr[i][0], arr[i][2]);
            nodes[i * 2 + 1] = new Node(false, arr[i][1], arr[i][2]);
        }

        Arrays.sort(nodes, new NodeComparator());
        TreeMap<Integer, Integer> htMap = new TreeMap<>();
        TreeMap<Integer, Integer> pmMap = new TreeMap<>();
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i].isUp) {
                if (!htMap.containsKey(nodes[i].h)) {
                    htMap.put(nodes[i].h, 1);
                } else {
                    htMap.put(nodes[i].h, htMap.get(nodes[i].h) + 1);
                }
            } else {
                if (htMap.containsKey(nodes[i].h)) {
                    if (htMap.get(nodes[i].h) == 1) {
                        htMap.remove(nodes[i].h);
                    } else {
                        htMap.put(nodes[i].h, htMap.get(nodes[i].h) - 1);
                    }
                }
                if (htMap.isEmpty()) {
                    pmMap.put(nodes[i].position, 0);
                } else {
                    pmMap.put(nodes[i].position, htMap.lastKey());
                }
            }
        }
    }
}
