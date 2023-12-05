package a3DataStructures.ds14Graphs.adjacencyListRepresentation;

import lombok.*;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class Graph {
    private Map<Node, List<Node>> graphMap;

    public Graph(Map<Node, List<Node>> graphMap) {
        this.graphMap = graphMap;
    }

    public void printMap(){
        Iterator<Node> itr = graphMap.keySet().iterator();
        while (itr.hasNext()){
            Node curr = itr.next();
            List<Node> neighbor = graphMap.get(curr);

            System.out.println("Node :: " + curr.getData() + " ===> Neighbours" + neighbor.toString());
        }
    }
}
