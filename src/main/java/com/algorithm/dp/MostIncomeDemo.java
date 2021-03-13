package com.algorithm.dp;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MostIncomeDemo {
    public static class Node {
        //收益
        private int price;
        //花费
        private int cost;

        public Node(int price, int cost) {
            this.price = price;
            this.cost = cost;
        }
    }

    public static class LowComparator implements Comparator<Node> {

        @Override
        public int compare(Node o1, Node o2) {
            return o1.cost - o2.cost;
        }
    }

    public static class HighComparator implements Comparator<Node> {

        @Override
        public int compare(Node o1, Node o2) {
            return o2.price - o1.price;
        }
    }


    public int getMostIncome(int[] cost, int[] income, int k, int money) {
        PriorityQueue<Node> lowQueue = new PriorityQueue(new LowComparator());
        PriorityQueue<Node> highQueue = new PriorityQueue(new HighComparator());

        Node[] nodes = new Node[cost.length];
        for (int i = 0; i < cost.length; i++) {
            nodes[i] = new Node(cost[i], income[i]);
        }
        for (int i = 0; i < nodes.length; i++) {
            lowQueue.add(nodes[i]);
        }


        for (int i = 0; i < k; i++) {
            while (!lowQueue.isEmpty() && money >= lowQueue.peek().cost) {
                highQueue.add(lowQueue.poll());
            }
            if (highQueue.isEmpty()) {
                return money;
            }
            money = money + highQueue.peek().price;
        }
        return money;
    }
}
