package algoEx;

/**
 * Created by nitin on Tuesday, April/07/2020 at 5:06 PM
 */
class Program {
    private static boolean flag = true;
    public static boolean isMonotonic(int[] array) {
        if(array == null || array.length == 0 || array.length == 1){
            return true;
        }

        //Check if its increasing array else decreasing
        if(array[0] < array[1]){
            increasingArray(array);
        }else if(array[0] > array[1]){//Decreasing array
            decreasingArray(array);
        }else{
            for(int i = 0; i < array.length-1; i++){
                if(array[i] != array[i+1]){
                    if(array[i] < array[i+1]){
                        increasingArray(array);
                    }else{
                        decreasingArray(array);
                    }
                }
            }
        }
        return flag;
    }

    private static void increasingArray(int[] array){
        for(int i = 0; i < array.length-1; i++){
            if(array[i] <= array[i+1]){
                flag = true;
            }else{
                flag=false;
                break;
            }
        }
    }

    private static void decreasingArray(int[] array){
        for(int i = 0; i < array.length-1; i++){
            if(array[i] >= array[i+1]){
                flag = true;
            }else{
                flag=false;
                break;
            }
        }
    }
}