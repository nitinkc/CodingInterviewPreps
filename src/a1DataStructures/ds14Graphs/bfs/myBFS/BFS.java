package a1DataStructures.ds14Graphs.bfs.myBFS;

import java.util.LinkedList;
import java.util.Queue;


/**
 * Created by Nitin Chaurasia on 2/27/18 at 7:39 PM.
 */
public class BFS {

    private Queue<Vertex> queue = new LinkedList<>();

    public void bfs(Vertex root){
        queue.add(root);
        root.setVisited(true);

        while(!queue.isEmpty()){
            Vertex currentVertex = queue.remove();
            System.out.println(currentVertex);
            for (Vertex v : currentVertex.getNeighbours()){
                queue.add(v);
            }
        }
    }
}
