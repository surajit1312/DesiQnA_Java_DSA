package Graphs.Session1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class BFS_Traversal_Graph {
    public static void main(String[] args) {
        int v = 5;
        int e = 4;
        int[][] edges = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 4, 5 } };

        int[][] path = bfsTraversalGraph(edges, v, e);
        System.out.println(Arrays.deepToString(path));
    }

    /**
     * Using Adjacency List and Queue
     * 
     * TC: O(V + E)
     * SC: O(V + E)
     * 
     * @param edges
     * @param v
     * @param e
     * @return
     */
    private static int[][] bfsTraversalGraph(int[][] edges, int n, int e) {
        // Creating adjacency list
        int[][] path = new int[n][2];
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<Integer, ArrayList<Integer>>();
        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<Integer>());
        }
        for (int i = 0; i < e; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }
        // BFS
        Queue<Pair> queue = new LinkedList<Pair>();
        // To track all visited nodes
        int[] visited = new int[n + 1];
        visited[0] = 1; // as nodes starts from 1 and not 0
        queue.offer(new Pair(1, 0));
        visited[1] = 1;
        int count = 0;
        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            int u = current.node;
            int level = current.level;
            path[count++] = new int[] { u, level };
            for (Integer v : graph.getOrDefault(u, new ArrayList<Integer>())) {
                if (visited[v] == 0) {
                    queue.offer(new Pair(v, level + 1));
                    visited[v] = 1;
                }
            }
        }
        return path;
    }

    static class Pair {
        int node;
        int level;

        public Pair(int node, int level) {
            this.node = node;
            this.level = level;
        }
    }
}
