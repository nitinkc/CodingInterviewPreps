package a4Algorithms.unionfind;

import java.util.Arrays;

public class BQuickUnion implements IUnionFind {
    int[] root;
    public BQuickUnion(int size) {
        root = new int[size];
        for (int i = 0; i < root.length; i++) {
            root[i] = i;
        }
    }

    /**
 * This method performs the union operation on two nodes in the Union-Find data structure.
 * It finds the root of both nodes and if they are not the same, it sets the root of the
     * second node (y) to the root of the first node (x).
 * This operation connects the two nodes and makes them part of the same set.
 *
 * @param x The first node to be unioned.
 * @param y The second node to be unioned.
 */
@Override
public void union(int x, int y) {
    int rootX = find(x);//Keeping x as priority
    int rootY = find(y);

    if(rootX != rootY) {
        //Set the root of Y to the root of X (immediate parent)
        root[rootY] = rootX;//Quick union O(1)
    }
    System.out.println(Arrays.toString(root));
}

    @Override
    public int find(int node) {
    //Only root node will have its index equal to its value
        while (root[node]!=node){//keep searching-up the chain until the root is reached
            node = root[node];//continues to find until root node is reached
        }
        return node;
    }

    public int findWithPrint(int node) {
        System.out.println("finding node :: " + node);
        while (root[node]!=node){
            node = root[node];//continues to find until root node is reached
            System.out.println("Found node :: " + node);
        }
        return node;
    }



    @Override
    public boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }
}
