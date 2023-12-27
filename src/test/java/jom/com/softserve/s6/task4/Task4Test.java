package jom.com.softserve.s6.task4;

import jom.com.softserve.s6.task4.MyUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class Task4Test {

    final private static String PACKAGE = "jom.com.softserve.s6.task4.";

    @DisplayName("Check that Classes is present")
    @ParameterizedTest
    @MethodSource("listOfClasses")
    void isTypePresent(String cl) {
        try {
            assertNotNull(Class.forName(PACKAGE + cl));
            assertEquals(cl, Class.forName(PACKAGE + cl).getSimpleName());
        } catch (ClassNotFoundException e) {
            fail("There is no class " + cl);
        }
    }

    private static Stream<Arguments> listOfClasses() {
        return Stream.of(Arguments.of("MyUtils"));
    }

    @DisplayName("Check that class contain method")
    @Test
    void isMethodPresent() {
        String cl = "MyUtils";
        String m = "readFile";
        Method[] methods = null;
        try {
            methods = Class.forName(PACKAGE + cl).getDeclaredMethods();
            boolean isMethod = false;
            for (Method method : methods) {
                if (method.getName().equals(m)) {
                    isMethod = true;
                    break;
                }
            }
            assertTrue(isMethod, "Class do not have method " + m);
        } catch (ClassNotFoundException e) {
            fail("There is no class " + cl);
        }
    }

    @DisplayName("Check that method readFile reed correct data from file")
    @ParameterizedTest
    @MethodSource("getDataFromFile")
    void isDataCorrect(String filename, String expectedResult) {
        Path fileName = Path.of(filename);
        try {
            String s = Files.readString(fileName);
            assertEquals(MyUtils.readFile(filename), expectedResult);
        } catch (IOException e) {
            fail("File have not created " + e);
        }
    }

    private static Stream<Arguments> getDataFromFile() {
        return Stream.of(Arguments.of("data1.txt", "Example of text for test case #1"),
                Arguments.of("data2.txt", "Example of text\nfor test case #2"),
                Arguments.of("data3.txt", "Example of\ntext for\ntest case #3"));
    }

}
