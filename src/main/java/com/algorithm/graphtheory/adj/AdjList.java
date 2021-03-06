package com.algorithm.graphtheory.adj;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 邻接表,每个顶点后面都跟着链表
 * 0:1,2
 * 1:2,3
 * 3:1
 *
 * @Author: huangzhigao
 * @Date: 2020/4/9 22:50
 */
public class AdjList {

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
    private LinkedList<Integer>[] adj;

    public AdjList(String fileName) {
        File file = new File(fileName);
        try {
            Scanner scanner = new Scanner(file);
            //第一个元素为顶点数
            V = scanner.nextInt();
            if (V < 0) {
                //顶点数量不能为负数
                throw new IllegalArgumentException("V must be non-negative");
            }
            adj = new LinkedList[V];
            for (int i = 0; i < V; i++) {
                //初始化每个链表
                adj[i] = new LinkedList<Integer>();
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
                adj[b].add(a);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
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
     * 返回与V相邻的顶点
     *
     * @param v
     * @return
     */
    public LinkedList<Integer> adj(int v) {
        validateVertex(v);
        return adj[v];
    }

    /**
     * 返回顶点的度
     *
     * @return
     */
    public int getDegree(int v) {
        return adj(v).size();
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
        AdjList adjMatrix = new AdjList("g.txt");
        System.out.println(adjMatrix.toString());
    }
}
