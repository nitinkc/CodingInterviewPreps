package a1DataStructures.ds14Graphs.bfs;

import a1DataStructures.ds14Graphs.graphUtility.BFS;
import a1DataStructures.ds14Graphs.graphUtility.GraphFromFile;
import a1DataStructures.ds14Graphs.graphUtility.Vertex;
import org.apache.commons.lang3.tuple.MutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Nitin Chaurasia on 2/6/17 at 12:04 AM.
 *          1
 *       /     \
 *      2        4
 *     /          \
 *    3            5
 */
public class Driver {
    public static void main(String[] args) {

        Vertex<Integer> root = createGraphFromObjects();
        BFS<Integer> bfs = new BFS();
        bfs.bfs(root);

        String file = "src/main/java/a1DataStructures/ds14Graphs/graphUtility/graph.txt";
        Map<Integer, Vertex> graph = GraphFromFile.getGraphFromFile(file);
        Vertex root2 = graph.get(1);
        System.out.println("*********************** FROM FILE ***********************");
        bfs.bfs(root2);
    }

    private static Vertex createGraphFromObjects() {
        Vertex root = new Vertex(1);
        Vertex vertex2 = new Vertex(2);
        Vertex vertex3 = new Vertex(3);
        Vertex vertex4 = new Vertex(4);
        Vertex vertex5 = new Vertex(5);

        root.addNeighbour(vertex2);
        root.addNeighbour(vertex4);
        vertex2.addNeighbour(vertex3);
        vertex4.addNeighbour(vertex5);
        return root;
    }
}
