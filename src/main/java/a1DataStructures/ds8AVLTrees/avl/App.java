package a1DataStructures.ds8AVLTrees.avl;

public class App {

	public static void main(String[] args) {

		Tree avl = new AvlTree();

		avl.insert(10);
		avl.insert(15);
		avl.insert(5);
		avl.insert(6);

		avl.traverse();
		avl.delete(15);
		
		avl.traverse();
	}
	
}
