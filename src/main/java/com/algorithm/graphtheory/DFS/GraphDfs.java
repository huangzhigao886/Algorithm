package com.algorithm.graphtheory;

import com.algorithm.graphtheory.adj.AdjTreeSet;
import com.algorithm.graphtheory.adj.Graph;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * 图的深度优先遍历 ,无向无权循环图
 *
 * @Author: huangzhigao
 * @Date: 2020/4/11 12:31
 */
@Data
public class GraphDfs {
    private Graph graph;
    //初始化一个数组，代表每个节点都没被访问过
    private boolean[] visited;
    //返回深度优先遍历先序的结果
    private List<Integer> pre = new ArrayList<Integer>();
    //返回深度优先遍历后序的结果
    private List<Integer> post = new ArrayList<Integer>();

    //联通分量个数
    private int count;

    public GraphDfs(Graph graph) {
        this.graph = graph;
        visited = new boolean[graph.getV()];
        //因为会出现连通图的情况，即有一个顶点是跟其他顶点都没关系的顶点
        for (int i = 0; i < graph.getV(); i++) {
            //如果当前节点被访问过就不再访问
            if (!visited[i]) {
                dfs(i);
                //可以通过这个获取当前图的联通分量个数,因为如果没有联通分量，后面的所有节点visit[i]应该都为true
                count++;
            }
        }
    }

    /**
     * 深度优先遍历核心 可以认为是先序，如果就res.add(V)放在for执行完后，则变成图的深度优先遍历的后序遍历
     *
     * @param v 某一个顶点
     */
    public void dfs(int v) {
        //当遍历到该节点，说明该节点已经被遍历
        visited[v] = true;
        //记录前序的结果
        pre.add(v);
        //遍历所有与该节点有关的所有节点
        for (int w : graph.adj(v)) {
            //如果这个节点没有被遍历过，这遍历它下的所有节点
            if (!visited[w]) {
                dfs(w);
            }
        }
        //记录后序的结果
        post.add(v);
    }

    public static void main(String[] args) {
        Graph graph = new Graph("dfs.txt");
        GraphDfs graphDfs = new GraphDfs(graph);
        System.out.println(graphDfs.getPre());
        System.out.println(graphDfs.getPost());
    }
}
