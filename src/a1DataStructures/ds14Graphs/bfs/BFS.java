package a1DataStructures.ds14Graphs.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Nitin Chaurasia on 2/6/17 at 12:04 AM.
 */
public class BFS {

    public void bfs(Vertex root){

        // Linked List Implementation of Queue
        Queue<Vertex> queue = new LinkedList<>();

        queue.add(root);
        root.setVisited(true);

        while(!queue.isEmpty()){
            Vertex currentVertex = queue.remove();
            System.out.println(currentVertex + " ");//using toSrting

            for(Vertex v : currentVertex.getNeighbourList()){
                if(!v.isVisited()){
                    v.setVisited(true);
                    queue.add(v);
                }
            }
        }
    }
}
