package a2Algorithms.graphsAlgo.kosarajuAlgo;

import java.util.List;
import java.util.Stack;

public class DepthFirstOrder {
    private Stack<Vertex> stack;
    Stack<Vertex> dfsStack = new Stack<>();

    public DepthFirstOrder(Graph graph){
        for (Integer v : graph.getVertexMap().keySet()){
            Vertex currentVertex = graph.getVertexMap().get(v);
            if (!currentVertex.isVisited()){
                dfs(currentVertex);
            }
        }
        //dfs(graph.getVertexMap().get(1));
    }

    private void dfs(Vertex vertex) {
        this.dfsStack.push(vertex);
        vertex.setVisited(true);

        while(!this.dfsStack.empty()) {
            Vertex v = this.dfsStack.pop();
            System.out.print("current vertex : " + v.getData() + "\t");
            List<Vertex> neighbors = v.getNeighbors();
            for (Vertex ver : neighbors) {
                if (!ver.isVisited()) {
                    ver.setVisited(true);
                    this.dfsStack.push(ver);
                }
            }
        }
    }
}
