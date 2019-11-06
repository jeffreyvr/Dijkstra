import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;

public class BasicTest {
    public Dijkstra dijkstra = new Dijkstra();

    /**
     * Setting up a graph for testing.
     */
    public void setup() {
        Node a = this.dijkstra.createNode("A");
        Node b = this.dijkstra.createNode("B");
        Node c = this.dijkstra.createNode("C");
        Node d = this.dijkstra.createNode("D");
        Node e = this.dijkstra.createNode("E");

        a.addNeighbour(this.dijkstra.createEdge(a, b,1));
        a.addNeighbour(this.dijkstra.createEdge(a, d,8));
        b.addNeighbour(this.dijkstra.createEdge(b, c,5));
        c.addNeighbour(this.dijkstra.createEdge(c, d,3));
        d.addNeighbour(this.dijkstra.createEdge(d, e,1));

        this.dijkstra.computePath(a);
    }

    @Test
    public void test_shortest_path_outcomes() {
        this.setup();

        assertEquals(this.dijkstra.getShortestPathTo(this.dijkstra.findNode("E")).toString(), "[A, D, E]");
        assertEquals(this.dijkstra.getShortestPathTo(this.dijkstra.findNode("B")).toString(), "[A, B]");
        assertNotEquals(this.dijkstra.getShortestPathTo(this.dijkstra.findNode("C")).toString(), "[A, B]");
    }

    @Test
    public void test_should_return_null_on_looking_for_non_existing_node() {
        this.setup();

        assertNull(this.dijkstra.findNode("G"));
    }

    @Test
    public void test_path_should_be_empty_on_non_existing_shortest_path() {
        this.setup();

        assertEquals(this.dijkstra.getShortestPathTo(this.dijkstra.findNode("G")).isEmpty(), true);
    }
}