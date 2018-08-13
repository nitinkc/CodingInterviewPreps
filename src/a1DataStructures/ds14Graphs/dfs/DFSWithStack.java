package a1DataStructures.ds14Graphs.dfs;

import java.util.List;
import java.util.Stack;

/**
 * Created by Nitin Chaurasia on 2/6/17 at 11:26 PM.
 */
public class DFSWithStack {

    // private Stack<Vertex> stack = new Stack<>(); // Bad Practise
    private Stack<Vertex> stack;

    public DFSWithStack() {
        this.stack = new Stack<>();
    }

    public void dfs(List<Vertex> vertexList){

        // if there are clusters, of multiple unconnected graph
        for(Vertex v : vertexList){
            if(!v.isVisited()){
                v.setVisited(true);

                dfsWithStack(v);
            }
        }
    }

    private void dfsWithStack(Vertex rootVertex) {
        this.stack.push(rootVertex);

        rootVertex.setVisited(true);

        while (!stack.isEmpty()){
            Vertex currentVertex = this.stack.pop();
            System.out.print(currentVertex + " ");

            for(Vertex v :  currentVertex.getNeighbour()){
                if(!v.isVisited()){
                    v.setVisited(true);
                    this.stack.push(v);
                }
            }
        }
    }
}
