class Main {
    public static void main(String[] args) {
        (new Main()).example();
    }

    /**
     * Create an example of a graph and find
     * the shortest path between two nodes.
     */
    public void example() {
        Dijkstra dijkstra = new Dijkstra();

        Node a = dijkstra.createNode("A");
        Node b = dijkstra.createNode("B");
        Node c = dijkstra.createNode("C");
        Node d = dijkstra.createNode("D");
        Node e = dijkstra.createNode("E");

        a.addNeighbour(dijkstra.createEdge(a, b,1));
        a.addNeighbour(dijkstra.createEdge(a, d,8));
        b.addNeighbour(dijkstra.createEdge(b, c,5));
        c.addNeighbour(dijkstra.createEdge(c, d,3));
        d.addNeighbour(dijkstra.createEdge(d, e,1));

        dijkstra.computePath(a);

        System.out.println("The shortest path between A and E: " + dijkstra.getShortestPathTo(e));
    }
}