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
 * Created by Nitin Chaurasia on 2/17/22 at 12:04 AM.
 *          A
 *       /  |  \
 *      B   F   G
 *     / |     /
 *    C   D   H
 *       /
 *     E
 */
public class DriverAlphabet {
    public static void main(String[] args) {
        String file = "src/main/java/a1DataStructures/ds14Graphs/graphUtility/graph2.txt";

        Map<Character, Vertex> graph = GraphFromFile.getGraphFromFile(file);
        Vertex<Character> root = graph.get('A');
        BFS<Character> bfs = new BFS();
        bfs.bfs(root);

        System.out.println();
        String file2 = "src/main/java/a1DataStructures/ds14Graphs/graphUtility/graph3.txt";
        Map<Character, Vertex> graph2 = GraphFromFile.getGraphFromFile(file2);
        Vertex<Character> root2 = graph2.get('C');
        BFS<Character> bfs2 = new BFS();
        bfs2.bfs(root2);
    }

    private static Map<Character, Vertex> getGraphFromFile(String file) {

        List<Pair<Character,Character>> pairs = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] str = line.split(" ");
                pairs.add(new MutablePair<>(Character.valueOf(str[0].charAt(0)),Character.valueOf(str[1].charAt(0))));
            }
        } catch (IOException ioe) {
            System.err.printf("IOException: %s%n", ioe);
        }

        Map<Character, Vertex> vertexMap = new HashMap<>();

        for(Pair<Character,Character> p : pairs){
            Character lt = p.getLeft();
            Character rt = p.getRight();

            //TRICK:: First Add both the vertices and then add neighbors
            if(!vertexMap.containsKey(lt)){
                Vertex head = new Vertex(lt);
                vertexMap.put(lt, head);
            }

            if(!vertexMap.containsKey(rt)){
                Vertex tail = new Vertex(rt);
                vertexMap.put(rt, tail);
            }

            // For directed Graph, the file should have two rows like "1 4" & "4 1"
            vertexMap.get(lt).addNeighbour(vertexMap.get(rt));
        }
        return vertexMap;
    }
}
