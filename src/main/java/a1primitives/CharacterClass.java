package a1primitives;

public class CharacterClass {
    public static void main(String[] args) {
        //a = 97,  Uppercase A = 65
        char c = 'a';
        int intValueOfChar = c - 0;

        System.out.println(intValueOfChar);

        //Same can be achieved through the library method
        System.out.println(Character.getNumericValue('A'));//Gets unicode character

        System.out.println(Character.getNumericValue('a'));//Gets unicode character

    }
}
