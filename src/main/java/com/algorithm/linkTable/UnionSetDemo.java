package com.algorithm.linkTable;

import org.omg.CORBA.PRIVATE_MEMBER;

import java.util.HashMap;
import java.util.List;

/**
 * 并差集
 */
public class UnionSetDemo {
    class Node {

    }

    public static class UnionSetDemoTest {
        public HashMap<Node, Node> fatherMap;
        public HashMap<Node, Integer> sizeMap;

        public UnionSetDemoTest() {

        }

        private void makeSets(List<Node> nodes) {
            fatherMap = new HashMap<>();
            sizeMap = new HashMap<>();
            for (Node node : nodes) {
                fatherMap.put(node, node);
                sizeMap.put(node, 1);
            }
        }

        private Node findHead(Node node) {
            Node head = fatherMap.get(node);
            if (head != node) {
                head = findHead(head);
            }
            fatherMap.put(node, head);
            return head;
        }

        private Boolean isSameSet(Node A, Node B) {
            return findHead(A) == findHead(B);
        }

        public void union(Node A, Node B) {
            if (A == null || B == null) {
                return;
            }
            Node aHead = findHead(A);
            Node bHead = findHead(B);
            if (aHead != bHead) {
                int aSize = sizeMap.get(aHead);
                int bSize = sizeMap.get(bHead);
                if (aSize <= bSize) {
                    fatherMap.put(aHead, bHead);
                    sizeMap.put(bHead, aSize + bSize);
                } else {
                    fatherMap.put(bHead, aHead);
                    sizeMap.put(aHead, aSize + bSize);
                }
            }
        }
    }
}
