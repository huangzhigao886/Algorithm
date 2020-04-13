package com.algorithm;

import com.algorithm.graphtheory.adj.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 拓扑排序，可以用以检测是否有环
 *
 * @Author: huangzhigao
 * @Date: 2020/4/12 21:37
 */
public class TopoSort {

    private Graph graph;

    private boolean hasCycle;

    private ArrayList<Integer> res;


    //所有节点的入度
    private int[] inDegree;

    public TopoSort(Graph graph) {
        this.graph = graph;
        inDegree = new int[graph.getV()];
        res = new ArrayList<>();
        Queue<Integer> queue = new LinkedList();
        for (int v = 0; v < graph.getV(); v++) {
            inDegree[v] = graph.getInDegree(v);
            if (inDegree[v] == 0) {
                queue.add(v);
            }
        }

        //将入度为0的删除，然后它所指向的顶点的入度-1
        while (!res.isEmpty()) {
            Integer cur = queue.remove();
            res.add(cur);
            for (int next : graph.adj(cur)) {
                inDegree[next]--;
                if (inDegree[next] == 0) {
                    queue.add(next);
                }
            }
        }

        if (res.size() != graph.getV()) {
            hasCycle = true;
        }
    }

}
