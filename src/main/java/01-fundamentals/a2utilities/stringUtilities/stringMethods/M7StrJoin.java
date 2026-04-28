package a2utilities.stringUtilities.stringMethods;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class M7StrJoin {
    public static void main(String[] args) {
        String whiteSpace = "  sentence with white space  ";

        String join = String.join(",", whiteSpace.trim(),"abc");
        System.out.println(join);

        List<String> list = Arrays.asList(whiteSpace.strip().split(" "));
        // No more Off-By-One Issue
        String joinFromList = String.join(", ", list);
        System.out.println(joinFromList);

        String combinedString = list.stream()
                .map(String::toUpperCase)
                .collect(Collectors.joining(" && "));
        System.out.println(combinedString);
    }
}
