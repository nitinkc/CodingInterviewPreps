package dataStructures.BinaryTrees;

/**
 * Created by Nitin Chaurasia on 4/10/16 at 1:16 AM.
 */
public interface IBinarySearchTree {

    public void insert(BSTNode node);
    /* Functions to delete data */

    /* Function for inorder traversal */
    public void inorder(BSTNode r);

    /* Function for pre-order traversal */
    public void preorder(BSTNode r);

    /* Function for postorder traversal */
    public void postorder(BSTNode r);

    public void delete(BSTNode node);

    /* Replaces subtree rooted at node u with the subtree rooted at node v */
    public void transplant(BSTNode u, BSTNode v);

    /* Function to count number of nodes recursively */
    public int countNodes(BSTNode r);

    /* Functions to search for an element */
    public boolean search(int val);

    /* Function to search for an element recursively */
    public boolean search(BSTNode r, int val);
}