package a2Algorithms.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nitin Chaurasia on 2/6/17 at 11:25 PM.
 */
public class Vertex {
    private String name;
    private boolean visited;
    private List<Vertex> neighbour;

    public Vertex(String name) {
        this.name = name;
        this.neighbour = new ArrayList<>();
    }

    public void addNeighbour(Vertex v){
        this.neighbour.add(v);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public List<Vertex> getNeighbour() {
        return neighbour;
    }

    public void setNeighbour(List<Vertex> neighbour) {
        this.neighbour = neighbour;
    }

    @Override
    public String toString(){
        return this.name;
    }
}