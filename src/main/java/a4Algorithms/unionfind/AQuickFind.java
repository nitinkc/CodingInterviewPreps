package a4Algorithms.unionfind;

import java.util.Arrays;

public class AQuickFind implements IUnionFind {

    int[] root;
    public AQuickFind(int size) {
        root = new int[size];
        for (int i = 0; i < root.length; i++) {
            root[i] = i;
        }
    }

    @Override
    public int find(int node) {//Finds the root of the node (Not the parent)
        return root[node];//Quick find O(1), Eager Approach, each arr element has final root, instead of immediate PARENT
    }

    @Override
    public void union(int x, int y) {
        int rootX = find(x);//Keeping x as priority
        int rootY = find(y);//O(1)

        if (rootX!=rootY){//1-2-5-6-7  3-8-9  4
            //merging the set containing y into the set containing x.
            for (int i = 0; i < root.length; i++) {// O(n) average : Iterating through all elements
                if (root[i]==rootY){//finds all elements that have rootY as their root.
                    root[i]=rootX;//and replace them with rootX
                }
            }
        }
        System.out.println(Arrays.toString(root));//Off by one error
    }

    @Override
    public boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }
}
