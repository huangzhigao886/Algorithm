package com.algorithm.graphtheory;

import com.algorithm.graphtheory.adj.Graph;
import lombok.Data;

/**
 * 有向图的环检测问题
 *
 * @Author: huangzhigao
 * @Date: 2020/4/11 16:02
 */
@Data
public class CycleDetectionDirected {
    private Graph graph;
    //初始化一个数组，代表每个节点都没被访问过
    private boolean[] visited;

    //是否在当前路径下
    private boolean[] onPath;
    //图中有无环
    private boolean hasCycle;

    public CycleDetectionDirected(Graph graph) {

        this.graph = graph;
        visited = new boolean[graph.getV()];
        onPath = new boolean[graph.getV()];
        //因为会出现连通图的情况，即有一个顶点是跟其他顶点都没关系的顶点
        for (int v = 0; v < graph.getV(); v++) {
            //如果当前节点被访问过就不再访问
            if (!visited[v]) {
                if (dfs(v, v)) {
                    hasCycle = true;
                    break;
                }
            }
        }
    }

    /**
     * 深度优先遍历核心
     *
     * @param v 某一个顶点
     */
    public boolean dfs(int v, int parent) {
        //当遍历到该节点，说明该节点已经被遍历
        visited[v] = true;
        //标记
        onPath[v] = true;
        //遍历所有与该节点有关的所有节点
        for (int w : graph.adj(v)) {
            //如果这个节点没有被遍历过，这遍历它下的所有节点
            if (!visited[w]) {
                if (dfs(w, v)) {
                    return true;
                }
            } else if (onPath[w]) {
                //如果与当前节点相邻的节点并不是当前节点的上一个节点，则代表有环
                return true;
            }
        }
        onPath[v] = false;

        return false;
    }

    public static void main(String[] args) {
        Graph graph = new Graph("uu.txt", true);
        CycleDetectionDirected graphDfs = new CycleDetectionDirected(graph);
        System.out.println(graph);
        System.out.println(graphDfs.isHasCycle());

//        Graph graph1 = new Graph("g.txt");
//        CycleDetection graphDfs1 = new CycleDetection(graph1);
//        System.out.println(graphDfs1.isHasCycle());
    }
}
