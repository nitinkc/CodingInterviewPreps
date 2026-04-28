package a4Algorithms.unionfind;

public class EUnionRankPathCompression implements IUnionFind {
    private int[] root;
    // Use a rank array to record the height of each vertex, i.e., the "rank" of each vertex.
    private int[] rank;

    public EUnionRankPathCompression(int size) {
        root = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            root[i] = i;
            rank[i] = 1; // The initial "rank" of each vertex is 1, because each of them is
            // a standalone vertex with no connection to other vertices.
        }
    }

    @Override
    public int find(int x) {
        if (x == root[x]) {
            return x;
        }
        // Some ranks may become obsolete so they are not updated
        return root[x] = find(root[x]);
    }

    @Override
    // The union function with union by rank
    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                root[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                root[rootX] = rootY;
            } else {
                root[rootY] = rootX;
                rank[rootX] += 1;
            }
        }
    }

    @Override
    public boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }
}
