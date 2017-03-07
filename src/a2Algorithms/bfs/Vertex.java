package a2Algorithms.bfs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nitin Chaurasia on 2/6/17 at 12:03 AM.
 */
public class Vertex {
    private int data;
    private boolean visited;
    private List<Vertex> neighbourList;


    // Check this method
    public void addNeighbourVertex(Vertex vertex){
        this.neighbourList.add(vertex);
    }

    public Vertex(int data){
        this.data = data;
        this.neighbourList = new ArrayList<>();
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public List<Vertex> getNeighbourList() {
        return neighbourList;
    }

    public void setNeighbourList(List<Vertex> neighbourList) {
        this.neighbourList = neighbourList;
    }

    @Override
    public String toString(){
        return "" + this.data;
    }
}
