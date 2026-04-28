package a1primitives;

public class CharacterClass {
    public static void main(String[] args) {
        // a = 97, Uppercase A = 65
        char myChar = 'a';
        int intValueOfChar = myChar - 0; // subtracting with zero is making the char to int conversion, essentailly same as  casting
        System.out.println("from myChar - 0 =" + intValueOfChar);
        System.out.println("from '9' - 0 = " + ('9' - 0));

        int asciiValue = (int) myChar;
        System.out.println("From type Casting "+asciiValue);
        int asciiValue2 = (int) 'a';
        System.out.println("ascii2 = " + asciiValue2);
        System.out.println("Ascii value of 9 ::"+ (int) '9');

        // Same can be achieved through the library method
        //Returns unicode for characters from 10 to 35
        System.out.println(Character.getNumericValue('A'));//DO NOT USE THIS
        System.out.println(Character.getNumericValue(myChar));
        System.out.println(Character.getNumericValue('1'));

        System.out.println(!Character.isLetterOrDigit('!'));//punctuation mark

        System.out.println(Character.isLetter('r'));
        System.out.println(Character.isDigit('4'));
        System.out.println(Character.compare('1','1'));//Compare character

        Character d = Character.valueOf('c');//From primitive to Wrapper
    }
}
