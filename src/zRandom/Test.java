package zRandom;

/**
 *
 * If the list has -1, its the end of the list
 *
 * Thus the length is = the value of the element containing the index of -1
 *
 */
public class Test {

    public static void main(String[] args) {
        int arr[] = {1,4,9,3,2,-1};
        System.out.println(solution(arr));
    }


    public static int solution(int[] A) {
        int size = 0;

        int head = A[0];
        int runner = head;
        int next = A[A[0]];

        while (A[runner] == -1){
            next = A[runner];
            runner = next;
        }

        return A[runner]+1;
    }
}

