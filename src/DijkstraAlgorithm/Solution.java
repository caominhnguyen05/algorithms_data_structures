package DijkstraAlgorithm;
import java.util.*;

public class Solution {
    /**
     * Returns the list of vertices along the shortest path between vertex a and b in graph g.
     *
     * @param g
     *     Graph to consider.
     * @param a
     *     Vertex to start from.
     * @param b
     *     Vertex to go to.
     * @return The list of vertices along the shortest path between a and b, or null if no such path exists.
     */
    public static List<Vertex> shortestPath(Graph g, Vertex a, Vertex b) {
        if (a == b) {
            return List.of(a);
        }
        Collection<Vertex> vertices = g.getAllVertices();
        int[] distances = new int[vertices.size()];
        AdaptablePQ pq = new AdaptablePQ();
        Map<Vertex, Vertex> parent = new HashMap<>();

        for (int i = 0; i < distances.length; i++) {
            distances[i] = Integer.MAX_VALUE;
        }
        distances[a.getId()] = 0;
        pq.insertOrReplace(a, 0);

        while (!pq.isEmpty()) {
            Vertex current = pq.removeMin().getVertex();
            for (VertexNumPair neighbour : current.getNeighbours()) {
                int currentDistance = distances[current.getId()] + neighbour.getNum();
                if (currentDistance < distances[neighbour.getVertex().getId()]) {
                    pq.insertOrReplace(neighbour.getVertex(), currentDistance);
                    distances[neighbour.getVertex().getId()] = currentDistance;
                    parent.put(neighbour.getVertex(), current);
                }
            }
        }

        if (!parent.containsKey(b)) {
            return null;
        }

        // Reconstructs the path
        List<Vertex> shortestPath = new ArrayList<>();
        Vertex current = b;
        while (current != null) {
            shortestPath.add(current);
            current = parent.get(current);
        }
        Collections.reverse(shortestPath);
        return shortestPath;
    }
}
