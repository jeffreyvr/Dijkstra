import java.util.*;

class Dijkstra {
    public List<Node> nodes;
    public List<Edge> edges;

    /**
     * Add node
     *
     * @param name Node name
     * @return The created node
     */
    public Node createNode(String name) {
        if (this.nodes == null){
            this.nodes = new LinkedList<Node>();
        }

        Node node = new Node(name);

        this.nodes.add(node);

        return node;
    }

    /**
     * Find node
     *
     * @param name
     * @return The node or null
     */
    public Node findNode(String name) {
        for (Node node : this.nodes) {
            if (node.getName().equals(name)) {
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
    public Edge createEdge(Node a, Node b, double cost) {
        if (this.edges == null){
            this.edges = new LinkedList<Edge>();
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
                Node v = edge.getTargetNode();
                double cost = edge.getCost();
                double minDistance = node.getMinDistance() + cost;

                if (minDistance < v.getMinDistance()) {
                    priorityQueue.remove(node);
                    v.setPreviousNode(node);
                    v.setMinDistance(minDistance);
                    priorityQueue.add(v);
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