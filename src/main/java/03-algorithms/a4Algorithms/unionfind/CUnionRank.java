package a4Algorithms.unionfind;

public class CUnionRank implements IUnionFind {
    int[] root;
    int[] rank;

    public CUnionRank(int size) {
        root = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            root[i] = i;
            rank[i] = 1;//Initial height is 1
        }
    }

    @Override
    public int find(int x) {
        while (x != root[x]) {
            x = root[x];
        }
        return x;
    }

    @Override
    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        //modified quick union
        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                root[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {//Which ever has a higher/taller height, it becomes the new root.
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