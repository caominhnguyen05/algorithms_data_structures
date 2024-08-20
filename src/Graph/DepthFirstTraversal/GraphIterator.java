package Graph.DepthFirstTraversal;
import java.util.*;

public class GraphIterator implements Iterator<Vertex> {
    private Graph g;

    private Vertex v;

    private Stack<Vertex> stack;

    private Set<Vertex> colored;

    private int graphSize;

    public GraphIterator(Graph g, Vertex v) {
        stack = new Stack<>();
        this.g = g;
        this.v = v;
        graphSize = 0;
        colored = new TreeSet<>();
        stack.push(v);
    }

    @Override
    public boolean hasNext() {
        return graphSize != g.getAllVertices().size();
    }

    @Override
    public Vertex next() {
        v = stack.pop();
        if (colored.contains(v)) {
            return next();
        }

        List<Vertex> neighbours = g.getNeighbours(v).stream()
                        .sorted(Comparator.comparingInt(Vertex::getId).reversed()).toList();
        stack.addAll(neighbours);
        colored.add(v);
        graphSize++;
        return v;
    }
}
