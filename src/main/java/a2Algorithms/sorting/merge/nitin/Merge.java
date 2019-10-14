package a2Algorithms.sorting.merge.nitin;

/**
 * Created by nitinc on 3/18/2015.
 */
public class Merge {
    public static void main(String args[]){
        int[] a = {2,4,6,7};
        int[] b = {1,3,5,8};

        int[] c = (merge(a,b));

        for (int i = 0; i < c.length; i++) {
            System.out.print(c[i] + " ");
        }
    }

    public static int[] merge(int[] a, int[] b) {
        int[] c = new int[a.length + b.length];
        int aIndex = 0;
        int bIndex = 0;

        for (int i = 0; i < c.length ; i++) {
            if(a[aIndex] <= b[bIndex]){
                c[i] = a[aIndex];
                aIndex++;
                if(aIndex == a.length){
                    aIndex = a.length - 1;
                }

            } else{
                c[i] = b[bIndex];
                bIndex++;
                if(bIndex == a.length){
                    bIndex = b.length - 1;
                }
            }
        }
        return c;
    }
}
