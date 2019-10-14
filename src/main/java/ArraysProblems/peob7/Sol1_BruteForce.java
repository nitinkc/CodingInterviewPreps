package ArraysProblems.peob7;

class Sol1_BruteForce {
    public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
        // Write your code here.
        //Brute Force O(nXm)
        int smallest = Integer.MAX_VALUE;
        int ret[] = new int[2];
        for (int i = 0; i < arrayOne.length; i++){
            for(int j = 0; j < arrayTwo.length; j++){
                if (smallest > Math.abs(arrayOne[i] - arrayTwo[j])){
                    smallest = Math.abs(arrayOne[i] - arrayTwo[j]);
                    ret[0] = arrayOne[i];
                    ret[1] = arrayTwo[j];
                }
            }
        }
        return ret;
    }
}
