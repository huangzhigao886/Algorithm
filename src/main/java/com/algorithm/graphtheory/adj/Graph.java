package com.algorithm.graphtheory.adj;

import lombok.Data;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * 有向与无向的邻接表
 *
 * @Author: huangzhigao
 * @Date: 2020/4/11 17:15
 */
@Data
public class Graph {

    /**
     * 顶点
     */
    private int V;

    /**
     * 边
     */
    private int E;

    /**
     * 链表
     */
    private TreeSet<Integer>[] adj;

    private boolean directed;

    /**
     * 入读
     */
    private int[] inDegree;

    /**
     * 出度
     */
    private int[] outDegree;


    public Graph(String fileName, boolean directed) {
        this.directed = directed;
        File file = new File(fileName);
        try {
            Scanner scanner = new Scanner(file);
            //第一个元素为顶点数
            V = scanner.nextInt();
            if (V < 0) {
                //顶点数量不能为负数
                throw new IllegalArgumentException("V must be non-negative");
            }
            adj = new TreeSet[V];
            inDegree = new int[V];
            outDegree = new int[V];
            for (int i = 0; i < V; i++) {
                //初始化每个链表
                adj[i] = new TreeSet<Integer>();
                inDegree[i] = 0;
                outDegree[i] = 0;
            }
            //第二个元素为边数
            E = scanner.nextInt();
            if (E < 0) {
                //顶点数量不能为负数
                throw new IllegalArgumentException("E must be non-negative");
            }
            for (int i = 0; i < E; i++) {
                //将边加进二维矩阵中,a,b分别带表一条边的左右两个顶点
                int a = scanner.nextInt();
                validateVertex(a);
                int b = scanner.nextInt();
                validateVertex(b);
                if (a == b) {
                    //自身环
                    throw new IllegalArgumentException("Self Loop is Detected");
                }
                if (adj[a].contains(b)) {
                    //平行边
                    throw new IllegalArgumentException("Parallel Edges is Detected");
                }
                //因为是无向图，因此既有a->b 也有b->a
                adj[a].add(b);
                if (directed) {
                    outDegree[a]++;
                    inDegree[b]++;
                }
                if (!directed) {
                    //如果无向图需要加上
                    adj[b].add(a);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Graph(String fileName) {
        this(fileName, false);
    }

    private void validateVertex(int v) {
        if (v > V || v < 0) {
            //代表顶点根本不存在于图中
            throw new IllegalArgumentException("vertex" + v + "is invalid");
        }
    }

    //判断V和W之间是否存在边
    public boolean hasEdge(int v, int w) {
        validateVertex(v);
        validateVertex(w);
        return adj[v].contains(w);
    }

    /**
     * 返回v指向的顶点
     *
     * @param v
     * @return
     */
    public TreeSet<Integer> adj(int v) {
        validateVertex(v);
        return adj[v];
    }

    /**
     * 返回顶点的度
     *
     * @return
     */
    public int getDegree(int v) {
        validateVertex(v);
        return adj[v].size();
    }

    /**
     * 返回入读
     *
     * @param v
     * @return
     */
    public int getInDegree(int v) {
        return inDegree[v];
    }

    public void removeEdge(int v, int w) {
        adj[v].remove(w);
        if (!directed) {
            adj[w].remove(v);
        } else {
            E--;
            outDegree[v]--;
            inDegree[w]--;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("V=%d,E=%d\n", V, E));
        for (int i = 0; i < V; i++) {
            sb.append(i + ":");
            for (int w : adj[i]) {
                sb.append(String.format("%d ", w));
            }
            sb.append('\n');
        }

        return sb.toString();
    }


    public static void main(String[] args) {
        Graph graph = new Graph("ug.txt", true);
        TreeSet<Integer> adj = graph.adj(2);
        System.out.println(graph);
    }
}
