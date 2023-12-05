package a2utilities.stringUtilities.stringMethods;

import java.util.Arrays;
import java.util.List;

public class M3StrSplits {
    public static void main(String[] args) {
        String str = "Nd1;Nh3;Gh5";

        List<String> tokens = Arrays.asList(str.split(";"));
        System.out.println(tokens);
    }
}
