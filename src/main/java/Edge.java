public class Edge {
    private Integer cost;
    private Node startNode;
    private Node targetNode;

    public Edge(Integer cost, Node startNode, Node targetNode) {
        this.cost = cost;
        this.startNode = startNode;
        this.targetNode = targetNode;
    }

    /**
     * Get the edge cost
     *
     * @return edge cost
     */
    public Integer getCost() {
        return cost;
    }

    /**
     * Set the edge cost
     *
     * @param cost the edge cost
     */
    public void setCost(Integer cost) {
        this.cost = cost;
    }

    /**
     * Get Start Node
     *
     * @return The start node
     */
    public Node getStartNode() {
        return startNode;
    }

    /**
     * Set start Node
     *
     * @param startNode the start node
     */
    public void setStartNode(Node startNode) {
        this.startNode = startNode;
    }

    /**
     * Get target Node
     *
     * @return target node
     */
    public Node getTargetNode() {
        return targetNode;
    }

    /**
     * Set target Node
     *
     * @param targetNode target node
     */
    public void setTargetNode(Node targetNode) {
        this.targetNode = targetNode;
    }
}