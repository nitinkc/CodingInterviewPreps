package a1DataStructures.ds6BinaryTrees.myTree;

/**
 * Created by Nitin Chaurasia on 4/10/16 at 1:16 AM.
 */
public interface IBinarySearchTree {

    void insert(BSTNode node);
    /* Functions to delete data */

    /* Function for inorder traversal */
    void inorder(BSTNode r);

    /* Function for pre-order traversal */
    void preorder(BSTNode r);

    /* Function for postorder traversal */
    void postorder(BSTNode r);

    void delete(BSTNode node);

    /* Replaces subtree rooted at node u with the subtree rooted at node v */
    void transplant(BSTNode u, BSTNode v);

    /* Function to count number of nodes recursively */
    int countNodes(BSTNode r);

    /* Functions to search for an element */
    boolean search(int val);

    /* Function to search for an element recursively */
    boolean search(BSTNode r, int val);
}