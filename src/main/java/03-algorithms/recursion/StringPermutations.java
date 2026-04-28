package recursion;

public class StringPermutations {
    public static void main(String[] args) {
        String str = "AAAA";
        listPermutations( str);
    }

    public static void listPermutations(String str) {
        listPermutations("", str);
    }

    private static void listPermutations(String prefix, String str) {
        int n = str.length();
        if (n == 0)
            System.out.println(prefix);
        else {
            for (int i = 0; i < n; i++) {
                // Remove the character at index i
                char c = str.charAt(i);
                //Prepare the String with the rest of the characters
                String rem = str.substring(0, i) //String upto i, not including it
                        + str.substring(i + 1);//String from i to the end

                // Recursively call listPermutations with the remaining string
                listPermutations(prefix + c, rem);
            }
        }
    }
}
