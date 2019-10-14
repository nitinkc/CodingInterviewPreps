package udemyJobInterview;

/**
 * Created by Nitin Chaurasia on 11/1/15 at 8:31 AM.
 */
public class FibRec {
    // 1 2 3 4 5 6 7  8  9 10
    // 0 1 1 2 3 5 8 13 21 34
    public static void main(String args[]){
        System.out.println(recFib(10));
    }

    // Assuming 0th term = 0
    //          1st term, = 1
    public static int recFib(int n){
        if (n == 0) return 0;
        if (n == 1) return 1;

        int ret = recFib(n-1) + recFib(n-2);
        return ret;
    }
}
