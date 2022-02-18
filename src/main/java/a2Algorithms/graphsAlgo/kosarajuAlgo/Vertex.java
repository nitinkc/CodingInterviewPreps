package a2Algorithms.graphsAlgo.kosarajuAlgo;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@RequiredArgsConstructor
public class Vertex {
    private int data;
    private List<Vertex> neighbors;
    private boolean visited;
    private int clusterNumber;

    public Vertex(Integer lt) {
        this.data = lt;
        this.neighbors = new ArrayList<>();
    }

    public void addNeighbour(Vertex root){
        this.neighbors.add(root);
    }
}
