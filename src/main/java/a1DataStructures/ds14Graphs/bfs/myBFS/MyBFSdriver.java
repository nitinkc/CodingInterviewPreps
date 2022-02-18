package a1DataStructures.ds14Graphs.bfs.myBFS;

import a1DataStructures.ds14Graphs.graphUtility.Vertex;

/**
 * Created by Nitin Chaurasia on 2/27/18 at 7:48 PM.
 */
public class MyBFSdriver {
    public static void main(String[] args) {
        BFS<String> bfs = new BFS();

        Vertex<String> vertex0 = new Vertex("SP");
        Vertex<String> vertex1 = new Vertex("Rama");
        Vertex<String> vertex2 = new Vertex("Nitin");
        Vertex<String> vertex3 = new Vertex("Kirti");
        Vertex<String> vertex4 = new Vertex("Nidhi");
        Vertex<String> vertex5 = new Vertex("Nishu");
        Vertex<String> vertex6 = new Vertex("Varun");
        Vertex<String> vertex7 = new Vertex("Kunal");
        Vertex<String> vertex8 = new Vertex("Sai");
        Vertex<String> vertex9 = new Vertex("Shubh");

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
