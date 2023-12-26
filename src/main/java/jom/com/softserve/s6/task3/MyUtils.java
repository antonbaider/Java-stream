package jom.com.softserve.s6.task3;

import java.io.FileOutputStream;
import java.io.IOException;

public class MyUtils {
    public static void writeFile(String filename, String text) {
            try (FileOutputStream outputStream = new FileOutputStream(filename)) {
                byte[] textBytes = text.getBytes("UTF-8");
                for (byte b : textBytes) {

                    for (int i = 6; i >= 0; i--) {
                        int bit = (b >> i) & 1;
                        outputStream.write(bit + '0');
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
