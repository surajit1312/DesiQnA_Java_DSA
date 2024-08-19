package Graphs.Session2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Shortest_Distance_To_All_Nodes_From_Source_Node {
    public static void main(String[] args) {
        int v = 5;
        int e = 3;
        int[][] edges = { { 1, 2 }, { 3, 2 }, { 3, 4 } };
        int source = 1;
        int[] minDist = getShortestDistanceGraph(edges, v, e, source);
        System.out.println(Arrays.toString(minDist));
    }

    /**
     * Using BFS
     * 
     * TC: O(2V + 2E) ~ O(V + E)
     * SC: O(V + E)
     * 
     * @param edges
     * @param v
     * @param e
     * @return
     */
    private static int[] getShortestDistanceGraph(int[][] edges, int n, int e, int source) {
        // Creating adjacency list
        int[] minDist = new int[n];
        Arrays.fill(minDist, -1);
        // SC: O(V + E)
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<Integer, ArrayList<Integer>>();
        for (int i = 1; i <= n; i++) { // TC: O(V)
            graph.put(i, new ArrayList<Integer>());
        }
        for (int i = 0; i < e; i++) { // TC: O(E)
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }
        // BFS
        Queue<Pair> queue = new LinkedList<Pair>();
        // To track all visited nodes
        int[] visited = new int[n + 1];
        visited[0] = 1; // as nodes starts from 1 and not 0
        queue.offer(new Pair(source, 0));
        visited[source] = 1;
        while (!queue.isEmpty()) { // TC: O(V)
            Pair current = queue.poll();
            int u = current.node;
            int level = current.level;
            minDist[u - 1] = level;
            for (Integer v : graph.getOrDefault(u, new ArrayList<Integer>())) { // TC: O(E)
                if (visited[v] == 0) {
                    queue.offer(new Pair(v, level + 1));
                    visited[v] = 1;
                }
            }
        }
        return minDist;
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
