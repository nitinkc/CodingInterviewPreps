package a3DataStructures.ds14Graphs.dfs;

import a3DataStructures.ds14Graphs.graphUtility.DFSWithRecursion;
import a3DataStructures.ds14Graphs.graphUtility.DFSWithStack;
import a3DataStructures.ds14Graphs.graphUtility.Vertex;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nitin Chaurasia on 2/8/17 at 1:44 AM.
 */
public class DriverRecursion {
    public static void main(String[] args) {
        List<Vertex> list = getGraph();

        // This should also return the same output.
        DFSWithRecursion dfsWithRecursion = new DFSWithRecursion();
        dfsWithRecursion.dfs(list);

        System.out.println("***************************");
        list = getGraph();
        DFSWithStack dfsWithStack = new DFSWithStack();
        dfsWithStack.dfs(list);
    }

    private static List<Vertex> getGraph() {
        Vertex<String> v1 = new Vertex("1");
        Vertex<String> v2 = new Vertex("2");
        Vertex<String> v3 = new Vertex("3");
        Vertex<String> v4 = new Vertex("45");
        Vertex<String> v5 = new Vertex("6");
        Vertex<String> v6 = new Vertex("7");

        List<Vertex> list = new ArrayList<>();

        v1.addNeighbour(v2);
        v1.addNeighbour(v3);
        v3.addNeighbour(v4);
        v4.addNeighbour(v5);

        list.add(v1);
        list.add(v2);
        list.add(v3);
        list.add(v4);
        list.add(v5);
        list.add(v6);
        return list;
    }
}
