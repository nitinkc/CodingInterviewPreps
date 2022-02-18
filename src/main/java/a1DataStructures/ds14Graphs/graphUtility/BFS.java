package a1DataStructures.ds14Graphs.graphUtility;

import a1DataStructures.ds14Graphs.graphUtility.Vertex;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Nitin Chaurasia on 2/6/17 at 12:04 AM.
 */
public class BFS<T> {

    public void bfs(Vertex<T> root){

        // Linked List Implementation of Queue
        Queue<Vertex> queue = new LinkedList<>();

        queue.add(root);
        root.setVisited(true);

        while(!queue.isEmpty()){
            Vertex<T> currentVertex = queue.remove();
            System.out.print(currentVertex + " ");//using toSrting

            for(Vertex<T> v : currentVertex.getNeighbours()){
                if(!v.isVisited()){
                    v.setVisited(true);
                    queue.add(v);
                }
            }
        }
    }
}
