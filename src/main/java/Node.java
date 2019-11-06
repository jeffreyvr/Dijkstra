import java.util.ArrayList;
import java.util.List;

public class Node implements Comparable<Node> {
    private String name;
    private List<Edge> edges;
    private boolean visited;
    private Node previousNode;
    private double minDistance = Double.MAX_VALUE;

    /**
     * Node
     *
     * @param name Name of the node
     */
    public Node(String name) {
        this.name = name;
        this.edges = new ArrayList<>();
    }

    /**
     * Get the node name
     *
     * @return node name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Add neighbour
     *
     * @param edge Add edge
     */
    public void addNeighbour(Edge edge) {
        this.edges.add(edge);
    }

    /**
     * Get edges
     *
     * @return The node edges
     */
    public List<Edge> getEdges() {
        return edges;
    }

    /**
     * Set the node's edges
     *
     * @param edges The node's edges
     */
    public void setEdges(List<Edge> edges) {
        this.edges = edges;
    }

    /**
     * Get min distance
     *
     * @return min distance
     */
    public double getMinDistance() {
        return minDistance;
    }

    /**
     * Set min distance
     *
     * @param minDistance
     */
    public void setMinDistance(double minDistance) {
        this.minDistance = minDistance;
    }

    /**
     * Get previous node
     *
     * @return previous node
     */
    public Node getPreviousNode() {
        return previousNode;
    }

    /**
     * Set previous node
     *
     * @param previousNode The previous node
     */
    public void setPreviousNode(Node previousNode) {
        this.previousNode = previousNode;
    }

    @Override
    public int compareTo(Node otherNode) {
        return Double.compare(this.minDistance, otherNode.minDistance);
    }

    @Override
    public String toString() {
        return name;
    }
}