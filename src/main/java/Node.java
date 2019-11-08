import java.util.ArrayList;
import java.util.List;

public class Node implements Comparable<Node> {
    private Integer number;
    private List<Edge> edges;
    private Node previousNode;
    private Integer minDistance = Integer.MAX_VALUE;

    /**
     * Node
     *
     * @param number Number of the node
     */
    public Node(Integer number) {
        this.number = number;
        this.edges = new ArrayList<>();
    }

    /**
     * Get the node number
     *
     * @return node number
     */
    public Integer getNumber() {
        return this.number;
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
    public Integer getMinDistance() {
        return minDistance;
    }

    /**
     * Set min distance
     *
     * @param minDistance
     */
    public void setMinDistance(Integer minDistance) {
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
        return Integer.compare(this.minDistance, otherNode.minDistance);
    }

    @Override
    public String toString() {
        return "" + this.number;
    }
}