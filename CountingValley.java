package com.company;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class CountingValley {

    // Complete the countingValleys function below.
    static int countingValleys(int n, String s) {
    char[] sequenceOfCharacters = s.toCharArray();
    int level = 0;
    int Dlevel=-1,Ulevel=1,valleys=0;
    for(char altitude : sequenceOfCharacters)
    {
        if(altitude=='D')
            level = level + Dlevel;
        else
            level = level + Ulevel;

        if(level==0)
            valleys++;
    }
    return valleys;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int result = countingValleys(n, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
