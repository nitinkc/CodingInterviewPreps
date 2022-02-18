package a1DataStructures.ds14Graphs.adjacencyListRepresentation;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        //int list[][] = new int[][]{{1,3},{1,4}};
        List<Pair<Integer,Integer>> vertices = new ArrayList<>();
        vertices.add(new ImmutablePair<Integer,Integer>(1,3));
        vertices.add(new ImmutablePair<>(1,4));
        vertices.add(new ImmutablePair<>(2,3));
        vertices.add(new ImmutablePair<>(5,3));
        vertices.add(new ImmutablePair<>(6,5));
        vertices.add(new ImmutablePair<>(3,5));
        vertices.add(new ImmutablePair<>(2,4));

        Map<Node,List<Node>> graphMap = new HashMap<>();
        for (Pair p : vertices) {
            Node a = new Node((Integer) p.getLeft());
            Node b = new Node((Integer) p.getRight());

            //create the nodes if its not present
            createVertex(graphMap, a, b);

            //create the edges
            addEdge(graphMap, a, b);
        }
        //In the end assemble the graph G = {V,E}
        Graph g = new Graph(graphMap);

        g.printMap();

    }

    private static void addEdge(Map<Node, List<Node>> graphMap, Node a, Node b) {
        graphMap.get(a).add(b);
        graphMap.get(b).add(a);
    }

    private static void createVertex(Map<Node, List<Node>> graphMap, Node a, Node b) {
        graphMap.putIfAbsent(a, new ArrayList<>());
        graphMap.putIfAbsent(b, new ArrayList<>());
    }
}
