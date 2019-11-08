import java.util.*;

class Dijkstra {
    public List<Node> nodes;
    public List<Edge> edges;

    /**
     * Add node
     *
     * @param number Node number
     * @return The created node
     */
    public Node createNode(Integer number) {
        if (this.nodes == null){
            this.nodes = new LinkedList<>();
        }

        Node node = new Node(number);

        this.nodes.add(node);

        return node;
    }

    /**
     * Find node
     *
     * @param number
     * @return The node or null
     */
    public Node findNode(Integer number) {
        for (Node node : this.nodes) {
            if (node.getNumber().equals(number)) {
                return node;
            }
        }
        return null;
    }

    /**
     * Create Edge
     *
     * @param a Start
     * @param b End
     * @param cost Cost or weight of the edge
     * @return Created Edge
     */
    public Edge createEdge(Node a, Node b, Integer cost) {
        if (this.edges == null){
            this.edges = new LinkedList<>();
        }

        Edge edge = new Edge(cost, a, b);

        this.edges.add(edge);

        return edge;
    }

    /**
     * Compute path
     *
     * @param sourceNode Starting node
     */
    public void computePath(Node sourceNode) {
        sourceNode.setMinDistance(0);

        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();

        priorityQueue.add(sourceNode);

        while (!priorityQueue.isEmpty()) {

            // Remove source node from queue
            Node node = priorityQueue.poll();

            for (Edge edge : node.getEdges()) {
                Node n = edge.getTargetNode();
                Integer cost = edge.getCost();
                Integer minDistance = node.getMinDistance() + cost;

                if (minDistance < n.getMinDistance()) {
                    priorityQueue.remove(node);
                    n.setPreviousNode(node);
                    n.setMinDistance(minDistance);
                    priorityQueue.add(n);
                }
            }
        }
    }

    /**
     * Get shortest path to node
     *
     * @param targetNode Target
     * @return The shortest path
     */
    public List<Node> getShortestPathTo(Node targetNode) {
        List<Node> path = new ArrayList<>();

        for (Node node = targetNode; node != null; node = node.getPreviousNode()) {
            path.add(node);
        }

        Collections.reverse(path);

        return path;
    }
}