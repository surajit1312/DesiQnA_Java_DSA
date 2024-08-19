package Graphs.Session3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Count_Of_Shortest_Distance_To_All_Nodes_From_Source_Node {
    public static void main(String[] args) {
        int v = 8;
        int e = 10;
        int[][] edges = {
                { 1, 2 }, { 1, 3 }, { 2, 4 },
                { 2, 5 }, { 3, 6 }, { 3, 7 },
                { 5, 8 }, { 5, 4 }, { 6, 7 }, { 1, 5 } };
        int source = 1;
        int[][] numWays = getNumberOfShortestDistanceGraph(edges, v, e, source);
        System.out.println(Arrays.deepToString(numWays));
    }

    /**
     * Using BFS
     * 
     * TC: O(3V + 2E) ~ O(V + E)
     * SC: O(V + E)
     * 
     * @param edges
     * @param v
     * @param e
     * @return
     */
    private static int[][] getNumberOfShortestDistanceGraph(int[][] edges, int n, int e, int source) {
        int[] level = new int[n + 1];
        Arrays.fill(level, -1);
        level[0] = 0;
        int[] ways = new int[n + 1];
        ways[0] = 0;
        // Creating adjacency list
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
        Queue<Integer> queue = new LinkedList<Integer>();
        // To track all visited nodes
        int[] visited = new int[n + 1];
        visited[0] = 1; // as nodes starts from 1 and not 0
        queue.offer(source);
        level[source] = 0;
        visited[source] = 1;
        ways[source] = 1;
        while (!queue.isEmpty()) { // TC: O(V)
            int u = queue.poll();
            for (Integer v : graph.getOrDefault(u, new ArrayList<Integer>())) { // TC: O(E)
                if (visited[v] == 0) {
                    queue.offer(v);
                    visited[v] = 1;
                    level[v] = level[u] + 1;
                    ways[v] = ways[v] + ways[u];
                } else {
                    if (level[u] + 1 == level[v]) {
                        ways[v] = ways[v] + ways[u];
                    }
                }
            }
        }
        int[][] numWays = new int[n][1];
        for (int i = 1; i <= n; i++) { // TC: O(V)
            numWays[i - 1] = new int[] { i, ways[i] };
        }
        return numWays;
    }
}
