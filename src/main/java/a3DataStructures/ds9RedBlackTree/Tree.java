package a3DataStructures.ds9RedBlackTree;

public interface Tree {
    Node getMax();
    Node getMin();
    void insert(int data);
    void remove(int value);
    void traverseGraph();
}
