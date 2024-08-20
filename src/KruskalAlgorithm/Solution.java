package KruskalAlgorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    /**
     * Builds a Minimum Spanning Tree (MST) using
     * Kruskal's Algorithm (as learned in class).
     * Nodes are numbered from 0 to n - 1.
     *
     * @param n the amount of nodes in the graph
     * @param edges the edges that comprise the graph
     * @return the list of edges that should be included in the MST
     */
    public static List<Edge> buildMST(int n, List<Edge> edges) {
        List<Edge> result = new ArrayList<>();
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        UnionFind union = new UnionFind(n);

        for (Edge edge : edges) {
            pq.add(edge);
        }

        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            if (union.union(current.getFrom(), current.getTo())) {
                result.add(current);
            }
        }

        return result;
    }
}
