package Graphs.Session0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Graph_Nodes_Connection {
    public static void main(String[] args) {
        int v = 5;
        int e = 4;
        int[][] edges = { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 4, 2 } };

        int[] connectionsMatrix = getNodesConnectionAdjMatrix(edges, v, e);
        System.out.println(Arrays.toString(connectionsMatrix));

        int[] connectionsAdjList = getNodesConnectionAdjList(edges, v, e);
        System.out.println(Arrays.toString(connectionsAdjList));
    }

    /**
     * Using Adjacency Matrix
     * 
     * TC: O(V x V)
     * SC: O(V x V)
     * 
     * @param edges
     * @param v
     * @param e
     * @return
     */
    private static int[] getNodesConnectionAdjMatrix(int[][] edges, int v, int e) {
        int[] connections = new int[v];
        int[][] graph = new int[v][v]; // SC: O(V x V)
        for (int i = 0; i < e; i++) {
            graph[edges[i][0]][edges[i][1]] = 1;
            graph[edges[i][1]][edges[i][0]] = 1;
        }
        for (int i = 0; i < v; i++) { // TC: O(V)
            for (int j = 0; j < v; j++) { // TC: O(V)
                if (graph[i][j] == 1) {
                    connections[i]++;
                }
            }
        }
        return connections;
    }

    /**
     * Using Adjacency List
     * 
     * TC: O(V x V)
     * SC: O(V x V)
     * 
     * @param edges
     * @param v
     * @param e
     * @return
     */
    private static int[] getNodesConnectionAdjList(int[][] edges, int v, int e) {
        int[] connections = new int[v];
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<Integer, ArrayList<Integer>>();
        for (int i = 0; i < v; i++) {
            graph.put(i, new ArrayList<Integer>());
        }
        for (int i = 0; i < e; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }
        for (int i = 0; i < v; i++) { // TC: O(V)
            connections[i] = graph.get(i).size();
        }
        return connections;
    }
}
