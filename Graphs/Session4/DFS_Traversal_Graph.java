package Graphs.Session4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DFS_Traversal_Graph {
    public static void main(String[] args) {
        int v = 8;
        int e = 7;
        int[][] edges = {
                { 1, 2 }, { 1, 3 }, { 2, 4 },
                { 2, 5 }, { 3, 6 }, { 3, 7 },
                { 5, 8 } };
        List<Integer> path = dfsTraversalPath(edges, v, e);
        System.out.println(path);
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
    private static List<Integer> dfsTraversalPath(int[][] edges, int n, int e) {
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
        List<Integer> path = new ArrayList<Integer>();
        int[] visited = new int[n + 1];
        visited[0] = 1; // 1 based nodes
        dfsGraph(graph, 1, visited, path);
        return path;
    }

    private static void dfsGraph(HashMap<Integer, ArrayList<Integer>> graph,
            int u, int[] visited, List<Integer> path) {
        visited[u] = 1;
        path.add(u);
        for (Integer v : graph.get(u)) { // TC: O(V)
            if (visited[v] == 0) {
                dfsGraph(graph, v, visited, path); // TC: O(E)
            }
        }
    }
}
