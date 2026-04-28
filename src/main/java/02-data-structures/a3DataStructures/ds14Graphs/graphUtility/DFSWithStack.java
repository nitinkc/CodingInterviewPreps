package a3DataStructures.ds14Graphs.graphUtility;

import java.util.List;
import java.util.Stack;

/**
 * Created by Nitin Chaurasia on 2/6/17 at 11:26 PM.
 */
public class DFSWithStack<T> {

    // private Stack<Vertex> stack = new Stack<>(); // Bad Practise
    private final Stack<Vertex> stack;

    public DFSWithStack() {
        this.stack = new Stack<>();
    }

    public void dfs(List<Vertex> vertexList){

        // if there are clusters, of multiple unconnected graph
        for(Vertex<T> v : vertexList){
            if(!v.isVisited()){
                v.setVisited(true);

                dfsWithStack(v);
            }
        }
    }

    private void dfsWithStack(Vertex<T> rootVertex) {
        this.stack.push(rootVertex);

        rootVertex.setVisited(true);

        while (!stack.isEmpty()){
            Vertex<T> currentVertex = this.stack.pop();
            System.out.print(currentVertex + " ");

            for(Vertex<T> v :  currentVertex.getNeighbours()){
                if(!v.isVisited()){
                    v.setVisited(true);
                    this.stack.push(v);
                }
            }
        }
    }
}
