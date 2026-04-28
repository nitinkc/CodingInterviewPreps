class Program {
  public static int findClosestValueInBst(BST tree, int target) {
    // Write your code here.
		BST runner = null; 
		int closest = Math.abs(tree.value-target);
		
		if(target > tree.value)
			runner = tree.right;
		else
			runner = tree.left;
		
		
  }

  static class BST {
    public int value;
    public BST left;
    public BST right;

    public BST(int value) {
      this.value = value;
    }
  }
}
