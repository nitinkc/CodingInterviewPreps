package a2utilities.stringUtilities.stringMethods;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class M6StrContainsAndMatchs {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Rakeshreddy reddy", "Kavita Reddy", "Malvika malkireddy",
                "yogitha malgireddy", "Deepthi Vempati", "Reddy", "redDy");
        List<String> list1 = list
                .stream()
                //.filter(s -> s.matches("[rR][eE][dD][dD][yY]"))
                .filter((s -> s.contains("Reddy")))
                .collect(Collectors.toList());
        System.out.println(list1);

        boolean matches = list.get(0).matches("[rR][eE][dD][dD][yY]");
        System.out.println(matches);

        String sentence = "Hello, world!";
        // Check if the string contains a specific substring
        boolean containsHello = sentence.contains("Hello");

        String phoneNumber = "123-456-7890";
        // Check if the string matches a regular expression for a phone number
        boolean isValidPhoneNumber = phoneNumber.matches("\\d{3}-\\d{3}-\\d{4}");
    }
}
