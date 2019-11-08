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

        Node a = dijkstra.createNode(1);
        Node b = dijkstra.createNode(2);
        Node c = dijkstra.createNode(3);
        Node d = dijkstra.createNode(4);
        Node e = dijkstra.createNode(5);

        a.addNeighbour(dijkstra.createEdge(a, b,1));
        a.addNeighbour(dijkstra.createEdge(a, d,8));
        b.addNeighbour(dijkstra.createEdge(b, c,5));
        c.addNeighbour(dijkstra.createEdge(c, d,3));
        d.addNeighbour(dijkstra.createEdge(d, e,1));

        dijkstra.computePath(a);

        System.out.println("The shortest path between 1 and 5: " + dijkstra.getShortestPathTo(e));
    }
}