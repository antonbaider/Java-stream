package jom.com.softserve.s6.task5;

import java.util.Map;
import java.util.stream.Stream;

public class MyUtils {

    public static Stream<String> nameList(Map<String, Stream<String>> map) {
        if (map == null) {
            throw new NullPointerException("Map cannot be null");
        }

        return map.values().stream()
                .filter(s -> s != null)
                .flatMap(s -> s)
                .filter(participant -> participant != null && !participant.trim().isEmpty())
                .map(String::trim)
                .map(name ->
                        Stream.of(name.split("\\s+"))
                                .map(word -> word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase())
                                .reduce((first, second) -> first + "" + second)
                                .orElse("")
                )
                .map(s -> s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase())
                .distinct()
                .sorted();
    }

    public static void main(String[] args) {
        // Example usage
        Map<String, Stream<String>> projectParticipants = Map.of(
                "Desktop", Stream.of(" iVan", "PeTro ", " Ira ", " i v  a n", "  Pet  ro  "),
                "Web", Stream.of("STepan", "ira ", " Andriy ", "an na"),
                "Spring", Stream.of("Ivan", "Anna")
        );

        // Get the sorted and unique name list with the first character in lowercase
        Stream<String> resultStream = nameList(projectParticipants);

        // Print the result
        resultStream.forEach(System.out::println);
    }
}
