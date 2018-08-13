package a1DataStructures.ds14Graphs.bfs.myBFS;

 /**
 * Created by Nitin Chaurasia on 2/27/18 at 7:48 PM.
 */
public class MyBFSdriver {
    public static void main(String[] args) {
        BFS bfs = new BFS();

        Vertex vertex0 = new Vertex("SP");
        Vertex vertex1 = new Vertex("Rama");
        Vertex vertex2 = new Vertex("Nitin");
        Vertex vertex3 = new Vertex("Kirti");
        Vertex vertex4 = new Vertex("Nidhi");
        Vertex vertex5 = new Vertex("Nishu");
        Vertex vertex6 = new Vertex("Varun");
        Vertex vertex7 = new Vertex("Kunal");
        Vertex vertex8 = new Vertex("Sai");
        Vertex vertex9 = new Vertex("Shubh");

        vertex0.addNeighbour(vertex2);
        vertex0.addNeighbour(vertex1);
        vertex0.addNeighbour(vertex4);
        vertex0.addNeighbour(vertex5);

        vertex4.addNeighbour(vertex6);
        vertex6.addNeighbour(vertex8);
        vertex6.addNeighbour(vertex9);


        vertex2.addNeighbour(vertex3);

        vertex5.addNeighbour(vertex7);

        bfs.bfs(vertex0);
    }
}
