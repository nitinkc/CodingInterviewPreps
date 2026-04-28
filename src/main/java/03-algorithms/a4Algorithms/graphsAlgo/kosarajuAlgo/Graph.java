package a4Algorithms.graphsAlgo.kosarajuAlgo;

import lombok.*;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Graph {
    private Map<Integer, Vertex> vertexMap;
    private List<Edge> edgeList;
}
