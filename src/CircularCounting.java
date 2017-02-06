/**
 * Created by Nitin Chaurasia on 12/17/16 at 1:04 AM.
 */
public class CircularCounting {
    public static void main(String[] args) {

        countForward(7);
        countBackwards(7);
    }

    private static void countForward(int count){
        int print = 0;

        //TESTING THE PROGRAM BY RUNNING 4 times SETS OF COUNTS
        for (int i = 1; i <= 4*count; i++){
            System.out.println(i+ " Forward Count : " + print );
            print = (print + 1) % count;
        }
    }

    private static void countBackwards(int count){
        int print = 0;
        for (int i = 1; i <= 4*count; i++){
            // Re-setting the count to max
            if (print < 0)
                print = count - 1;
            System.out.println(i+ " Backwards Count : " + print );
            print = (print - 1) % count;
        }
    }

}
