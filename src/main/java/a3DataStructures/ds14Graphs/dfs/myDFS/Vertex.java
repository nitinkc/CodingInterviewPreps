package a3DataStructures.ds14Graphs.dfs.myDFS;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nitin Chaurasia on 2/27/18 at 7:57 PM.
 */
public class Vertex {
    private String node;
    private List<Vertex> neighbours;
    private boolean isVisited;

    Vertex(String node){
        this.node = node;
        this.neighbours = new ArrayList<>();
    }

    public void addNeighbour(Vertex v){
        this.neighbours.add(v);
    }

    public String getNode() {
        return node;
    }

    public void setNode(String node) {
        this.node = node;
    }

    public List<Vertex> getNeighbours() {
        return neighbours;
    }

    public void setNeighbours(List<Vertex> neighbours) {
        this.neighbours = neighbours;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    @Override
    public String toString() {
        return node;
    }
}
