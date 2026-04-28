class Program {
  public static int getNthFib(int n) {
    // Write your code here.
		//Recursive
		/*
		if(n == 2)
			return 1;
		if(n == 1)
			return 0;
		
		return getNthFib(n-1) + getNthFib(n-2);
		*/
		
		//Using Memoization
		int memoize[] = new int[3];
		memoize[0] = 0;
		memoize[1] = 1;
		if(n == 2)
			return memoize[1];
		if(n == 1)
			return memoize[0];
		
		return getNthFib(n,memoize);
		
		//Using Iteration
		/*
		int p = 0;
		int q = 1;
		int ret = -1;
		if (n == 1)
			return p;
		if (n == 2)
			return q;
		
		for (int i = 3; i<=n; i++){
			ret = p + q;
			p = q;
			q = ret;
		}
		
		return ret;
		*/
  }
	
	private static int getNthFib(int n, int[] memoize){
		if (memoize[n-1] != 0)
			return memoize[n-1];
		else{
			memoize[n-1] = getNthFib(n-1, memoize) + getNthFib(n-2, memoize);
			return memoize[n-1];
		}
	}
}
