package main.java;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class HasUniqueCharJava8 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Character","Pneunomonia", "run", "walk");

        for (String str : list) {
            //System.out.println(str + " :: unique characters?? " + hasUniqueChar(str));
            hasUniqueChar(str);
        }
    }

    private static void hasUniqueChar(String str){
        Set<Character> set = new LinkedHashSet<>();
        Function<Character,Boolean> p = c -> set.add(c);

        str.chars()
                .mapToObj(c->(char)c)
                .map(x -> p.apply(x))
                .forEach(System.out::println);
    }
}
