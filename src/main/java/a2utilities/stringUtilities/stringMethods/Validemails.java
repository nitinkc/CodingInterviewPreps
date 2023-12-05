package a2utilities.stringUtilities.stringMethods;


import a2utilities.stringUtilities.IncorrectEmailIdException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Validemails {
    public static void main(String[] args) {
        List<String> emails = Arrays.asList("deepthi", "deepthi.davita@gmail.com", "nitin.chaurasia@tcs.com");
        List<String> validEmail = new ArrayList<>();
         emails
                 //.stream() // emails.stream.forEach() will take elements one by one from the list, ignoring the iterator.
                .forEach(email->{  // forEach() directly uses custom iterator
                    if(email.matches("^(.+)@(.+)$")){
                        validEmail.add(email);
                    } else{
                        try {
                            throw new IncorrectEmailIdException(email);
                        } catch (IncorrectEmailIdException e) {

                        }
                    }
                    return;
                });
        System.out.println(validEmail);
    }
}
