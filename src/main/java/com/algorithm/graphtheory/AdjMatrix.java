package com.algorithm.graphtheory;

import lombok.Data;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 邻接矩阵,无向图
 *
 * @Author: huangzhigao
 * @Date: 2020/4/9 22:02
 */
@Data
public class AdjMatrix {
    /**
     * 顶点
     */
    private int V;

    /**
     * 边
     */
    private int E;

    /**
     * 二维矩阵
     */
    private int[][] adj;

    public AdjMatrix(String fileName) {
        File file = new File(fileName);
        try {
            Scanner scanner = new Scanner(file);
            //第一个元素为顶点数
            V = scanner.nextInt();
            if (V < 0) {
                //顶点数量不能为负数
                throw new IllegalArgumentException("V must be non-negative");
            }
            adj = new int[V][V];
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
                if (adj[a][b] == 1) {
                    //平行边
                    throw new IllegalArgumentException("Parallel Edges is Detected");
                }
                //因为是无向图，因此既有a->b 也有b->a
                adj[a][b] = 1;
                adj[b][a] = 1;
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
        return adj[v][w] == 1;
    }

    /**
     * 返回指向V的顶点
     *
     * @param v
     * @return
     */
    public List adj(int v) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        validateVertex(v);
        for (int i = 0; i < V; i++) {
            if (adj[v][i] == 1) {
                list.add(i);
            }
        }
        return list;
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
        for (int i = 0; i < adj.length; i++) {
            for (int j = 0; j < adj[i].length; j++) {
                sb.append(String.format("%d ", adj[i][j]));
            }
            sb.append('\n');
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        AdjMatrix adjMatrix = new AdjMatrix("g.txt");
        System.out.println(adjMatrix.toString());
    }
}
