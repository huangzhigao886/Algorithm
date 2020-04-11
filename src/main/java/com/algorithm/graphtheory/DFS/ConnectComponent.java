package com.algorithm.graphtheory.DFS;

import com.algorithm.graphtheory.adj.Graph;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 联通分量
 *
 * @Author: huangzhigao
 * @Date: 2020/4/11 14:53
 */
@Data
public class ConnectComponent {
    private Graph graph;
    //初始化一个数组，代表每个节点都没被访问过
    private int[] visited;

    //联通分量个数
    private int count;

    public ConnectComponent(Graph graph) {
        this.graph = graph;
        visited = new int[graph.getV()];
        for (int i = 0; i < graph.getV(); i++) {
            //初始化 -1代表该节点没有被访问过
            visited[i] = -1;
        }
        //因为会出现连通图的情况，即有一个顶点是跟其他顶点都没关系的顶点
        for (int i = 0; i < graph.getV(); i++) {
            //如果当前节点被访问过就不再访问
            if (visited[i] == -1) {
                //count代表每个联通分量的唯一ID;
                dfs(i, count++);

            }
        }
    }

    /**
     * 深度优先遍历核心 可以认为是先序，如果就res.add(V)放在for执行完后，则变成图的深度优先遍历的后序遍历
     *
     * @param v    某一个顶点
     * @param ccId 联通分量唯一ID
     */
    public void dfs(int v, int ccId) {
        //当遍历到该节点，说明该节点已经被遍历
        visited[v] = ccId;

        //遍历所有与该节点有关的所有节点
        for (int w : graph.adj(v)) {
            //如果这个节点没有被遍历过，这遍历它下的所有节点
            if (visited[w] == -1) {
                dfs(w, ccId);
            }
        }
    }

    /**
     * 判断两个顶点是否联通
     *
     * @param v
     * @param w
     * @return
     */
    public boolean isConnected(int v, int w) {
        return visited[v] == visited[w];
    }

    /**
     * 获取每个联通分量所对应的节点
     *
     * @return
     */
    public List<Integer>[] getComponents() {
        List<Integer>[] res = new ArrayList[count];
        for (int i = 0; i < count; i++) {
            res[i] = new ArrayList<Integer>();
        }
        //将visitId相同的节点归为一组
        for (int i = 0; i < graph.getV(); i++) {
            res[visited[i]].add(i);
        }
        return res;
    }

    public static void main(String[] args) {
        Graph graph = new Graph("dfs.txt");
        ConnectComponent graphDfs = new ConnectComponent(graph);
        int[] visited = graphDfs.getVisited();
        for (int i = 0; i < visited.length; i++) {
            System.out.println(visited[i]);
        }
    }
}
