package crackingTheCoding;

import java.util.*;

/**
 * Created by Nitin Chaurasia on 4/10/16 at 7:02 PM.
 * Find if two Strings are ANAGRAMS or not.
 *
 * Correct implementation in one attempt!!
 */


public class CTC14 {
    public static void main(String[] args) {
        System.out.println(anagramsByMaps("cinema", "iceman"));//true
        System.out.println(anagramsBySorting("cinema", "iceman"));
    }

    private static boolean anagramsBySorting(String a, String b) {

        //Convert String to Char Array and then sort using Array.sort
        char temp1[] = a.toCharArray();
        char temp2[] = b.toCharArray();

        Arrays.sort(temp1);
        Arrays.sort(temp2);

        String temp11 = new String(temp1);
        String temp21 = new String(temp2);

        return temp11.equals(temp21);
    }

    // Keep the count of unique characters of one string in a map and
    // check if other the other string has the same unique character count
    private static boolean anagramsByMaps(String a, String b) {

        // Edge conditions checks etc.
        if (a.length() != b.length())
            return false;

        if (a.equals(b))
            return true;

        if (a == null && b == null)
            return false;

        Map<Character, Integer> map = new HashMap<>();//1.7 style generics use

        // Make a map of unique characters and its count
        for (int i = 0; i < a.length(); i++) {
            char currChar = a.charAt(i);
            fillMap(map, currChar);
            //map.put(currChar, map.getOrDefault(currChar,0)+1);
        }

        for (int i = 0; i < b.length(); i++) {
            char currChar = b.charAt(i);

            // if the map does have a character, reduce the count
            // if the second string has a character which is new, its not an anagram
            if (map.containsKey(currChar)){
                map.put(currChar, map.get(currChar) - 1);
            } else {
                return false;
            }
        }

        // Finally iterate through the map and check if all keys are 0, if > 0 or < 0
        // the two strings are not Anagrams

        Iterator<Character> itr = map.keySet().iterator();

        while (itr.hasNext()){
            int val = map.get(itr.next());

            if(val != 0)
                return false;
        }

        return true;
    }

    private static void fillMap(Map<Character, Integer> map, char currChar) {
        //if Map has the character increase the count else, put 1
        if (map.containsKey(currChar)){
            map.put(currChar, map.get(currChar) + 1);
        } else {
            map.put(currChar, 1);
        }
    }
}