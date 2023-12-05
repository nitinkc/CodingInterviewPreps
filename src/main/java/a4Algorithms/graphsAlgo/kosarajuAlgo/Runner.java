package a4Algorithms.graphsAlgo.kosarajuAlgo;

import org.apache.commons.lang3.tuple.MutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Runner {
    public static void main(String[] args) {

        //String file = "src/main/java/a4Algorithms/graphsAlgo/kosarajuAlgo/SCC.txt";
        String file = "src/main/java/a4Algorithms/graphsAlgo/kosarajuAlgo/test.txt";

        List<Pair<Integer, Integer>> pairs = readFileIntoPair(file);

        Map<Integer,Vertex> vertexMap = new HashMap<>();
        List<Edge> edgeList = new ArrayList<>();

        for(Pair<Integer,Integer> p : pairs){
            Integer lt = p.getLeft();
            Integer rt = p.getRight();

            //TRICK:: First Add both the vertices, then finish the edges
            if(!vertexMap.containsKey(lt)){
                Vertex head = new Vertex(lt);
                vertexMap.put(lt, head);
            }

            if(!vertexMap.containsKey(rt)){
                Vertex tail = new Vertex(rt);
                vertexMap.put(rt, tail);
            }

            vertexMap.get(lt).addNeighbour(vertexMap.get(rt));

            Edge e = new Edge();
            e.setStart(vertexMap.get(rt));
            e.setTarget(vertexMap.get(lt));
            edgeList.add(e);
        }

        Graph g = new Graph(vertexMap, edgeList);
        DepthFirstOrder dfo = new DepthFirstOrder(g);
    }

    private static List<Pair<Integer, Integer>> readFileIntoPair(String file) {
        List<Pair<Integer,Integer>> pairs = new ArrayList<>();

        Charset characterSet = Charset.defaultCharset();
        Path path = Paths.get(file);
        try (BufferedReader reader = Files.newBufferedReader(path, characterSet)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] str = line.split(" ");
                pairs.add(new MutablePair<>(Integer.parseInt(str[0]),Integer.parseInt(str[1])));
            }
        } catch (IOException ioe) {
            System.err.printf("IOException: %s%n", ioe);
        }
        return pairs;
    }
}
