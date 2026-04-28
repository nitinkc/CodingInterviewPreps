package a4Algorithms.unionfind;

public class DPathCompression implements IUnionFind {
    int[] root;

    public DPathCompression(int size) {
        root = new int[size];
        for (int i = 0; i < size; i++) {
            root[i] = i;
        }
    }

    @Override
    public int find(int x) {
        if (x == root[x]) {
            return x;
        }
        return root[x] = find(root[x]);
    }

    @Override
    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            root[rootY] = rootX;
        }
    }

    @Override
    public boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }
}
