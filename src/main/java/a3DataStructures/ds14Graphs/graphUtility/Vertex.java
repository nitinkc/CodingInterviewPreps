package a3DataStructures.ds14Graphs.graphUtility;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nitin Chaurasia on 2/6/17 at 12:03 AM.
 */
@Getter
@Setter
public class Vertex<T> {
    private T data;
    private boolean visited;
    private List<Vertex> neighbours;//adjacency list

    // Check this method
    public void addNeighbour(Vertex vertex){
        this.neighbours.add(vertex);
    }

    public Vertex(T data){
        this.data = data;
        this.neighbours = new ArrayList<>();// INSTANTIATE NEIGHBOUR LIST
    }

    @Override
    public String toString(){
        return "" + this.data;
    }
}
