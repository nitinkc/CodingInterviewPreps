/*
 * Using names.txt (right click and 'Save Link/Target As...'), a 46K text file 
 * containing over five-thousand first names, begin by sorting it into
 * alphabetical order. Then working out the alphabetical value for each name, 
 * multiply this value by its alphabetical position in the list to obtain a name score.

For example, when the list is sorted into alphabetical order, COLIN, 
which is worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list. 
So, COLIN would obtain a score of 938 × 53 = 49714.

What is the total of all the name scores in the file?
 */

package solutionProjectEuler;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Prob22 {

	static Map<Character, Integer> map = new HashMap<>();

	public static void main(String[] args) {
		String str = null;
		int i=1;
		for(char ch = 'A'; ch <= 'Z'; ch++){// fills alphabet array with the alphabet
			map.put(ch,i++);
		}
		File myFile = new File("src/main/java/solutionProjectEuler/p022_names.txt");
		Scanner inputFile = null;
		try {
			inputFile = new Scanner(myFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		// Read  line from the file.
		//Keep the file outside the src folder.
		while (inputFile.hasNext()){//Reading the entile file as one line
			str = inputFile.nextLine();
		}
		//Close File
		inputFile.close();

		//Spliting the String into Tokens using regular Expression
		String delims = "[\" ,]+";//"Nitin", is Split into Nitin
		String[] tokens = str.split(delims);

		//Sorting the Array
		Arrays.sort(tokens);
		Integer bgi = 0;
		//Reading the tokens
		for (i = 0; i < tokens.length; i++){
			bgi = bgi + (i)*wordWeight(tokens[i]);
		}

		System.out.println(bgi);//Right answer 871198282

		}

	public static int wordWeight(String word){
		int weight=0;
		char[] alphabet = word.toCharArray(); // new array
        for (int i= 0; i < alphabet.length; i++){
			weight = weight+map.get(alphabet[i]);
		}
		return weight;
	}
}
