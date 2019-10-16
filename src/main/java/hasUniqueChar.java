package main.java;

import java.util.Arrays;
import java.util.HashSet;

public class hasUniqueChar{

public static boolean hasUniqueCharSet(char[] input){
    HashSet<Character> mySet = new HashSet<Character>();
    for (int i = 0; i < input.length; i++){
        if (mySet.contains(input[i]) == true)
            return false; 
        mySet.add(input[i]);
    }
    return true;
}


public static void main(String args[]) {

  char[][] myInput = {
                      {'a'},
                      {'a', 'b', 'c', 'a'},
                      {'a', 'b', 'c', 'd'},
                      {'a', 'b', 'b', 'd'},
                      {'a', 'b', 'c', 'c'},
                      {' ', ' ', ' ', ' '}
                      };

  for (int i = 0; i < myInput.length; i++ ) {
    System.out.println("Array: " + Arrays.toString(myInput[i]) + hasUniqueCharSet(myInput[i]));
  }
  
}}

//public boolean hasUniqueChar(char[] input){
//    if (input == null)
//        throw new IllegalArgumentException();
//        
//    for(int i = 0; i < input.length-1; i++){
//        for (int j = i+1; j < input.length; j++){
//                if (input[i] == input[j])
//                    return false;
//        }//end for j
//    }//end for i
//    return true;
//}