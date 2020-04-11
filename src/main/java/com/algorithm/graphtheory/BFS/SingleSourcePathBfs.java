package com.algorithm.graphtheory.BFS;

import com.algorithm.graphtheory.adj.Graph;

import java.util.*;

/**
 * 单源路径BFS的算法
 *
 * @Author: huangzhigao
 * @Date: 2020/4/11 16:43
 */
public class SingleSourcePathBfs {
    private Graph graph;

    private boolean[] visited;

    private int[] pre;

    private int v;

    public SingleSourcePathBfs(Graph graph, int v) {
        this.graph = graph;
        this.v = v;
        visited = new boolean[graph.getV()];
        pre = new int[graph.getV()];
        bfs(v, v);


    }

    /**
     * 广度优先遍历
     *
     * @param v
     */
    public void bfs(int v, int parent) {
        visited[v] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        pre[v] = parent;
        while (!queue.isEmpty()) {
            Integer remove = queue.remove();
            //将remove出来的节点相关联的节点都添加进队列
            for (int w : graph.adj(remove)) {
                if (!visited[w]) {
                    //已经访问过的不添加进来
                    queue.add(w);
                    visited[w] = true;
                    pre[w] = remove;
                }
            }
        }
    }

    public boolean isConnected(int t) {
        return visited[t];
    }

    public List<Integer> getPath(int t) {
        List<Integer> res = new ArrayList();
        if (!visited[t]) {
            return null;
        }
        int cur = t;
        //从cur节点开始从后往前找，知道当前节点为v时，说明找到v-t的路径;
        while (cur != v) {
            res.add(cur);
            //将当前节点置为它的上一个节点
            cur = pre[cur];
        }
        res.add(v);
        Collections.reverse(res);
        return res;

    }

    public static void main(String[] args) {
        Graph graph = new Graph("g2.txt");
        SingleSourcePathBfs graphBfs = new SingleSourcePathBfs(graph,0);
        System.out.println(graphBfs.getPath(5));
    }
}
