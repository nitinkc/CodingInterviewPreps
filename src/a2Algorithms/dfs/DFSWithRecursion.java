package a2Algorithms.dfs;

import java.util.List;
import java.util.Stack;

/**
 * Created by Nitin Chaurasia on 2/8/17 at 1:18 AM.
 */
public class DFSWithRecursion {
    private Stack<Vertex> stack;

//    public DFSWithRecursion() {
//        // No need as recursive
//        //this.stack = new Stack<>();
//    }

    public void dfs(List<Vertex> vertexList){

        // if there are clusters, of multiple unconnected graph
        for(Vertex v : vertexList){
            if(!v.isVisited()){
                v.setVisited(true);
                dfsWithRecursion(v);
            }
        }
    }

    private void dfsWithRecursion(Vertex rootVertex) {
        System.out.print(rootVertex + " ");

        for (Vertex v : rootVertex.getNeighbour()){
            if(!v.isVisited()){
                v.setVisited(true);

                // Will use systems stack memory
                dfsWithRecursion(v);
            }

        }
    }
}
