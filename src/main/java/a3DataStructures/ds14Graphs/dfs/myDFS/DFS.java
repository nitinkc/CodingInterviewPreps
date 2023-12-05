package a3DataStructures.ds14Graphs.dfs.myDFS;

import java.util.Stack;

/**
 * Created by Nitin Chaurasia on 2/27/18 at 8:03 PM.
 */
public class DFS {
    private final Stack<Vertex> stack = new Stack();

    public void dfs(Vertex root) {

        stack.add(root);
        root.setVisited(true);

        while(!stack.isEmpty()){
            Vertex currentVertex = stack.pop();
            System.out.println(currentVertex);

            for (Vertex v : currentVertex.getNeighbours()){
                v.setVisited(true);
                this.stack.add(v);
            }
        }
    }
}
