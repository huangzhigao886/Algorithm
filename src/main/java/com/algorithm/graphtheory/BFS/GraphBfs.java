package com.algorithm.graphtheory.BFS;

import com.algorithm.graphtheory.adj.Graph;
import lombok.Data;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 图的广度优先遍历
 *
 * @Author: huangzhigao
 * @Date: 2020/4/11 16:30
 */
@Data
public class GraphBfs {

    private Graph graph;

    private boolean[] visited;

    private List<Integer> order = new ArrayList<>();


    public GraphBfs(Graph graph) {
        this.graph = graph;
        visited = new boolean[graph.getV()];

        for (int v = 0; v < visited.length; v++) {
            if (!visited[v]) {
                bfs(v);
            }
        }

    }

    /**
     * 广度优先遍历
     *
     * @param v
     */
    public void bfs(int v) {
        visited[v] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        while (!queue.isEmpty()) {
            Integer remove = queue.remove();
            order.add(remove);
            //将remove出来的节点相关联的节点都添加进队列
            for (int w : graph.adj(remove)) {
                if (!visited[w]) {
                    //已经访问过的不添加进来
                    queue.add(w);
                    visited[w] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph("dfs.txt");
        GraphBfs graphBfs = new GraphBfs(graph);
        System.out.println(graphBfs.getOrder());
    }


}
