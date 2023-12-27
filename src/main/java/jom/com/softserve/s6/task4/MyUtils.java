package jom.com.softserve.s6.task4;

import java.io.*;
import java.util.Arrays;
import java.util.Locale;

public class MyUtils {

    public static String readFile (String filename){
        StringBuilder result = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;

            while ((line = reader.readLine()) != null) {

                result.append(convertBinaryStringToText(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result.toString();
    }

    private static String convertBinaryStringToText (String binaryString){
        StringBuilder text = new StringBuilder();
        int length = binaryString.length();

        for (int i = 0; i < length; i += 7) {
            String sevenBits = binaryString.substring(i, Math.min(i + 7, length));
            int decimalValue = Integer.parseInt(sevenBits, 2);
            text.append((char) decimalValue);
        }

        return text.toString();
    }

}
