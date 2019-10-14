package a1DataStructures.ds14Graphs.bfs;

/**
 * Created by Nitin Chaurasia on 2/6/17 at 12:04 AM.
 *          1
 *       /      \
 *      2        4
 *     /          \
 *    3            5
 */
public class Driver {
    public static void main(String[] args) {
        BFS bfs = new BFS();

        Vertex vertex1 = new Vertex(1);
        Vertex vertex2 = new Vertex(2);
        Vertex vertex3 = new Vertex(3);
        Vertex vertex4 = new Vertex(4);
        Vertex vertex5 = new Vertex(5);

        vertex1.addNeighbourVertex(vertex2);
        vertex1.addNeighbourVertex(vertex4);
        vertex2.addNeighbourVertex(vertex3);
        vertex4.addNeighbourVertex(vertex5);

        bfs.bfs(vertex1);
    }
}
