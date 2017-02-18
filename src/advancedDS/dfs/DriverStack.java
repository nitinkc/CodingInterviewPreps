package advancedDS.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nitin Chaurasia on 2/6/17 at 1:07 AM.
 * Memory slightly better than BFS. Bit more memory friendly
 * O(V+E)
 */
public class DriverStack {
    public static void main(String[] args) {
        Vertex v1 = new Vertex("1");
        Vertex v2 = new Vertex("2");
        Vertex v3 = new Vertex("3");
        Vertex v4 = new Vertex("45");
        Vertex v5 = new Vertex("6");
        Vertex v6 = new Vertex("7");

        List<Vertex> list = new ArrayList<>();

        v1.addNeighbour(v2); v1.addNeighbour(v3);
        v3.addNeighbour(v4); v4.addNeighbour(v5);

        list.add(v1); list.add(v2); list.add(v3);
        list.add(v4); list.add(v5); list.add(v6);

        DFSWithStack dfsWithStack = new DFSWithStack();
        dfsWithStack.dfs(list);



    }
}
