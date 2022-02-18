package a1DataStructures.ds14Graphs.graphUtility;

import a1DataStructures.ds14Graphs.graphUtility.Vertex;

import java.util.List;
import java.util.Stack;

/**
 * Created by Nitin Chaurasia on 2/8/17 at 1:18 AM.
 */
public class DFSWithRecursion<T> {
    private Stack<Vertex> stack;

//    public DFSWithRecursion() {
//        // No need as recursive
//        //this.stack = new Stack<>();
//    }

    public void dfs(List<Vertex<T>> vertexList){

        // if there are clusters, of multiple unconnected graph
        for(Vertex<T> v : vertexList){
            if(!v.isVisited()){
                v.setVisited(true);
                dfsWithRecursion(v);
            }
        }
    }

    private void dfsWithRecursion(Vertex<T> rootVertex) {
        System.out.print(rootVertex + " ");

        for (Vertex<T> v : rootVertex.getNeighbours()){
            if(!v.isVisited()){
                v.setVisited(true);

                // Will use systems stack memory
                dfsWithRecursion(v);
            }
        }
    }
}