package a3DataStructures.bigOh;

/**
 * @Author Created by nichaurasia
 * @create on Saturday, January/23/2021 at 1:15 PM
 */

public class TimeComplexities {
    public static void logNComplexity2(int n,int constant){
        System.out.println();
        for (int i = 1; i <=n; i *= constant) {
            System.out.print(i +"\t");//O(1) expression
        }
        System.out.println();
        for (int i = n; i > 0; i /= constant) {
            System.out.print(i +"\t");//O(1) expression
        }
        System.out.println("Time Complexity is O(logc(n)) log with base 2");
    }

    public static void logNComplexity3(int n){
        for (int i = 1;i<n;i=i*3) {
            System.out.print(i +"\t");
        }
        System.out.println();
        System.out.println("Time Complexity is O(log(n)) log with base 3");
    }

    public static void OnTimeComplexity(int n, int constant){
        // constant positive integer constant
        for (int i = 1; i <= n; i += constant) {
            System.out.print(i +"\t");
        }

        System.out.println();
        for (int i = n; i > 0; i -= constant) {
            System.out.print(i +"\t");
        }

        System.out.println();
        System.out.println("Time Complexity is O(n)");
    }

    public static void On2TimeComplexity(int n,int constant) {
        for (int i = 1; i <= n; i += constant) {
            for (int j = 1; j <= n; j += constant) {
                System.out.print(i + "\t");
            }
            System.out.println();
        }

        System.out.println();
        for (int i = n; i > 0; i -= constant) {
            for (int j = i + 1; j <= n; j += constant) {
                System.out.print(i + "\t");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("Time Complexity is O(n^2)");
    }

    public static void logLogNTimeComplexity(int n, int constant){
        // c is a constant greater than 1
        for (int i = 2; i <=n; i = (int) Math.pow(i, constant)) {
            System.out.print(i + "\t");
        }
        System.out.println();

        //For higher powers, keep cube root, fourth root etc.
        for (int i = n; i > 1; i = (int) Math.sqrt(i)) {
            System.out.print(i + "\t");
        }
    }
}
