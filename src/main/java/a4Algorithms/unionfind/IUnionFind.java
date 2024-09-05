package a4Algorithms.unionfind;

public interface IUnionFind {
    int find(int node);//Finds the root of the node (Not the parent)
    void union(int x, int y);//Connect 2 nodes, or merge 2 disjoint sets

    //Two nodes are considered connected if they are in the same set or they have the same root.
    boolean isConnected(int x, int y);//check connectivity between 2 nodes, or check if 2 sets are connected
}