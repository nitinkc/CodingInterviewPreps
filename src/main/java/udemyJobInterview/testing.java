package udemyJobInterview;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nitin Chaurasia on 3/8/17 at 8:53 PM.
 */
public class testing {
    private static int count;
    static {
        System.out.println("In block 1");
        count = 10;
    }

    private int[] data;
    {
        System.out.println("In block 2");
        data = new int[count];
        for (int i = 0; i < count; i++) {
            data[i] = i;
        }
    }

    public static void main (String[] args) {
        System.out.println("Count = " + count);
        System.out.println("Before 1st call to new");
        testing test1 = new testing();
        System.out.println("Before 2nd call to new");
        testing test2 = new testing();
    }
}