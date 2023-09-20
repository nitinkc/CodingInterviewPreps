package a1DataStructures.ds14Graphs.bfs.newStyle;

import java.util.*;
import java.lang.*;
import java.io.*;

public class BFS {

    public static void main(String[] args) throws IOException {
        File file = new File("src/main/java/a1DataStructures/ds14Graphs/bfs/newStyle/data.txt");

        InputStream in = new FileInputStream(file);

        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                // adj.get(v).add(u);
            }

            Solution obj = new Solution();
            ArrayList<Integer> ans = obj.bfsOfGraph(V, adj);
            for (int i = 0; i < ans.size(); i++)
                System.out.print(ans.get(i) + " ");
            System.out.println();
        }
    }
}

    class Solution {
        // Function to return Breadth First Traversal of given graph.
        public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
            ArrayList<Integer> bfsTraversal = new ArrayList<>();//List to hold the Vertex/Node of the graph while performing BFS

            boolean visited[] = new boolean[V];//Non nullable boolean Array, since Node/Vertex is not a class but an Integer Value
            visited[0] = true;//Beginning from node at index 0;

            //BFS uses a queue
            Queue<Integer> queue = new LinkedList<>();//Queue interface has LL, PriorityQueue and DeQueue. Doubly Ended queue is not needed.
            Integer initialNode = 0;
            queue.add(initialNode);//Add the root or the first Vertex in the queue

            while (!queue.isEmpty()) {
                Integer currentVertex = queue.poll();
                //System.out.println(currentVertex);//Either print to Console of keep it in a array
                bfsTraversal.add(currentVertex);

                //Add the neighbors of the current vertex into the queue
                for (Integer i : adj.get(currentVertex)) {//Take the first neighbor
                    if (!visited[i]) {//If not visited, mark it visited and add in the queue for further traversal
                        visited[i] = true;
                        queue.add(i);
                    }
                }
            }//End while loop

            return bfsTraversal;
        }
    }
