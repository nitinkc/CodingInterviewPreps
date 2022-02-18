package a1DataStructures.ds14Graphs.graphUtility;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.MutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphFromFile {
    public static <T> Map<T, Vertex> getGraphFromFile(String filePath) {

        List<Pair<T,T>> pairs = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] str = line.split(" ");
                if(StringUtils.isNumeric(str[0])){
                    pairs.add(new MutablePair(Integer.parseInt(str[0]),Integer.parseInt(str[1])));
                }else{
                    if(str[0].length() == 1){//Its a Character
                        pairs.add(new MutablePair(Character.valueOf(str[0].charAt(0)),Character.valueOf(str[1].charAt(0))));
                    }else{
                        pairs.add(new MutablePair(str[0], str[1]));
                    }
                }
            }
        } catch (IOException ioe) {
            System.err.printf("IOException: %s%n", ioe);
        }

        Map<T, Vertex> vertexMap = new HashMap<>();
        for(Pair<T,T> p : pairs){
            T lt = p.getLeft();
            T rt = p.getRight();

            //TRICK:: First Add both the vertices and then add neighbors
            if(!vertexMap.containsKey(lt)){
                Vertex<T> head = new Vertex(lt);
                vertexMap.put(lt, head);
            }

            if(!vertexMap.containsKey(rt)){
                Vertex<T> tail = new Vertex(rt);
                vertexMap.put(rt, tail);
            }

            // For directed Graph, the file should have two rows like "1 4" & "4 1"
            vertexMap.get(lt).addNeighbour(vertexMap.get(rt));
        }
        return vertexMap;
    }
}
