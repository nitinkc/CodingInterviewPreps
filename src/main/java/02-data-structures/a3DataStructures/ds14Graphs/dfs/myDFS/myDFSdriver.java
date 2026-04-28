package a3DataStructures.ds14Graphs.dfs.myDFS;

/**
 * Created by Nitin Chaurasia on 2/27/18 at 8:16 PM.
 *
 */
public class myDFSdriver {
    public static void main(String[] args) {
        DFS dfs = new DFS();

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

        dfs.dfs(vertex0);
    }
}

/**
 * BSF
 ------------
 SP
 Nitin
 Rama
 Nidhi
 Nishu
 Kirti
 Varun
 Kunal
 Sai
 Shubh


 DFS
 --------------
 SP
 Nishu
 Kunal
 Nidhi
 Varun
 Shubh
 Sai
 Rama
 Nitin
 Kirti
 */
