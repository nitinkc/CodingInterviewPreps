package a1DataStructures.ds6BinaryTrees.binarySearchTree;
public interface Tree<T> {
	void traversal();
	void insert(T data);
	void delete(T data);
	T getMaxValue();
	T getMinValue();
}
