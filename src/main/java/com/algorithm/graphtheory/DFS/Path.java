package com.algorithm.graphtheory.DFS;

import com.algorithm.graphtheory.adj.Graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 找到某两个节点的路径
 *
 * @Author: huangzhigao
 * @Date: 2020/4/11 15:19
 */
public class Path {
    private Graph graph;
    //初始化一个数组，代表每个节点都没被访问过
    private boolean[] visited;

    //顶点v
    private int v;

    //顶点t
    private int t;

    private int[] pre;


    public Path(Graph graph, int v, int t) {
        this.graph = graph;
        this.v = v;
        this.t = t;
        pre = new int[graph.getV()];
        for (int i = 0; i < pre.length; i++) {
            pre[i] = -1;
        }
        visited = new boolean[graph.getV()];
        dfs(v, v);

    }

    /**
     * @param v      某一个顶点
     * @param parent v的上一个节点
     */
    public boolean dfs(int v, int parent) {
        //当遍历到该节点，说明该节点已经被遍历
        visited[v] = true;
        //v节点的上一个节点为parent;
        pre[v] = parent;

        if (v == t) {
            //说明找到了v与t的路径
            return true;
        }

        //遍历所有与该节点有关的所有节点
        for (int w : graph.adj(v)) {
            //如果这个节点没有被遍历过，这遍历它下的所有节点
            if (!visited[w]) {
                if (dfs(w, v)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 是否从V可达w
     *

     * @return
     */
    public boolean isConnected() {
        //如果visit[w]==false说明没有访问到，即不可达
        return visited[t];
    }

    /**
     * 获取v到t的所有路径
     *
     * @return
     */
    public List<Integer> path() {
        List<Integer> res = new ArrayList<Integer>();
        if (!isConnected()) {
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
        Graph graph = new Graph("dfs.txt");
        Path graphDfs = new Path(graph, 0,6);
        System.out.println(graphDfs.path());
    }
}
