package udemyJobInterview;

import java.util.HashMap;

/**
 * Created by Nitin Chaurasia on 1/28/2015.
 *
 * Program is case sensitive towards the test strings. There are many parsing checks that can be implemented
 */
public class UdemyRansomNote {
    public static void main(String[] args) {
        boolean b =  canRansom("This is semantics",
                "semantics hypothesis This my is test go");
        System.out.println(b);
    }

    public static boolean canRansom(String ransomNote, String magazine) {

        if(ransomNote.length() > magazine.length()){
            return false;
        }

        //Hash Map containing the occurrence of the
        HashMap<String,Integer> wordsLeft = new HashMap<String, Integer>();

        //Split the ransonNotes string and putting the words into HashMap
        String[] ransomWords = ransomNote.split(" ");
        for(String word : ransomWords){
            if(!wordsLeft.containsKey(word)){
                wordsLeft.put(word,0);//putting the word for the first time
            }
            //increment the count of the word occurrence
            wordsLeft.put(word,wordsLeft.get(word) + 1);//taking the value out by putting the key
        }

        //Maintaining the magazine
        String[] magazineWords = magazine.split(" ");
        for (String word : magazineWords){
            if(wordsLeft.containsKey(word)){
                int wordsCount = wordsLeft.get(word);
                wordsCount--;//Decrement the counter,a nd then save back in the Map
                if(wordsCount == 0){
                    // remove the word because word : 0 is one wntry and the Map will not be empty
                    wordsLeft.remove(word);
                }
                else{
                    wordsLeft.put(word,wordsCount);
                }
                if(wordsLeft.size() == 0)
                    return true;
            }
        }
        return false;
    }
}
